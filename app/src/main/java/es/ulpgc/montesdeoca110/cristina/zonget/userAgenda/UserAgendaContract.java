package es.ulpgc.montesdeoca110.cristina.zonget.userAgenda;

import java.lang.ref.WeakReference;
import java.util.List;

import es.ulpgc.montesdeoca110.cristina.zonget.app.EventItem;

interface UserAgendaContract {

    interface View {
        void injectPresenter(Presenter presenter);

        void displayData(UserAgendaViewModel viewModel);
    }

    interface Presenter {
        void injectView(WeakReference<View> view);

        void injectModel(Model model);

        void injectRouter(Router router);

        void fetchEventListData();

        String getActualThemeName();

        void onBackButtonPressed();

        void saveState(String date, long calendarDate);

        void onDateChanged(String date, long calendarDate);
    }

    interface Model {
        List<EventItem> fetchData();

        long fetchDateData();
    }

    interface Router {
        void navigateToNextScreen();

        void passDataToNextScreen(UserAgendaState state);

        UserAgendaState getDataFromPreviousScreen();

        String getActualThemeName();

        void onBackButtonPressed();
    }
}
