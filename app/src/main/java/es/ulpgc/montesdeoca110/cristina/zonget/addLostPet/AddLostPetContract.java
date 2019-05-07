package es.ulpgc.montesdeoca110.cristina.zonget.addLostPet;

import java.lang.ref.WeakReference;

interface AddLostPetContract {

  interface View {
    void injectPresenter(Presenter presenter);

    void displayData(AddLostPetViewModel viewModel);
  }

  interface Presenter {
    void injectView(WeakReference<View> view);

    void injectModel(Model model);

    void injectRouter(Router router);

    void fetchData();

    String getActualThemeName();

    void onBackButtonPressed();
  }

  interface Model {
    String fetchData();
  }

  interface Router {
    void navigateToNextScreen();

    void passDataToNextScreen(AddLostPetState state);

    AddLostPetState getDataFromPreviousScreen();

    String getActualThemeName();

    void onBackButtonPressed();
  }
}
