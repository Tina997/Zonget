package es.ulpgc.montesdeoca110.cristina.zonget.userQueriesMenu;

import es.ulpgc.montesdeoca110.cristina.zonget.data.RepositoryContract;

public class UserQueriesMenuModel implements UserQueriesMenuContract.Model {

  private RepositoryContract.Queries repository;

  public UserQueriesMenuModel(RepositoryContract.Queries repository) {
    this.repository = repository;
  }

  @Override
  public void fetchUserQueriesMenuData(int userdId, RepositoryContract.Queries.GetQueriesListSizeCallback callback) {
    repository.getQueriesListSize(userdId,callback);
  }

}
