package es.ulpgc.montesdeoca110.cristina.zonget.addEvent;

import java.lang.ref.WeakReference;
import java.util.Calendar;

public class AddEventPresenter implements AddEventContract.Presenter {

  public static String TAG = AddEventPresenter.class.getSimpleName();

  private WeakReference<AddEventContract.View> view;
  private AddEventViewModel viewModel;
  private AddEventContract.Model model;
  private AddEventContract.Router router;

  public AddEventPresenter(AddEventState state) {
    viewModel = state;
  }

  @Override
  public void injectView(WeakReference<AddEventContract.View> view) {
    this.view = view;
  }

  @Override
  public void injectModel(AddEventContract.Model model) {
    this.model = model;
  }

  @Override
  public void injectRouter(AddEventContract.Router router) {
    this.router = router;
  }

  @Override
  public void fetchEventData() {
    // set passed state
    AddEventState state = router.getDataFromPreviousScreen();
    if (state != null) {
      viewModel.spinnerSelection = state.spinnerSelection;
      viewModel.calendar = state.calendar;
    }

    if (viewModel.calendar == null) {
      // call the model
      Calendar calendar = model.fetchCalendar();

      // set initial state
      viewModel.calendar = calendar;
    }

    // update the view
    view.get().displayData(viewModel);

  }

  @Override
  public void saveState(int spinnerSelection, Calendar calendar) {
    AddEventState state = new AddEventState();
    state.setSpinnerSelection(spinnerSelection);
    state.calendar = calendar;
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

  @Override
  public void addEvent() {
    router.navigateToAdministratorAgendaScreen();
  }

  @Override
  public void navigateToAdministratorAgendaScreen() {
    router.navigateToAdministratorAgendaScreen();
  }


}
