package es.ulpgc.montesdeoca110.cristina.zonget.administratorUsersAddPet;

import es.ulpgc.montesdeoca110.cristina.zonget.data.RepositoryContract;

public class AdministratorUsersAddPetModel implements AdministratorUsersAddPetContract.Model {

  public static String TAG = AdministratorUsersAddPetModel.class.getSimpleName();

  private final RepositoryContract.Accounts repository;

  public AdministratorUsersAddPetModel(RepositoryContract.Accounts repository) {
    this.repository = repository;
  }


  @Override
  public void insertNewPet(int userID, String name, String species, String breed, String chipNum, String birthday, final RepositoryContract.Accounts.InsertNewUserPetCallback callback) {
    repository.insertNewPet(userID,name,species,breed,chipNum,birthday, callback);
  }
}
