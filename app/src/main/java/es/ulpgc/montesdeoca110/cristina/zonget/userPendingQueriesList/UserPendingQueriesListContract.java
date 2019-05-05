package es.ulpgc.montesdeoca110.cristina.zonget.userPendingQueriesList;

import java.lang.ref.WeakReference;

public interface UserPendingQueriesListContract {

  interface View {

    void injectPresenter(Presenter presenter);

    void displayUserPendingQueriesListData(UserPendingQueriesListViewModel viewModel);

  }

  interface Presenter {

    void injectView(WeakReference<View> view);

    void injectModel(Model model);

    void injectRouter(Router router);

    void backButtonPressed();

    void fetchUserPendingQueriesListData();

  }

  interface Model {

    void fetchUserPendingQueriesListData();

  }

  interface Router {

    //--------------- Navegación entre pantallas -----------

    void navigateToUserQueriesMenuScreen();

    //------------- Paso de datos entre pantallas ----------

    void passDataToUserQueriesMenuScreen();

    //------------- Obtener datos entre pantallas ----------

    //UserPendingQueriesListState getDataFromPreviousScreen();

  }
}
