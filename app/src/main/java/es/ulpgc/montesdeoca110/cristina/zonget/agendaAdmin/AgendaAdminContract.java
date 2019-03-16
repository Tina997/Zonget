package es.ulpgc.montesdeoca110.cristina.zonget.agendaAdmin;

import java.lang.ref.WeakReference;

interface AgendaAdminContract {

    interface View {
        void injectPresenter(Presenter presenter);

        void displayData(AgendaAdminViewModel viewModel);
    }

    interface Presenter {
        void injectView(WeakReference<View> view);

        void injectModel(Model model);

        void injectRouter(Router router);

        void fetchData();

        void agregarCita();
    }

    interface Model {
        String fetchData();
    }

    interface Router {
        void navigateToNextScreen();

        void passDataToNextScreen(AgendaAdminState state);

        AgendaAdminState getDataFromPreviousScreen();

        //Navegar entre pantallas
        void navigateToAgregarCitaScreen();
    }
}
