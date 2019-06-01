package es.ulpgc.montesdeoca110.cristina.zonget.administratorAgenda;

import android.app.AlertDialog;

import java.lang.ref.WeakReference;
import java.util.List;

import es.ulpgc.montesdeoca110.cristina.zonget.app.EventItem;

public interface AdministratorAgendaContract {

    interface View {

        /**
         * Metodo que inicializa el presentador asociado a la vista
         * @param presenter: El presentador de la vista
         */
        void injectPresenter(Presenter presenter);

        void displayData(AdministratorAgendaViewModel viewModel);

        void onModifyButtonClicked();
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

        void fetchAdministratorAgendaData();

        void gotToAddEvent();

        void navigateToModifyEventScreen();
        /**
         * Metodo que devuelve el tema actual que esta siendo usado en ese momento
         * @return String con el nombre del tema que esta siendo usado
         */
        String getActualThemeName();

        void onBackButtonPressed();

        void saveState(String selectedDate, long calendarDate);

        void onDateChanged(String date, long calendarDate);
    }

    interface Model {
        List<EventItem> fetchData();

        long fetchDateData();
    }

    interface Router {
        void navigateToNextScreen();

        /**
         * Metodo que edita el estado de la vista almacenado en el mediador
         * @param state: El estado de la vista en cuestion
         */
        void passDataToNextScreen(AdministratorAgendaState state);

        AdministratorAgendaState getDataFromPreviousScreen();

        //Navegar entre pantallas
        void navigateToAddEventScreen();

        void navigateToModifyEventScreen();

        /**
         * Metodo que devuelve el nombre del tema actual que esta siendo utilizado
         * @return string con el nombre  del tema que se esta siendo utilizado
         */
        String getActualThemeName();

        void onBackButtonPressed();
    }
}
