package es.ulpgc.montesdeoca110.cristina.zonget.administratorUsersPetDetail;

import es.ulpgc.montesdeoca110.cristina.zonget.app.PetsItem;
import java.lang.ref.WeakReference;

interface AdministratorUserPetsDetailContract {

  interface View {
    void injectPresenter(Presenter presenter);

    void displayData(AdministratorUserPetsDetailViewModel viewModel);

    void onDeleteButtonClicked();
  }

  interface Presenter {
    void injectView(WeakReference<View> view);

    void injectModel(Model model);

    void injectRouter(Router router);

    void fetchData();

    void onEditButtonClicked();

    void onDeleteButtonClicked();

    String getActualThemeName();

    void onBackButtonPressed();
  }

  interface Model {
    String fetchData();
  }

  interface Router {
    void navigateToNextScreen();

    void passDataToNextScreen(AdministratorUserPetsDetailState state);

    PetsItem getDataFromPreviousScreen();

    void navigateToEditScreen();

    void navigateToPetListScreen();

    String getActualThemeName();

    void onBackButtonPressed();
  }
}
