package es.ulpgc.montesdeoca110.cristina.zonget.data;

import android.annotation.SuppressLint;
import android.arch.persistence.room.Room;
import android.content.Context;
import android.os.AsyncTask;

import java.util.ArrayList;
import java.util.List;

import es.ulpgc.montesdeoca110.cristina.zonget.app.QueryAnswerItem;
import es.ulpgc.montesdeoca110.cristina.zonget.app.QueryData;
import es.ulpgc.montesdeoca110.cristina.zonget.app.Query;
import es.ulpgc.montesdeoca110.cristina.zonget.app.QueryItem;
import es.ulpgc.montesdeoca110.cristina.zonget.app.QueryStatusItem;
import es.ulpgc.montesdeoca110.cristina.zonget.database.QueriesDao;
import es.ulpgc.montesdeoca110.cristina.zonget.database.QueryAnswersDao;
import es.ulpgc.montesdeoca110.cristina.zonget.database.QueryStatusDao;
import es.ulpgc.montesdeoca110.cristina.zonget.database.ZongetDatabase;

public class QueriesRepository implements RepositoryContract.Queries {

  // ============================= Variables globales ===========================================

  @SuppressLint("StaticFieldLeak")
  private static QueriesRepository INSTANCE;

  private static final String DB_FILE = "zonget.db";

  private ZongetDatabase database;

  public static QueriesRepository getInstance(Context context) {
    if (INSTANCE == null) {
      INSTANCE = new QueriesRepository(context);
    }
    return INSTANCE;
  }

  private QueriesRepository(Context context) {
    database = Room.databaseBuilder(context, ZongetDatabase.class, DB_FILE).build();
  }

  // ==================================== Métodos ===============================================


  @Override
  public void getQueriesListSize(final int userId, final GetQueriesListSizeCallback callback) {
    AsyncTask.execute(new Runnable() {
      @Override
      public void run() {
        if (callback != null) {
          List<Query> pendindQueriesList = loadPendingQueries(userId);
          List<Query> finishedQueriesList = loadFinishedQueries(userId);

          callback.setQueriesListSize(pendindQueriesList.size(), finishedQueriesList.size());
        }
      }
    });
  }

