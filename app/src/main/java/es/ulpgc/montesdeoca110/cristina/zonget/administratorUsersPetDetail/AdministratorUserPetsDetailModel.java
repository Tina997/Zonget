package es.ulpgc.montesdeoca110.cristina.zonget.administratorUsersPetDetail;

import es.ulpgc.montesdeoca110.cristina.zonget.app.UserPetItem;
import es.ulpgc.montesdeoca110.cristina.zonget.data.RepositoryContract;

public class AdministratorUserPetsDetailModel implements AdministratorUserPetsDetailContract.Model {

  public static String TAG = AdministratorUserPetsDetailModel.class.getSimpleName();

  private final RepositoryContract.Accounts repository;

  public AdministratorUserPetsDetailModel(RepositoryContract.Accounts repository) {
    this.repository = repository;
  }

  @Override
  public String fetchData() {
    return null;
  }

  @Override
  public void deletePet(UserPetItem pet, RepositoryContract.Accounts.DeleteUserPetCallback deleteUserPetCallback) {
    repository.deleteUserPet(pet,deleteUserPetCallback);
  }
}
