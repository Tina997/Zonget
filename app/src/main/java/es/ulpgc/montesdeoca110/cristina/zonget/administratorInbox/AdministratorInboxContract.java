package es.ulpgc.montesdeoca110.cristina.zonget.administratorInbox;

import es.ulpgc.montesdeoca110.cristina.zonget.app.QueryItem;
import java.lang.ref.WeakReference;
import java.util.List;

public interface AdministratorInboxContract {

  interface View {
    void injectPresenter(Presenter presenter);

    void displayData(AdministratorInboxViewModel viewModel);
  }

  interface Presenter {
    void injectView(WeakReference<View> view);

    void injectModel(Model model);

    void injectRouter(Router router);

    void fetchInboxData();

    void goToAdministratorQueryDetailScreen();

    String getActualThemeName();

    void onBackButtonPressed();
  }

  interface Model {
    List<QueryItem> fetchData();
  }

  interface Router {
    void navigateToNextScreen();

    void passDataToNextScreen(AdministratorInboxState state);

    AdministratorInboxState getDataFromPreviousScreen();

    void navigateToAdministratorQueryDetailScreen();

    String getActualThemeName();

    void onBackButtonPressed();
  }
}
