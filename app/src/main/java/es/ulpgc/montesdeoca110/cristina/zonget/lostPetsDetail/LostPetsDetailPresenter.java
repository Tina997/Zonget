package es.ulpgc.montesdeoca110.cristina.zonget.lostPetsDetail;

import es.ulpgc.montesdeoca110.cristina.zonget.app.LostPetItem;

import java.lang.ref.WeakReference;

public class LostPetsDetailPresenter implements LostPetsDetailContract.Presenter {

  public static String TAG = LostPetsDetailPresenter.class.getSimpleName();

  private WeakReference<LostPetsDetailContract.View> view;
  private final LostPetsDetailViewModel viewModel;
  private LostPetsDetailContract.Router router;

  public LostPetsDetailPresenter(LostPetsDetailState state) {
    viewModel = state;
  }

  @Override
  public void injectView(WeakReference<LostPetsDetailContract.View> view) {
    this.view = view;
  }

  @Override
  public void injectModel(LostPetsDetailContract.Model model) {
    LostPetsDetailContract.Model model1 = model;
  }

  @Override
  public void injectRouter(LostPetsDetailContract.Router router) {
    this.router = router;
  }

  @Override
  public void fetchLostPetDetailData() {
    // Log.e(TAG, "fetchPetForAdoptionDetailData()");

    // set passed state
    LostPetItem lostPetItem = router.getDataFromLostPetsListScreen();
    if (lostPetItem != null) {
      viewModel.lostPetItem = lostPetItem;
    }
    // update the view
    view.get().displayLostPetDetailData(viewModel);

  }

  @Override
  public void onEditButtonClicked() {
    router.navigateToEditScreen();
  }

  @Override
  public void deletePet() {
    //TODO eliminar animal de la lista
    router.navigateToLostPetListScreen();

  }

  @Override
  public String getActualThemeName() {
    return router.getActualThemeName();
  }

  @Override
  public void onBackButtonClicked() {
    router.onBackButtonClicked();
  }


}
