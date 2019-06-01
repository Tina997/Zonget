package es.ulpgc.montesdeoca110.cristina.zonget.userQueriesMenu;

import java.lang.ref.WeakReference;

import es.ulpgc.montesdeoca110.cristina.zonget.app.statesBetweenActivities.SignInToMenuState;
import es.ulpgc.montesdeoca110.cristina.zonget.data.RepositoryContract;

interface UserQueriesMenuContract {

  interface View {

    void injectPresenter(Presenter presenter);

    void displayUserQueriesMenuData(UserQueriesMenuViewModel viewModel);

    void finish();

  }

  interface Presenter {

    void injectView(WeakReference<View> view);

    void injectModel(Model model);

    void injectRouter(Router router);

    String getActualThemeName();

    void backButtonPressed();

    void fetchUserQueriesMenuData();

    void newQueryButtonPressed();

    void pendingQueriesButtonPressed();

    void finishedQueriesButtonPressed();

  }

  interface Model {

    void fetchUserQueriesMenuData(int userdId, RepositoryContract.Queries.GetQueriesListSizeCallback callback);

  }

  interface Router {

    //------------------------- Tema ---------------------

    String getActualThemeName();

    //--------------- Navegación entre pantallas -----------

    void navigateToUserMenuScreen();

    void navigateToUserNewQueryScreen();

    void navigateToUserPendingQueriesScreen();

    void navigateToUserFinishedQueriesScreen();

    //------------- Paso de datos entre pantallas ----------

    void passDataToUserNewQueryScreen();

    void passDataToUserPendingQueriesListScreen();

    void passDataToUserFinishedQueriesListScreen();

    //------------- Obtener datos entre pantallas ----------

    SignInToMenuState getSignInToMenuState();

  }
}
