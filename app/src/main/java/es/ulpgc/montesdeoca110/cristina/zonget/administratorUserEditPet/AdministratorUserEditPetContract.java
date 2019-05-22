package es.ulpgc.montesdeoca110.cristina.zonget.administratorUserEditPet;

import java.lang.ref.WeakReference;

import es.ulpgc.montesdeoca110.cristina.zonget.app.UserPetItem;

interface AdministratorUserEditPetContract {

  interface View {
    void injectPresenter(Presenter presenter);

    void displayData(AdministratorUserEditPetViewModel viewModel);
  }

  interface Presenter {
    void injectView(WeakReference<View> view);

    void injectModel(Model model);

    void injectRouter(Router router);

    void fetchData();

    void insertNewPet();

    String getActualThemeName();

    void onBackButtonPressed();

    UserPetItem fetchPetData();
  }

  interface Model {
    String fetchData();
  }

  interface Router {
    void navigateToNextScreen();

    void passDataToNextScreen(AdministratorUserEditPetState state);

    UserPetItem getDataFromPreviousScreen();

    String getActualThemeName();

    void onBackButtonPressed();
  }
}
