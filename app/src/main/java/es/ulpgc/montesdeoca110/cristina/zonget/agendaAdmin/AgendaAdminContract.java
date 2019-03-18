package es.ulpgc.montesdeoca110.cristina.zonget.agendaAdmin;

import java.lang.ref.WeakReference;
import java.util.List;

import es.ulpgc.montesdeoca110.cristina.zonget.App.CitaItem;

interface AgendaAdminContract {

    interface View {
        void injectPresenter(Presenter presenter);

        void displayData(AgendaAdminViewModel viewModel);
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

        void passDataToNextScreen(AgendaAdminState state);

        AgendaAdminState getDataFromPreviousScreen();

        //Navegar entre pantallas
        void navigateToAgregarCitaScreen();
    }
}
