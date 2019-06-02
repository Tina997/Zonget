package es.ulpgc.montesdeoca110.cristina.zonget.administratorAgenda;

import android.support.v4.app.FragmentActivity;

import es.ulpgc.montesdeoca110.cristina.zonget.app.EventItem;
import java.lang.ref.WeakReference;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class AdministratorAgendaPresenter extends FragmentActivity
        implements AdministratorAgendaContract.Presenter {

  public static String TAG = AdministratorAgendaPresenter.class.getSimpleName();

  private WeakReference<AdministratorAgendaContract.View> view;
  private final AdministratorAgendaViewModel viewModel;
  private AdministratorAgendaContract.Model model;
  private AdministratorAgendaContract.Router router;

  public AdministratorAgendaPresenter(AdministratorAgendaState state) {
    viewModel = state;
  }

  @Override
  public void injectView(WeakReference<AdministratorAgendaContract.View> view) {
    this.view = view;
  }

  @Override
  public void injectModel(AdministratorAgendaContract.Model model) {
    this.model = model;
  }

  @Override
  public void injectRouter(AdministratorAgendaContract.Router router) {
    this.router = router;
  }

  @Override
  public void fetchAdministratorAgendaData() {

    AdministratorAgendaState state;
    state = router.getDataFromPreviousScreen();

    if (state != null) {
      viewModel.date = state.selectedDate;
      viewModel.calendarDate = state.calendarDate;
    }

    if (viewModel.eventList == null) {
      //llamar al modelo
      viewModel.eventList = model.fetchData();
    }

    if (viewModel.calendarDate == 0 || viewModel.date == null) {
      //Llamar al modelo
      long time = model.fetchDateData();
      viewModel.calendarDate = time;
      viewModel.date = new SimpleDateFormat("dd/MM/yyyy").format(new Date(time));
    }

    view.get().displayData(viewModel);

  }

  @Override
  public void onDateChanged(String date, long calendarDate) {
    viewModel.date = date;
    viewModel.calendarDate = calendarDate;
    view.get().displayData(viewModel);
  }

  @Override
  public void saveState(String selectedDate, long calendarDate) {
    AdministratorAgendaState state = new AdministratorAgendaState();
    state.setSelectedDate(selectedDate);
    state.setCalendarDate(calendarDate);
    router.passDataToNextScreen(state);
  }

  @Override
  public String getActualThemeName() {
    return router.getActualThemeName();
  }

  @Override
  public void onBackButtonPressed() {
    router.onBackButtonPressed();
  }


  //Navegar a las diferentes pantallas
  @Override
  public void gotToAddEvent() {
    router.navigateToAddEventScreen();
  }

  @Override
  public void navigateToModifyEventScreen() {
    router.navigateToModifyEventScreen();
  }


}
