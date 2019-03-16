package es.ulpgc.montesdeoca110.cristina.zonget.modificarCita;

import java.lang.ref.WeakReference;

interface ModificarCitaContract {

    interface View {
        void injectPresenter(Presenter presenter);

        void displayData(ModificarCitaViewModel viewModel);
    }

    interface Presenter {
        void injectView(WeakReference<View> view);

        void injectModel(Model model);

        void injectRouter(Router router);

        void fetchData();

        void modificarCita();
    }

    interface Model {
        String fetchData();
    }

    interface Router {
        void navigateToNextScreen();

        void passDataToNextScreen(ModificarCitaState state);

        ModificarCitaState getDataFromPreviousScreen();

        void navigateToAgendaAdminScreen();
    }
}
