package es.ulpgc.montesdeoca110.cristina.zonget.userFinishedQueriesList;

import java.lang.ref.WeakReference;

public interface UserFinishedQueriesListContract {

  interface View {

    void injectPresenter(Presenter presenter);

    void displayUserFinishedQueriesListData(UserFinishedQueriesListViewModel viewModel);

  }

  interface Presenter {

    void injectView(WeakReference<View> view);

    void injectModel(Model model);

    void injectRouter(Router router);

    void backButtonPressed();

    void fetchUserFinishedQueriesListData();

  }

  interface Model {

    void fetchUserFinishedQueriesListData();

  }

  interface Router {

    //--------------- Navegación entre pantallas -----------

    void navigateToUserQueriesMenuScreen();

    //------------- Paso de datos entre pantallas ----------

    void passDataToUserQueriesMenuScreen();

    //------------- Obtener datos entre pantallas ----------

    //UserFinishedQueriesListState getDataFromPreviousScreen();

  }
}
