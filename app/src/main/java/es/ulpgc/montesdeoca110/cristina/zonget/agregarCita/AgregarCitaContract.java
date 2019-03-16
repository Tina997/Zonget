package es.ulpgc.montesdeoca110.cristina.zonget.agregarCita;

import java.lang.ref.WeakReference;

interface AgregarCitaContract {

    interface View {
        void injectPresenter(Presenter presenter);

        void displayData(AgregarCitaViewModel viewModel);
    }

    interface Presenter {
        void injectView(WeakReference<View> view);

        void injectModel(Model model);

        void injectRouter(Router router);

        void fetchData();

        void aceptarCita();
    }

    interface Model {
        String fetchData();
    }

    interface Router {
        void navigateToNextScreen();

        void passDataToNextScreen(AgregarCitaState state);

        AgregarCitaState getDataFromPreviousScreen();

        void navigateToAgendaAdminScreen();
    }
}
