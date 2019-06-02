package es.ulpgc.montesdeoca110.cristina.zonget.administratorInbox;

import es.ulpgc.montesdeoca110.cristina.zonget.data.RepositoryContract;

public class AdministratorInboxModel implements AdministratorInboxContract.Model {

  private final RepositoryContract.Queries queriesRepository;
  private final RepositoryContract.Accounts accountsRepository;

  public static String TAG = AdministratorInboxModel.class.getSimpleName();


  public AdministratorInboxModel(RepositoryContract.Queries queriesRepository,
                                 RepositoryContract.Accounts accountsRepository) {
    this.queriesRepository = queriesRepository;
    this.accountsRepository = accountsRepository;
  }

  @Override
  public void fetchAdministratorQueriesListData(RepositoryContract.Queries.
                                                        GetAdministratorQueriesListCallback callback) {
    queriesRepository.getAdministratorQueriesList(callback);
  }

  @Override
  public void getUserName(int userId, RepositoryContract.Accounts.GetUserNameCallback callback) {
    accountsRepository.getUserName(userId, callback);
  }


}
