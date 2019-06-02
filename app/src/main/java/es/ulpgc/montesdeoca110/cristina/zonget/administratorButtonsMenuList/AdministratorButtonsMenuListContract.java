package es.ulpgc.montesdeoca110.cristina.zonget.administratorButtonsMenuList;

import java.lang.ref.WeakReference;

import es.ulpgc.montesdeoca110.cristina.zonget.app.AdministratorButtonMenuItem;
import es.ulpgc.montesdeoca110.cristina.zonget.app.statesBetweenActivities.ChangeThemeToMenuState;
import es.ulpgc.montesdeoca110.cristina.zonget.app.statesBetweenActivities.MenuToSelectedActivityState;
import es.ulpgc.montesdeoca110.cristina.zonget.app.statesBetweenActivities.MenuToSignInState;
import es.ulpgc.montesdeoca110.cristina.zonget.data.RepositoryContract;

public interface AdministratorButtonsMenuListContract {

  interface View {

    /**
     * Metodo que inicializa el presentador asociado a la vista
     *
     * @param presenter: El presentador de la vista
     */
    void injectPresenter(Presenter presenter);

    void displayAdministratorButtonsMenuListData(AdministratorButtonsMenuListViewModel viewModel);

    void reboot();

    void finish();

  }

  interface Presenter {

    /**
     * Método que inicializa la vista asociado a ese presentador
     *
     * @param view: La vista a iniciar
     */
    void injectView(WeakReference<View> view);

    /**
     * Metodo que inicializa el modelo asociado al presentador
     *
     * @param model: El modelo a iniciar
     */
    void injectModel(Model model);

    /**
     * Metodo que incializa el router asociado al presentador
     *
     * @param router: El router a iniciar
     */
    void injectRouter(Router router);

    /**
     * Metodo que devuelve el tema actual que esta siendo usado en ese momento
     *
     * @return String con el nombre del tema que esta siendo usado
     */
    String getActualThemeName();

    void fetchAdministratorButtonsMenuListData();

    void signOutButtonPressed();

    void selectAdministratorButtonsMenuListData(AdministratorButtonMenuItem item);

    void changeThemeButtonPressed();

    void checkThemeChanged();
  }

  interface Model {


    void fetchAdministratorButtonsMenuListData
            (RepositoryContract.Settings.GetAdministratorMenuButtonsListCallback callback);

  }

  interface Router {

    //------------------------- Tema ---------------------

    /**
     * Metodo que devuelve el nombre del tema actual que esta siendo utilizado
     *
     * @return string con el nombre  del tema que se esta siendo utilizado
     */
    String getActualThemeName();

    void setChangeThemeToMenuState(boolean isChanged);

    //--------------- Navegación entre pantallas -----------

    void navigateToSignInScreen();

    void navigateToSelectedActivityScreen(String activityClassName);

    void navigateToChangeThemeScreen();

    //------------- Paso de datos entre pantallas ----------

    void passDataToSignInScreen(MenuToSignInState state);

    void passDataToSelectedActivityScreen(MenuToSelectedActivityState state);

    //void passDataToChangeThemeScreen();

    //------------- Obtener datos entre pantallas ----------

    //AdministratorButtonsMenuListState getDataFromSignInScreen();

    ChangeThemeToMenuState getDataFromChangeThemeScreen();

  }
}
