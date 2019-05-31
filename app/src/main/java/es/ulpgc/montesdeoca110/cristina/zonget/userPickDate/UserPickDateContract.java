package es.ulpgc.montesdeoca110.cristina.zonget.userPickDate;

import es.ulpgc.montesdeoca110.cristina.zonget.app.HourItem;
import java.lang.ref.WeakReference;

import java.util.List;

interface UserPickDateContract {

  interface View {

    /**
     * Metodo que inicializa el presentador asociado a la vista
     * @param presenter: El presentador de la vista
     */
    void injectPresenter(Presenter presenter);

    void displayData(UserPickDateViewModel viewModel);
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

    void fetchData();

    /**
     * Metodo que devuelve el tema actual que esta siendo usado en ese momento
     * @return String con el nombre del tema que esta siendo usado
     */
    String getActualThemeName();

    void saveState(String date, long calendarDate);

    void onDateChanged(String date, long calendarDate);
  }

  interface Model {
    List<HourItem> fetchData();

    long fetchDateData();
  }

  interface Router {
    void navigateToNextScreen();

    /**
     * Metodo que edita el estado de la vista almacenado en el mediador
     * @param state: El estado de la vista en cuestion
     */
    void passDataToNextScreen(UserPickDateState state);

    UserPickDateState getDataFromPreviousScreen();

    /**
     * Metodo que devuelve el nombre del tema actual que esta siendo utilizado
     * @return string con el nombre  del tema que se esta siendo utilizado
     */
    String getActualThemeName();
  }
}
