package es.ulpgc.montesdeoca110.cristina.zonget.modifyEvent;

import java.lang.ref.WeakReference;
import java.util.Calendar;

public class ModifyEventPresenter implements ModifyEventContract.Presenter {

  public static String TAG = ModifyEventPresenter.class.getSimpleName();

  private WeakReference<ModifyEventContract.View> view;
  private ModifyEventViewModel viewModel;
  private ModifyEventContract.Model model;
  private ModifyEventContract.Router router;

  public ModifyEventPresenter(ModifyEventState state) {
    viewModel = state;
  }

  @Override
  public void injectView(WeakReference<ModifyEventContract.View> view) {
    this.view = view;
  }

  @Override
  public void injectModel(ModifyEventContract.Model model) {
    this.model = model;
  }

  @Override
  public void injectRouter(ModifyEventContract.Router router) {
    this.router = router;
  }

  @Override
  public void fetchData() {
    // set passed state
    ModifyEventState state = router.getDataFromPreviousScreen();
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
    ModifyEventState state = new ModifyEventState();
    state.setSpinnerSelection(spinnerSelection);
    state.calendar = calendar;
    router.passDataToNextScreen(state);
  }

  @Override
  public String getActualThemeName() {
    return router.getActualThemeName();
  }

  @Override
  public void modifyEvent() {
    router.navigateToAdministratorAgendaScreen();
  }

  @Override
  public void navigateToAdministratorAgendaScreen() {
    router.navigateToAdministratorAgendaScreen();
  }


}
