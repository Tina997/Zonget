package es.ulpgc.montesdeoca110.cristina.zonget.administratorUserEditPet;

import java.lang.ref.WeakReference;

public class AdministratorUserEditPetPresenter
        implements AdministratorUserEditPetContract.Presenter {

  public static String TAG = AdministratorUserEditPetPresenter.class.getSimpleName();

  private WeakReference<AdministratorUserEditPetContract.View> view;
  private AdministratorUserEditPetViewModel viewModel;
  private AdministratorUserEditPetContract.Model model;
  private AdministratorUserEditPetContract.Router router;

  public AdministratorUserEditPetPresenter(AdministratorUserEditPetState state) {
    viewModel = state;
  }

  @Override
  public void injectView(WeakReference<AdministratorUserEditPetContract.View> view) {
    this.view = view;
  }

  @Override
  public void injectModel(AdministratorUserEditPetContract.Model model) {
    this.model = model;
  }

  @Override
  public void injectRouter(AdministratorUserEditPetContract.Router router) {
    this.router = router;
  }

  @Override
  public void fetchData() {
    // Log.e(TAG, "fetchPetsForAdoptionListData()");

    // set passed state
    AdministratorUserEditPetState state = router.getDataFromPreviousScreen();
    if (state != null) {
      viewModel.data = state.data;
    }

    if (viewModel.data == null) {
      // call the model
      String data = model.fetchData();

      // set initial state
      viewModel.data = data;
    }

    // update the view
    view.get().displayData(viewModel);

  }

  @Override
  public void insertNewPet() {
    router.navigateToNextScreen();
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
