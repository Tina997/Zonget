package es.ulpgc.montesdeoca110.cristina.zonget.petsForAdoptionDetail;

import es.ulpgc.montesdeoca110.cristina.zonget.app.PetForAdoptionItem;

import java.lang.ref.WeakReference;

public class PetsForAdoptionDetailPresenter implements PetsForAdoptionDetailContract.Presenter {

  public static String TAG = PetsForAdoptionDetailPresenter.class.getSimpleName();

  private WeakReference<PetsForAdoptionDetailContract.View> view;
  private final PetsForAdoptionDetailViewModel viewModel;
  private PetsForAdoptionDetailContract.Router router;

  public PetsForAdoptionDetailPresenter(PetsForAdoptionDetailState state) {
    viewModel = state;
  }

  @Override
  public void injectView(WeakReference<PetsForAdoptionDetailContract.View> view) {
    this.view = view;
  }

  @Override
  public void injectModel(PetsForAdoptionDetailContract.Model model) {
    PetsForAdoptionDetailContract.Model model1 = model;
  }

  @Override
  public void injectRouter(PetsForAdoptionDetailContract.Router router) {
    this.router = router;
  }

  @Override
  public void fetchPetForAdoptionDetailData() {

    PetForAdoptionItem petForAdoptionItem = router.getDataFromPreviousScreen();
    if (petForAdoptionItem != null) {
      viewModel.petForAdoptionItem = petForAdoptionItem;
    }
    // update the view
    view.get().displayData(viewModel);

  }

  @Override
  public String getActualThemeName() {
    return router.getActualThemeName();
  }

  @Override
  public void onBackButtonClicked() {
    router.onBackButtonClicked();
  }

  @Override
  public void onEditButtonClicked() {
    router.navigateToEditPetForAdoptionScreen();
  }


}
