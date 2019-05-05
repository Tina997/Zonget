package es.ulpgc.montesdeoca110.cristina.zonget.signUp;

import es.ulpgc.montesdeoca110.cristina.zonget.app.AccountItem;
import es.ulpgc.montesdeoca110.cristina.zonget.data.RepositoryContract;

public class SignUpModel implements SignUpContract.Model {

  private RepositoryContract.Accounts repository;

  public SignUpModel(RepositoryContract.Accounts repository) {
    this.repository = repository;
  }

  @Override
  public void checkNewAccount(final String accountDni, final String accountEmail,
                              final RepositoryContract.Accounts
                                      .CheckNewAccountDataExistCallback callback) {
    repository.loadZonget(false, new RepositoryContract.Accounts.FecthZongetDataCallback() {
      @Override
      public void onZongetDataFetched(boolean error) {
        if (!error) {
          repository.checkNewAccountDataExist(accountDni, accountEmail, callback);
        }
      }
    });
  }

  @Override
  public void insertNewAccount(final AccountItem account,
                               final RepositoryContract.Accounts
                                       .InsertNewAccountCallback callback) {
    repository.insertNewAccount(account, callback);
  }

}
