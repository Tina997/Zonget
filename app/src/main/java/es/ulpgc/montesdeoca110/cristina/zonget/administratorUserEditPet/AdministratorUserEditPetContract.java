package es.ulpgc.montesdeoca110.cristina.zonget.administratorUserEditPet;

import java.lang.ref.WeakReference;

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
  }

  interface Model {
    String fetchData();
  }

  interface Router {
    void navigateToNextScreen();

    void passDataToNextScreen(AdministratorUserEditPetState state);

    AdministratorUserEditPetState getDataFromPreviousScreen();

    String getActualThemeName();

    void onBackButtonPressed();
  }
}
