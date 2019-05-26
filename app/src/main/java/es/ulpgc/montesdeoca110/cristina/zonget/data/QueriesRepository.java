package es.ulpgc.montesdeoca110.cristina.zonget.data;

import android.arch.persistence.room.Room;
import android.content.Context;
import android.os.AsyncTask;

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
                    int queryId = getQueriesDao().loadQueries().size() +1 ;
                    QueryItem query = new QueryItem(queryId,title, content);
                    query.userId = senderUserId;

                    QueryStatusItem queryStatus = new QueryStatusItem(queryId,false);

                    getQueriesDao().insertQuery(query);
                    getQueryStatusDao().insertQueryStatus(queryStatus);

                    callback.onNewQuerySet(true);
                }
            }
        });
    }

    @Override
    public void getPendindQueriesList(int userId, GetPendingQueriesListCallback callback) {

    }

    @Override
    public void getFinishedQueriesList(int userId, GetFinishedQueriesListCallback callback) {

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

}
