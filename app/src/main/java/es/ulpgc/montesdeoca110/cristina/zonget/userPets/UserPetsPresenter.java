package es.ulpgc.montesdeoca110.cristina.zonget.userPets;

import java.lang.ref.WeakReference;
import java.util.List;

import es.ulpgc.montesdeoca110.cristina.zonget.app.AccountItem;
import es.ulpgc.montesdeoca110.cristina.zonget.app.UserPetItem;
import es.ulpgc.montesdeoca110.cristina.zonget.data.RepositoryContract;

public class UserPetsPresenter implements UserPetsContract.Presenter {

  public static String TAG = UserPetsPresenter.class.getSimpleName();

  private WeakReference<UserPetsContract.View> view;
  private final UserPetsViewModel viewModel;
  private UserPetsContract.Model model;
  private UserPetsContract.Router router;

  public UserPetsPresenter(UserPetsState state) {
    viewModel = state;
  }

  @Override
  public void injectView(WeakReference<UserPetsContract.View> view) {
    this.view = view;
  }

  @Override
  public void injectModel(UserPetsContract.Model model) {
    this.model = model;
  }

  @Override
  public void injectRouter(UserPetsContract.Router router) {
    this.router = router;
  }

  @Override
  public void fetchUserPetsData() {
    //Log.e(TAG, "fetchInboxData()");
    AccountItem item = router.getDataFromSignIn();
    model.fetchPetsData(item, new RepositoryContract.Accounts.GetUserPetsListCallback() {
      @Override
      public void setUserPetsList(List<UserPetItem> userPets) {
        viewModel.pets = userPets;
//                Log.e(TAG,viewModel.pets.get(0).getName());
        view.get().displayUserPetsData(viewModel);
      }
    });
    // set passed state
        /*UserPetsState state = router.getDataFromPreviousScreen();
        viewModel.animales = model.fetchPetsData();
        view.get().displayUserPetsData(viewModel);*/

  }

  @Override
  public void selectUserPetsData(UserPetItem item) {
    router.passDataToPetsDetailScreen(item);
    router.navigateToPetsDetailScreen();
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
