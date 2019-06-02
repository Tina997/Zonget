package es.ulpgc.montesdeoca110.cristina.zonget.userFinishedQueriesList;

import es.ulpgc.montesdeoca110.cristina.zonget.data.RepositoryContract;

public class UserFinishedQueriesListModel implements UserFinishedQueriesListContract.Model {

  private final RepositoryContract.Queries repository;

  public UserFinishedQueriesListModel(RepositoryContract.Queries repository) {
    this.repository = repository;
  }

  @Override
  public void fetchUserFinishedQueriesListData(int userId, RepositoryContract.Queries.GetFinishedQueriesListCallback callback) {
    repository.getFinishedQueriesList(userId, callback);
  }
}
