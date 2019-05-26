package es.ulpgc.montesdeoca110.cristina.zonget.userPendingQueriesList;

import java.lang.ref.WeakReference;

import es.ulpgc.montesdeoca110.cristina.zonget.app.statesBetweenActivities.SignInToMenuState;
import es.ulpgc.montesdeoca110.cristina.zonget.data.RepositoryContract;

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

    void fetchUserPendingQueriesListData(int userId, RepositoryContract.Queries.GetPendingQueriesListCallback callback);

  }

  interface Router {

    //--------------- Navegación entre pantallas -----------

    void navigateToUserQueriesMenuScreen();

    //------------- Paso de datos entre pantallas ----------

    void passDataToUserQueriesMenuScreen();

    //------------- Obtener datos entre pantallas ----------

    //UserPendingQueriesListState getDataFromPreviousScreen();

    SignInToMenuState getDataFromSignInToMenuState();

  }
}
