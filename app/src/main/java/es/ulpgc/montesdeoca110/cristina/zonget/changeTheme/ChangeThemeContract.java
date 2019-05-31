package es.ulpgc.montesdeoca110.cristina.zonget.changeTheme;

import es.ulpgc.montesdeoca110.cristina.zonget.app.ChangeThemeItem;
import es.ulpgc.montesdeoca110.cristina.zonget.app.statesBetweenActivities.ChangeThemeToMenuState;
import es.ulpgc.montesdeoca110.cristina.zonget.data.RepositoryContract;
import java.lang.ref.WeakReference;

public interface ChangeThemeContract {

  interface View {

    /**
     * Metodo que inicializa el presentador asociado a la vista
     * @param presenter: El presentador de la vista
     */
    void injectPresenter(Presenter presenter);

    void displayChangeThemeListData(ChangeThemeViewModel viewModel);

    void reboot();

    void finish();

    void onBackButtonPressed();
  }

  interface Presenter {

    /**
     * Método que inicializa la vista asociado a ese presentador
     * @param view: La vista a iniciar
     */
    void injectView(WeakReference<View> view);

    /**
     * Metodo que inicializa el modelo asociado al presentador
     * @param model: El modelo a iniciar
     */
    void injectModel(Model model);

    /**
     * Metodo que incializa el router asociado al presentador
     * @param router: El router a iniciar
     */
    void injectRouter(Router router);

    /**
     * Metodo que devuelve el tema actual que esta siendo usado en ese momento
     * @return String con el nombre del tema que esta siendo usado
     */
    String getActualThemeName();

    void fetchChangeThemeListData();

    void selectChangeThemeListData(ChangeThemeItem item);

    void backButtonPressed();
  }

  interface Model {

    void fetchChangeThemeListData(RepositoryContract.Settings.GetChangeThemeListCallback callback);

  }

  interface Router {

    //------------------------- Tema ---------------------

    /**
     * Metodo que devuelve el nombre del tema actual que esta siendo utilizado
     * @return string con el nombre  del tema que se esta siendo utilizado
     */
    String getActualThemeName();

    void changeActualTheme(String themeName);

    //--------------- Navegación entre pantallas -----------

    void navigateToMenuScreen();

    //------------- Paso de datos entre pantallas ----------

    void passDataToMenuScreen(ChangeThemeToMenuState state);

    //------------- Obtener datos entre pantallas ----------

    ChangeThemeState getDataFromPreviousScreen();

  }
}
