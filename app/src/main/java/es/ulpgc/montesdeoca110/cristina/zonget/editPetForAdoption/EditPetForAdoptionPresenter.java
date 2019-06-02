package es.ulpgc.montesdeoca110.cristina.zonget.editPetForAdoption;

import java.lang.ref.WeakReference;

public class EditPetForAdoptionPresenter implements EditPetForAdoptionContract.Presenter {

  public static String TAG = EditPetForAdoptionPresenter.class.getSimpleName();

  private WeakReference<EditPetForAdoptionContract.View> view;
  private final EditPetForAdoptionViewModel viewModel;
  private EditPetForAdoptionContract.Model model;
  private EditPetForAdoptionContract.Router router;

  public EditPetForAdoptionPresenter(EditPetForAdoptionState state) {
    viewModel = state;
  }

  @Override
  public void injectView(WeakReference<EditPetForAdoptionContract.View> view) {
    this.view = view;
  }

  @Override
  public void injectModel(EditPetForAdoptionContract.Model model) {
    this.model = model;
  }

  @Override
  public void injectRouter(EditPetForAdoptionContract.Router router) {
    this.router = router;
  }

  @Override
  public void fetchData() {
    // Log.e(TAG, "fetchAdministratorQueriesListData()");

    // set passed state
    EditPetForAdoptionState state = router.getDataFromPreviousScreen();
    if (state != null) {
      viewModel.data = state.data;
    }

    if (viewModel.data == null) {
      // call the model

      // set initial state
      viewModel.data = model.fetchData();
    }

    // update the view
    view.get().displayData(viewModel);

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
  public void onAcceptButtonClicked() {
    router.navigateToPetForAdoptionDetailScreen();
  }


}
