package es.ulpgc.montesdeoca110.cristina.zonget.administratorAgenda;

import android.app.AlertDialog;

import java.lang.ref.WeakReference;
import java.util.List;

import es.ulpgc.montesdeoca110.cristina.zonget.app.EventItem;

interface AdministratorAgendaContract {

    interface View {
        void injectPresenter(Presenter presenter);

        void displayData(AdministratorAgendaViewModel viewModel);

        void onModifyButtonClicked();
    }

    interface Presenter {
        void injectView(WeakReference<View> view);

        void injectModel(Model model);

        void injectRouter(Router router);

        void fetchDateListData();

        void gotToAddEvent();

        void navigateToModifyEventScreen();

        String getActualThemeName();

        void onBackButtonPressed();
    }

    interface Model {
        List<EventItem> fetchData();
    }

    interface Router {
        void navigateToNextScreen();

        void passDataToNextScreen(AdministratorAgendaState state);

        AdministratorAgendaState getDataFromPreviousScreen();

        //Navegar entre pantallas
        void navigateToAddEventScreen();

        void navigateToModifyEventScreen();

        String getActualThemeName();

        void onBackButtonPressed();
    }
}