  @Override
  public void setNewQuery(final int senderUserId, final String title, final String content, final SetNewQueryCallback callback) {
    AsyncTask.execute(new Runnable() {
      @Override
      public void run() {
        if (callback != null) {
          int queryId = getQueriesDao().loadQueries().size();
          QueryItem query = new QueryItem(queryId, title, content);
          query.userId = senderUserId;

          int queryStatusId = getQueryStatusDao().loadQueryStatus().size();
          QueryStatusItem queryStatus = new QueryStatusItem(queryStatusId, queryId, false);

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
        if (callback != null) {

          List<Query> pendindQueriesList = loadPendingQueries(userId);
          callback.setQueriesList(pendindQueriesList);
        }
      }
    });

  }

  @Override
  public void getFinishedQueriesList(final int userId, final GetFinishedQueriesListCallback callback) {
    AsyncTask.execute(new Runnable() {
      @Override
      public void run() {
        if (callback != null) {
          List<Query> finishedQueriesList = loadFinishedQueries(userId);
          callback.setQueriesList(finishedQueriesList);
        }
      }
    });
  }

  @Override
  public void setQueryAnswer(final QueryItem query, final String answer, final SetQueryAnswerCallback callback) {
    AsyncTask.execute(new Runnable() {
      @Override
      public void run() {
        if (callback != null) {
          int queryAnswerId = getQueriesAnswerDao().loadQueryAnswers().size();
          QueryAnswerItem queryAnswerItem = new QueryAnswerItem(queryAnswerId, query.id, answer);
          getQueriesAnswerDao().insertQueryAnswer(queryAnswerItem);
          int queryStatusId = getQueryStatusDao().loadQueryStatus(query.id).id;
          QueryStatusItem queryStatusItem = new QueryStatusItem(queryStatusId, query.id, true);
          getQueryStatusDao().insertQueryStatus(queryStatusItem);
          callback.onQueryAnswerSet(true);
        }
      }
    });
  }

  @Override
  public void getAdministratorQueriesList(final GetAdministratorQueriesListCallback callback) {
    AsyncTask.execute(new Runnable() {
      @Override
      public void run() {
        if (callback != null) {
          List<QueryItem> administratorQueryList = loadAdministratorQueries();
          callback.setAdministratorQueriesList(administratorQueryList);


        }
      }
    });
  }

  // ================================= Métodos privados =========================================

  /**
   * Este método obtiene la tabla de base de datos correspondiente a las consultas.
   *
   * @return Tabla "query".
   */
  private QueriesDao getQueriesDao() {
    return database.queriesDao();
  }

  /**
   * Este método obtiene la tabla de base de datos correspondiente al estado de las consultas.
   *
   * @return Tabla "queryStatus".
   */
  private QueryStatusDao getQueryStatusDao() {
    return database.queryStatusDao();
  }

  /**
   * Este método obtiene la tabla de base de datos correspondiente a las respuestas de las
   * consultas.
   *
   * @return Tabla "queryAnswer".
   */
  private QueryAnswersDao getQueriesAnswerDao() {
    return database.queryAnswersDao();
  }

  /**
   * Este método obtiene todas las consultas de una determinada cuenta.
   *
   * @param userId Identificador de la cuenta.
   * @return Lista de consultas.
   */
  private List<QueryItem> loadQueries(int userId) {
    return getQueriesDao().loadQueries(userId);
  }

  /**
   * Este método obtiene todas las consultas que hay en la base de datos.
   *
   * @return Lista de consultas.
   */
  private List<QueryItem> loadAllQueries() {
    return getQueriesDao().loadQueries();
  }

  /**
   * Este método obtiene todas las consultas pendientes de un usuario.
   *
   * @param userId Identificador de la cuenta.
   * @return Lista de consultas pendientes de respuesta.
   */
  private List<Query> loadPendingQueries(int userId) {
    List<Query> pendingQueriesList = new ArrayList<>();

    List<QueryItem> list = loadQueries(userId);

    for (int i = 0; i < list.size(); i++) {
      QueryStatusItem queryStatus = getQueryStatusDao().loadQueryStatus(list.get(i).id);
      if (!queryStatus.finished) {

        String title = list.get(i).title;
        String content = list.get(i).content;

        List<QueryData> queryDataList = new ArrayList<>();
        queryDataList.add(new QueryData(content, null));

        Query query = new Query(title, queryDataList);

        pendingQueriesList.add(query);
      }
    }
    return pendingQueriesList;
  }

  /**
   * Este método obtiene todas las consultas finalizadas de un usuario.
   *
   * @param userId Identificador de la cuenta.
   * @return Lista de consultas con respuesta.
   */
  private List<Query> loadFinishedQueries(int userId) {
    List<Query> finishedQueriesList = new ArrayList<>();

    List<QueryItem> list = loadQueries(userId);

    for (int i = 0; i < list.size(); i++) {
      QueryStatusItem queryStatus = getQueryStatusDao().loadQueryStatus(list.get(i).id);
      if (queryStatus.finished) {

        String title = list.get(i).title;
        String content = list.get(i).content;
        String answer = getQueriesAnswerDao().loadQueryAnswer(list.get(i).id).answer;

        List<QueryData> queryDataList = new ArrayList<>();
        queryDataList.add(new QueryData(content, answer));

        Query query = new Query(title, queryDataList);

        finishedQueriesList.add(query);
      }
    }
    return finishedQueriesList;
  }

  /**
   * Este método obtiene todas las consultas pendientes que hay en la base de datos.
   *
   * @return Lista de consultas.
   */

  private List<QueryItem> loadAdministratorQueries() {
    List<QueryItem> administratorQueriesList = new ArrayList<>();

    List<QueryItem> list = loadAllQueries();

    for (int i = 0; i < list.size(); i++) {
      QueryStatusItem queryStatus = getQueryStatusDao().loadQueryStatus(list.get(i).id);
      if (!queryStatus.finished) {
        administratorQueriesList.add(list.get(i));
      }
    }
    return administratorQueriesList;
  }

}
