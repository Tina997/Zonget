package es.ulpgc.montesdeoca110.cristina.zonget.addEvent;

import java.lang.ref.WeakReference;
import java.util.Calendar;

interface AddEventContract {

  interface View {
    void injectPresenter(Presenter presenter);

    void displayData(AddEventViewModel viewModel);
  }

  interface Presenter {
    void injectView(WeakReference<View> view);

    void injectModel(Model model);

    void injectRouter(Router router);

    void addEvent();

    void navigateToAdministratorAgendaScreen();

    String getActualThemeName();

    void onBackButtonPressed();

    void saveState(int spinnerSelection, Calendar calendar);

    void fetchEventData();
  }

  interface Model {
    String fetchData();

    Calendar fetchCalendar();

  }

  interface Router {
    void navigateToNextScreen();

    void passDataToNextScreen(AddEventState state);

    AddEventState getDataFromPreviousScreen();

    void navigateToAdministratorAgendaScreen();

    String getActualThemeName();

    void onBackButtonPressed();
  }
}
