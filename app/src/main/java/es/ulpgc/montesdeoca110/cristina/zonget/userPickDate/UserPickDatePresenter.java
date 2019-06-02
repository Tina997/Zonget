package es.ulpgc.montesdeoca110.cristina.zonget.userPickDate;

import es.ulpgc.montesdeoca110.cristina.zonget.app.HourItem;
import java.lang.ref.WeakReference;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class UserPickDatePresenter implements UserPickDateContract.Presenter {

  public static String TAG = UserPickDatePresenter.class.getSimpleName();

  private WeakReference<UserPickDateContract.View> view;
  private final UserPickDateViewModel viewModel;
  private UserPickDateContract.Model model;
  private UserPickDateContract.Router router;

  public UserPickDatePresenter(UserPickDateState state) {
    viewModel = state;
  }

  @Override
  public void injectView(WeakReference<UserPickDateContract.View> view) {
    this.view = view;
  }

  @Override
  public void injectModel(UserPickDateContract.Model model) {
    this.model = model;
  }

  @Override
  public void injectRouter(UserPickDateContract.Router router) {
    this.router = router;
  }

  @Override
  public void fetchData() {

    UserPickDateState state;
    state = router.getDataFromPreviousScreen();

    if (state != null) {
      viewModel.date = state.selectedDate;
      viewModel.calendarDate = state.calendarDate;
    }

    if (viewModel.hourItemList == null) {

      //llamar al modelo

      viewModel.hourItemList = model.fetchData();
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
    UserPickDateState state = new UserPickDateState();
    state.setSelectedDate(selectedDate);
    state.setCalendarDate(calendarDate);
    router.passDataToNextScreen(state);
  }

  @Override
  public String getActualThemeName() {
    return router.getActualThemeName();
  }


}
