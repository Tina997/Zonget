package es.ulpgc.montesdeoca110.cristina.zonget.addEvent;

import java.lang.ref.WeakReference;
import java.util.Calendar;

interface AddEventContract {

  interface View {
    /**
     * Metodo que inicializa el presentador asociado a la vista
     * @param presenter: El presentador de la vista
     */
    void injectPresenter(Presenter presenter);

    /**
     * Rellena la información de la vista con la información del viewModel
     * @param viewModel: viewModel donde se encuentra la información para rellenar la vista
     */
    void displayData(AddEventViewModel viewModel);
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
     * Metodo para añadir un evento al calendario del cliente una nueva cita
     */
    void addEvent();

    /**
     * Metodo que cambia de pantalla a la de la agenda del cliente
     */
    void navigateToAdministratorAgendaScreen();

    /**
     * Metodo que devuelve el tema actual que esta siendo usado en ese momento
     * @return String con el nombre del tema que esta siendo usado
     */
    String getActualThemeName();

    /**
     * Metodo llamado al pulsar el boton back que hace que la vista retroceda a la anterior
     */
    void onBackButtonPressed();

    /**
     * Metodo que guarda el estado tanto del spinner como del calendario para que permanezca igual al girar la pantalla
     * @param spinnerSelection: Indica la posición en la que está el spinner antes de girar la pantalla
     * @param calendar: Indica la fecha exacta del calendario antes de girar la pantalla
     */
    void saveState(int spinnerSelection, Calendar calendar);

    /**
     * Metodo que rellena la vista con la información inicial del calendario (Fecha actual) cuando se rellena por primera vez esta, en caso de que sea tras girar la pantalla
     * esta informacion la rellena con la información de antes de girarla
     */
    void fetchEventData();
  }

  interface Model {
    //TODO Metodo que esta sin usarse
    String fetchData();

    /**
     * Metodo que devuelve el calendario con las marcas de la fecha escogida
     * @return Calendario con las ediciones realizadas
     */
    Calendar fetchCalendar();

  }

  interface Router {
    //TODO Metodo que esta sin usarse
    void navigateToNextScreen();

    /**
     * Metodo que edita el estado de la vista almacenado en el mediador
     * @param state: El estado de la vista en cuestion
     */
    void passDataToNextScreen(AddEventState state);

    /**
     * Metodo que da el estado de la vista en un momento anterior
     * @return El estado de la vista de AddEvent obtenido del mediador
     */
    AddEventState getDataFromPreviousScreen();

    /**
     * Metodo que cambia la vista actual por la vista de la agenda total del cliente
     */
    void navigateToAdministratorAgendaScreen();

    /**
     * Metodo que devuelve el nombre del tema actual que esta siendo utilizado
     * @return string con el nombre  del tema que se esta siendo utilizado
     */
    String getActualThemeName();
    /**
     * Metodo llamado al pulsar el boton back que hace que la vista retroceda a la vista de la agenda del cliente
     */
    void onBackButtonPressed();
  }
}
