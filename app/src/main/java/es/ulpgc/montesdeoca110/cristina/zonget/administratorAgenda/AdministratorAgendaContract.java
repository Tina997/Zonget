package es.ulpgc.montesdeoca110.cristina.zonget.administratorAgenda;

import es.ulpgc.montesdeoca110.cristina.zonget.app.EventItem;
import java.lang.ref.WeakReference;
import java.util.List;

public interface AdministratorAgendaContract {

  interface View {
    void injectPresenter(Presenter presenter);

    void displayData(AdministratorAgendaViewModel viewModel);

    void onModifyButtonClicked();
  }

  interface Presenter {
    void injectView(WeakReference<View> view);

    void injectModel(Model model);

    void injectRouter(Router router);

    void fetchAdministratorAgendaData();

    void gotToAddEvent();

    void navigateToModifyEventScreen();

    String getActualThemeName();

    void onBackButtonPressed();

    void saveState(String selectedDate, long calendarDate);

    void onDateChanged(String date, long calendarDate);
  }

  interface Model {
    List<EventItem> fetchData();

    long fetchDateData();
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
