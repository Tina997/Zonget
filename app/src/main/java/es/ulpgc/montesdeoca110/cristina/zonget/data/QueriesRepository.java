package es.ulpgc.montesdeoca110.cristina.zonget.data;

import android.arch.persistence.room.Room;
import android.content.Context;

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
    public void setNewQuery(String title, String Content, SetNewQueryCallback callback) {

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

    private QueryAnswersDao getQueryAnswerDao(){
        return database.queryAnswersDao();
    }

}
