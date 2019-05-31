package es.ulpgc.montesdeoca110.cristina.zonget.data;

import android.arch.persistence.room.Room;
import android.content.Context;
import android.os.AsyncTask;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import es.ulpgc.montesdeoca110.cristina.zonget.app.QueryData;
import es.ulpgc.montesdeoca110.cristina.zonget.app.Query;
import es.ulpgc.montesdeoca110.cristina.zonget.app.QueryItem;
import es.ulpgc.montesdeoca110.cristina.zonget.app.QueryStatusItem;
import es.ulpgc.montesdeoca110.cristina.zonget.database.QueriesDao;
import es.ulpgc.montesdeoca110.cristina.zonget.database.QueryAnswersDao;
import es.ulpgc.montesdeoca110.cristina.zonget.database.QueryStatusDao;
import es.ulpgc.montesdeoca110.cristina.zonget.database.ZongetDatabase;

public class QueriesRepository implements RepositoryContract.Queries {

    public static final String DB_FILE = "zonget.db";
    private static QueriesRepository INSTANCE;

    private ZongetDatabase database;
    private Context context;

    public static QueriesRepository getInstance(Context context) {
        if (INSTANCE == null) {
            INSTANCE = new QueriesRepository(context);
        }
        return INSTANCE;
    }

    private QueriesRepository(Context context) {
        this.context = context;

        database = Room.databaseBuilder(context, ZongetDatabase.class, DB_FILE).build();
    }

    @Override
    public void setNewQuery(final int senderUserId, final String title, final String content, final SetNewQueryCallback callback) {
        AsyncTask.execute(new Runnable() {
            @Override
            public void run() {
                if(callback != null){
                    int queryId = getQueriesDao().loadQueries().size();
                    QueryItem query = new QueryItem(queryId,title, content);
                    query.userId = senderUserId;

                    int queryStatusId = getQueryStatusDao().loadQueryStatus().size();
                    QueryStatusItem queryStatus = new QueryStatusItem(queryStatusId,queryId,false);

                    getQueriesDao().insertQuery(query);
                    getQueryStatusDao().insertQueryStatus(queryStatus);
                    callback.onNewQuerySet(true);
                }
            }
        });
    }

    @Override
    public void getPendindQueriesList(final int userId, final GetPendingQueriesListCallback callback) {
        AsyncTask.execute(new Runnable() {
            @Override
            public void run() {
                if (callback != null){

                    List<QueryItem> pendindQueriesList = loadPendingQueries(userId);

                    List<String> queriesTitlesList = new ArrayList<>();
                    HashMap<String,List<String>> queriesDetailList = new HashMap<>();

                    for (int i = 0; i < pendindQueriesList.size(); i++){
                        QueryItem query = pendindQueriesList.get(i);

                        queriesTitlesList.add(query.title);

                        List<String> queryDetails = new ArrayList<>();
                        queryDetails.add(query.content);

                        queriesDetailList.put(query.title,queryDetails);
                    }

                    callback.setQueriesList(queriesTitlesList, queriesDetailList);
                }
            }
        });

    }

    @Override
    public void getFinishedQueriesList(final int userId, final GetFinishedQueriesListCallback callback) {
        AsyncTask.execute(new Runnable() {
            @Override
            public void run() {
                if(callback != null){
                    List<Query>  finishedQueriesList = loadFinishedQueries(userId);
                    callback.setQueriesList(finishedQueriesList);
                }
            }
        });
    }

    //---------------------------- Métodos privados ----------------------------------

    private QueriesDao getQueriesDao(){
        return database.queriesDao();
    }

    private QueryStatusDao getQueryStatusDao(){
        return database.queryStatusDao();
    }

    private QueryAnswersDao getQueriesAnswerDao(){
        return database.queryAnswersDao();
    }

    private List<QueryItem> loadQueries(int userId){
        return getQueriesDao().loadQueries(userId);
    }

    private List<QueryItem> loadPendingQueries(int userId){
        List<QueryItem> pendingQueriesList =  new ArrayList<>();
        List<QueryItem> list = loadQueries(userId);

        for(int i = 0; i < list.size(); i++ ){
            QueryStatusItem queryStatus = getQueryStatusDao().loadQueryStatus(list.get(i).id);
            if (!queryStatus.finished){
                pendingQueriesList.add(list.get(i));
            }
        }

        return pendingQueriesList;
    }

    private List<Query> loadFinishedQueries(int userId){
        List<Query> finishedQueriesList =  new ArrayList<>();

        List<QueryItem> list = loadQueries(userId);

        for(int i = 0; i < list.size(); i++ ){
            QueryStatusItem queryStatus = getQueryStatusDao().loadQueryStatus(list.get(i).id);
            if (queryStatus.finished){

                String title = list.get(i).title;
                String content =  list.get(i).content;
                String answer = getQueriesAnswerDao().loadQueryAnswer(list.get(i).id).answer;

                List<QueryData> queryDataList =  new ArrayList<>();
                queryDataList.add(new QueryData(content,answer));

                Query query = new Query(title,queryDataList);

                finishedQueriesList.add(query);
            }
        }

        return finishedQueriesList;

    }
}
