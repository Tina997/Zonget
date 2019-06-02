package es.ulpgc.montesdeoca110.cristina.zonget.editLostPet;

import java.lang.ref.WeakReference;

public class EditLostPetPresenter implements EditLostPetContract.Presenter {

  public static String TAG = EditLostPetPresenter.class.getSimpleName();

  private WeakReference<EditLostPetContract.View> view;
  private final EditLostPetViewModel viewModel;
  private EditLostPetContract.Model model;
  private EditLostPetContract.Router router;

  public EditLostPetPresenter(EditLostPetState state) {
    viewModel = state;
  }

  @Override
  public void injectView(WeakReference<EditLostPetContract.View> view) {
    this.view = view;
  }

  @Override
  public void injectModel(EditLostPetContract.Model model) {
    this.model = model;
  }

  @Override
  public void injectRouter(EditLostPetContract.Router router) {
    this.router = router;
  }

  @Override
  public void fetchData() {
    // Log.e(TAG, "fetchAdministratorQueriesListData()");

    // set passed state
    EditLostPetState state = router.getDataFromPreviousScreen();
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
  public void insertNewPet() {
    //TODO ingresar nueva mascota en la lista
    router.navigateToLostPetDetailScreen();
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
