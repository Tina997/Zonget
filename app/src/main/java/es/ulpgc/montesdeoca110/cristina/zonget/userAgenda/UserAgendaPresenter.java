package es.ulpgc.montesdeoca110.cristina.zonget.userAgenda;

import es.ulpgc.montesdeoca110.cristina.zonget.app.EventItem;
import java.lang.ref.WeakReference;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class UserAgendaPresenter implements UserAgendaContract.Presenter {

  public static String TAG = UserAgendaPresenter.class.getSimpleName();

  private WeakReference<UserAgendaContract.View> view;
  private final UserAgendaViewModel viewModel;
  private UserAgendaContract.Model model;
  private UserAgendaContract.Router router;

  public UserAgendaPresenter(UserAgendaState state) {
    viewModel = state;
  }

  @Override
  public void injectView(WeakReference<UserAgendaContract.View> view) {
    this.view = view;
  }

  @Override
  public void injectModel(UserAgendaContract.Model model) {
    this.model = model;
  }

  @Override
  public void injectRouter(UserAgendaContract.Router router) {
    this.router = router;
  }

  @Override
  public void fetchEventListData() {

    UserAgendaState state;
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


    //mostrar datos
    view.get().displayData(viewModel);
    ;

  }

  @Override
  public void onDateChanged(String date, long calendarDate) {
    viewModel.date = date;
    viewModel.calendarDate = calendarDate;
    view.get().displayData(viewModel);
  }

  @Override
  public void saveState(String selectedDate, long calendarDate) {
    UserAgendaState state = new UserAgendaState();
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


}
