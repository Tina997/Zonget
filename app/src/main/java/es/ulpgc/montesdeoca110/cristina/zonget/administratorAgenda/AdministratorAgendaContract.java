package es.ulpgc.montesdeoca110.cristina.zonget.administratorAgenda;

import java.lang.ref.WeakReference;
import java.util.List;

import es.ulpgc.montesdeoca110.cristina.zonget.app.EventItem;

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

        void gotToAddEvent();
    }

    interface Model {
        List<EventItem> fetchData();
    }

    interface Router {
        void navigateToNextScreen();

        void passDataToNextScreen(AdministratorAdministratorAgendaState state);

        AdministratorAdministratorAgendaState getDataFromPreviousScreen();

        //Navegar entre pantallas
        void navigateToAddEventScreen();
    }
}
