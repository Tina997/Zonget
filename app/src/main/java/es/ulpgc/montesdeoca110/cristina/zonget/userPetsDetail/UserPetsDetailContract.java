package es.ulpgc.montesdeoca110.cristina.zonget.userPetsDetail;

import es.ulpgc.montesdeoca110.cristina.zonget.app.PetsItem;
import java.lang.ref.WeakReference;

interface UserPetsDetailContract {

  interface View {
    void injectPresenter(Presenter presenter);

    void displayData(UserPetsDetailViewModel viewModel);

  }

  interface Presenter {
    void injectView(WeakReference<View> view);

    void injectModel(Model model);

    void injectRouter(Router router);

    void fetchPetsData();

    String getActualThemeName();

    void onBackButtonClicked();
  }

  interface Model {
    String fetchData();
  }

  interface Router {
    void navigateToNextScreen();

    void passDataToNextScreen(UserPetsDetailState state);

    PetsItem getDataFromPreviousScreen();

    String getActualThemeName();

    void onBackButtonClicked();
  }
}
