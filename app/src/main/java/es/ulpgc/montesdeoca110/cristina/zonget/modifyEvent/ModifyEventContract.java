package es.ulpgc.montesdeoca110.cristina.zonget.modifyEvent;

import java.lang.ref.WeakReference;
import java.util.Calendar;

interface ModifyEventContract {

    interface View {
        void injectPresenter(Presenter presenter);

        void displayData(ModifyEventViewModel viewModel);
    }

    interface Presenter {
        void injectView(WeakReference<View> view);

        void injectModel(Model model);

        void injectRouter(Router router);

        void fetchData();

        void modifyEvent();

        void navigateToAdministratorAgendaScreen();

        String getActualThemeName();

        void saveState(int spinnerSelection, Calendar calendar);
    }

    interface Model {
        String fetchData();

        Calendar fetchCalendar();
    }

    interface Router {
        void navigateToNextScreen();

        void passDataToNextScreen(ModifyEventState state);

        ModifyEventState getDataFromPreviousScreen();

        void navigateToAdministratorAgendaScreen();

        String getActualThemeName();
    }
}
