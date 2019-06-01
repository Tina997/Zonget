package es.ulpgc.montesdeoca110.cristina.zonget.userFinishedQueriesList;

import java.lang.ref.WeakReference;

import es.ulpgc.montesdeoca110.cristina.zonget.app.statesBetweenActivities.SignInToMenuState;
import es.ulpgc.montesdeoca110.cristina.zonget.data.RepositoryContract;

public interface UserFinishedQueriesListContract {

  interface View {

    void injectPresenter(Presenter presenter);

    void displayUserFinishedQueriesListData(UserFinishedQueriesListViewModel viewModel);

  }

  interface Presenter {

    void injectView(WeakReference<View> view);

    void injectModel(Model model);

    void injectRouter(Router router);

    String getActualThemeName();

    void backButtonPressed();

    void fetchUserFinishedQueriesListData();

  }

  interface Model {

    void fetchUserFinishedQueriesListData(int userId, RepositoryContract.Queries.GetFinishedQueriesListCallback callback);

  }

  interface Router {

    //------------------------- Tema ---------------------

    String getActualThemeName();

    //--------------- Navegación entre pantallas -----------

    void navigateToUserQueriesMenuScreen();

    //------------- Paso de datos entre pantallas ----------

    void passDataToUserQueriesMenuScreen();

    //------------- Obtener datos entre pantallas ----------

    //UserFinishedQueriesListState getDataFromPreviousScreen();

    SignInToMenuState getDataFromSignInToMenuState();

  }
}
