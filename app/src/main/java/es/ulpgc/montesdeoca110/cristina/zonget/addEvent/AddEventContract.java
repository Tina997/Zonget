package es.ulpgc.montesdeoca110.cristina.zonget.addEvent;

import java.lang.ref.WeakReference;

interface AddEventContract {

    interface View {
        void injectPresenter(Presenter presenter);

        void displayData(AddEventViewModel viewModel);
    }

    interface Presenter {
        void injectView(WeakReference<View> view);

        void injectModel(Model model);

        void injectRouter(Router router);

        void fetchData();

        void addEvent();

        void navigateToAdministratorAgendaScreen();
    }

    interface Model {
        String fetchData();
    }

    interface Router {
        void navigateToNextScreen();

        void passDataToNextScreen(AddEventState state);

        AddEventState getDataFromPreviousScreen();

        void navigateToAdministratorAgendaScreen();
    }
}
