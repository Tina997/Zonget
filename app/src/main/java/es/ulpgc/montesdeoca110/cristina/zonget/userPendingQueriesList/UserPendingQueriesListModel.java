package es.ulpgc.montesdeoca110.cristina.zonget.userPendingQueriesList;

import es.ulpgc.montesdeoca110.cristina.zonget.data.RepositoryContract;

public class UserPendingQueriesListModel implements UserPendingQueriesListContract.Model {

  private final RepositoryContract.Queries repository;

  public UserPendingQueriesListModel(RepositoryContract.Queries repository) {
    this.repository = repository;
  }

  @Override
  public void fetchUserPendingQueriesListData(int userId,
                                              RepositoryContract.Queries.GetPendingQueriesListCallback callback) {
    repository.getPendindQueriesList(userId, callback);
  }

}
