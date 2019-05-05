package es.ulpgc.montesdeoca110.cristina.zonget.administratorUsersPets;

import es.ulpgc.montesdeoca110.cristina.zonget.app.PetsItem;
import java.lang.ref.WeakReference;

public class AdministratorUsersPetsListPresenter
        implements AdministratorUsersPetsListContract.Presenter {

  public static String TAG = AdministratorUsersPetsListPresenter.class.getSimpleName();

  private WeakReference<AdministratorUsersPetsListContract.View> view;
  private AdministratorUsersPetsListViewModel viewModel;
  private AdministratorUsersPetsListContract.Model model;
  private AdministratorUsersPetsListContract.Router router;

  public AdministratorUsersPetsListPresenter(AdministratorUsersPetsListState state) {
    viewModel = state;
  }

  @Override
  public void injectView(WeakReference<AdministratorUsersPetsListContract.View> view) {
    this.view = view;
  }

  @Override
  public void injectModel(AdministratorUsersPetsListContract.Model model) {
    this.model = model;
  }

  @Override
  public void injectRouter(AdministratorUsersPetsListContract.Router router) {
    this.router = router;
  }

  @Override
  public void fetchUserPetsData() {
    // Log.e(TAG, "fetchInboxData()");

    // set passed state
    AdministratorUsersPetsListState state = router.getDataFromPreviousScreen();
    viewModel.animales = model.fetchPetsData();
    view.get().displayUserPetsData(viewModel);

  }

  @Override
  public void selectUserPetsData(PetsItem item) {
    router.passDataToPetsDetailScreen(item);
    router.navigateToPetsDetailScreen();
  }

  @Override
  public void onClickAddButton() {
    router.navigateToAddScreen();
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
