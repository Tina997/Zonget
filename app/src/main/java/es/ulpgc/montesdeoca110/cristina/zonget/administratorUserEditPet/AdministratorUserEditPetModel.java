package es.ulpgc.montesdeoca110.cristina.zonget.administratorUserEditPet;

import es.ulpgc.montesdeoca110.cristina.zonget.app.UserPetItem;
import es.ulpgc.montesdeoca110.cristina.zonget.data.RepositoryContract;

public class AdministratorUserEditPetModel implements AdministratorUserEditPetContract.Model {

  public static String TAG = AdministratorUserEditPetModel.class.getSimpleName();

  RepositoryContract.Accounts repository;

  public AdministratorUserEditPetModel(RepositoryContract.Accounts repository) {
    this.repository = repository;
  }

  @Override
  public String fetchData() {
    return null;
  }

  @Override
  public void editPet(UserPetItem userPetItem, RepositoryContract.Accounts.UpdateNewUserPetCallback callback) {
    repository.updatePet(userPetItem,callback);
  }
}
