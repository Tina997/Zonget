package es.ulpgc.montesdeoca110.cristina.zonget.administratorUsersAddPet;

import java.lang.ref.WeakReference;

import es.ulpgc.montesdeoca110.cristina.zonget.data.RepositoryContract;

interface AdministratorUsersAddPetContract {

  interface View {
    void injectPresenter(Presenter presenter);

    void displayData(AdministratorUsersAddPetViewModel viewModel);
  }

  interface Presenter {
    void injectView(WeakReference<View> view);

    void injectModel(Model model);

    void injectRouter(Router router);

    void fetchData();

    void insertNewPet(String name, String species, String breed, String chipNum, String birthday);

    String getActualThemeName();

    void onBackButtonPressed();
  }

  interface Model {
    String fetchData();

    void insertNewPet(int userID, String name, String species, String breed, String chipNum, String birthday, RepositoryContract.Accounts.InsertNewUserPetCallback callback);
  }

  interface Router {
    void navigateToNextScreen();

    void passDataToNextScreen(AdministratorUsersAddPetState state);

    AdministratorUsersAddPetState getDataFromPreviousScreen();

    String getActualThemeName();

    void onBackButtonPressed();
  }
}
