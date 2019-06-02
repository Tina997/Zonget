package es.ulpgc.montesdeoca110.cristina.zonget.addLostPet;

import java.lang.ref.WeakReference;

public class AddLostPetPresenter implements AddLostPetContract.Presenter {

  public static String TAG = AddLostPetPresenter.class.getSimpleName();

  private final AddLostPetViewModel viewModel;
  private AddLostPetContract.Model model;
  private AddLostPetContract.Router router;

  public AddLostPetPresenter(AddLostPetState state) {
    viewModel = state;
  }

  @Override
  public void injectView(WeakReference<AddLostPetContract.View> view) {
    WeakReference<AddLostPetContract.View> view1 = view;
  }

  @Override
  public void injectModel(AddLostPetContract.Model model) {
    this.model = model;
  }

  @Override
  public void injectRouter(AddLostPetContract.Router router) {
    this.router = router;
  }

  @Override
  public void fetchData() {
    // Log.e(TAG, "fetchAdministratorQueriesListData()");

    // set passed state
    AddLostPetState state = router.getDataFromPreviousScreen();
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


}
