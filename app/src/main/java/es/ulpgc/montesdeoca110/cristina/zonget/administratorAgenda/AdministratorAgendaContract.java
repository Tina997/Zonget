package es.ulpgc.montesdeoca110.cristina.zonget.administratorAgenda;

import java.lang.ref.WeakReference;
import java.util.List;

import es.ulpgc.montesdeoca110.cristina.zonget.app.CitaItem;

interface AdministratorAgendaContract {

    interface View {
        void injectPresenter(Presenter presenter);

        void displayData(AdministratorAgendaViewModel viewModel);
    }

    interface Presenter {
        void injectView(WeakReference<View> view);

        void injectModel(Model model);

        void injectRouter(Router router);

        void fetchDateListData();

        void agregarCita();
    }

    interface Model {
        List<CitaItem> fetchData();
    }

    interface Router {
        void navigateToNextScreen();

        void passDataToNextScreen(AdministratorAdministratorAgendaState state);

        AdministratorAdministratorAgendaState getDataFromPreviousScreen();

        //Navegar entre pantallas
        void navigateToAgregarCitaScreen();
    }
}
