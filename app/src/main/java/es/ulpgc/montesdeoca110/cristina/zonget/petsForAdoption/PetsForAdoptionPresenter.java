package es.ulpgc.montesdeoca110.cristina.zonget.petsForAdoption;

import es.ulpgc.montesdeoca110.cristina.zonget.app.PetForAdoptionItem;
import es.ulpgc.montesdeoca110.cristina.zonget.data.RepositoryContract;
import java.lang.ref.WeakReference;
import java.util.List;

public class PetsForAdoptionPresenter implements PetsForAdoptionContract.Presenter {

  public static String TAG = PetsForAdoptionPresenter.class.getSimpleName();

  private WeakReference<PetsForAdoptionContract.View> view;
  private final PetsForAdoptionViewModel viewModel;
  private PetsForAdoptionContract.Model model;
  private PetsForAdoptionContract.Router router;

  public PetsForAdoptionPresenter(PetsForAdoptionState state) {
    viewModel = state;
  }

  @Override
  public void injectView(WeakReference<PetsForAdoptionContract.View> view) {
    this.view = view;
  }

  @Override
  public void injectModel(PetsForAdoptionContract.Model model) {
    this.model = model;
  }

  @Override
  public void injectRouter(PetsForAdoptionContract.Router router) {
    this.router = router;
  }

  @Override
  public void fetchPetsForAdoptionListData() {
    model.fetchPetsForAdoptionListData(new RepositoryContract.PetsForAdoption
            .GetPetsForAdoptionListCallback() {
      @Override
      public void setPetsForAdoptionList(List<PetForAdoptionItem> items) {
        viewModel.petForAdoptionItems = items;
        view.get().displayData(viewModel);
      }
    });
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
  public void selectPet(PetForAdoptionItem petForAdoptionItem) {
    router.passDataToDetailScreen(petForAdoptionItem);
    router.navigateToNextScreen();
  }

  @Override
  public void gotToAddPetForAdoption() {
    router.navigateToAddPetForAdoptionScreen();
  }


}
