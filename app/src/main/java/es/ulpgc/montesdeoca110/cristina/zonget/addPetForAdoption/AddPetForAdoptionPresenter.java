package es.ulpgc.montesdeoca110.cristina.zonget.addPetForAdoption;

import java.lang.ref.WeakReference;

public class AddPetForAdoptionPresenter implements AddPetForAdoptionContract.Presenter {

  public static String TAG = AddPetForAdoptionPresenter.class.getSimpleName();

  private final AddPetForAdoptionViewModel viewModel;
  private AddPetForAdoptionContract.Model model;
  private AddPetForAdoptionContract.Router router;

  public AddPetForAdoptionPresenter(AddPetForAdoptionState state) {
    viewModel = state;
  }

  @Override
  public void injectView(WeakReference<AddPetForAdoptionContract.View> view) {
    WeakReference<AddPetForAdoptionContract.View> view1 = view;
  }

  @Override
  public void injectModel(AddPetForAdoptionContract.Model model) {
    this.model = model;
  }

  @Override
  public void injectRouter(AddPetForAdoptionContract.Router router) {
    this.router = router;
  }

  @Override
  public void fetchData() {
    // Log.e(TAG, "fetchAdministratorQueriesListData()");

    // set passed state
    AddPetForAdoptionState state = router.getDataFromPreviousScreen();
    if (state != null) {
      viewModel.data = state.data;
    }

    if (viewModel.data == null) {
      // call the model

      // set initial state
      viewModel.data = model.fetchData();
    }


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
