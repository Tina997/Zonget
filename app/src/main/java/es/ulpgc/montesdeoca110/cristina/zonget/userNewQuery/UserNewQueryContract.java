package es.ulpgc.montesdeoca110.cristina.zonget.userNewQuery;

import java.lang.ref.WeakReference;

import es.ulpgc.montesdeoca110.cristina.zonget.app.statesBetweenActivities.SignInToMenuState;
import es.ulpgc.montesdeoca110.cristina.zonget.data.RepositoryContract;

interface UserNewQueryContract {

  interface View {

    void injectPresenter(Presenter presenter);

    void displayUserNewQueryData(UserNewQueryViewModel viewModel);

    void displayToastMessage(String message);

    void startSendQuery();

    void finish();
  }

  interface Presenter {

    void injectView(WeakReference<View> view);

    void injectModel(Model model);

    void injectRouter(Router router);

    String getActualThemeName();

    void backButtonPressed();

    void fetchUserNewQueryData();

    void sendButtonPressed(String title, String content);
  }

  interface Model {

    void fetchUserNewQueryData();

    void setNewQuery(int senderUserId, String title, String content, RepositoryContract.Queries.SetNewQueryCallback callback);

  }

  interface Router {

    //------------------------- Tema ---------------------

    String getActualThemeName();

    //--------------- Navegación entre pantallas -----------

    void navigateToUserQueriesMenuScreen();

    //------------- Paso de datos entre pantallas ----------

    void passDataToUserQueriesMenuScreen();

    //------------- Obtener datos entre pantallas ----------

    //UserNewQueryState getDataFromPreviousScreen();

    SignInToMenuState getDataFromSignInToMenuState();
  }
}
