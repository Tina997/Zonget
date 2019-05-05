package es.ulpgc.montesdeoca110.cristina.zonget.userPets;

import android.util.Log;

import es.ulpgc.montesdeoca110.cristina.zonget.app.AccountItem;
import es.ulpgc.montesdeoca110.cristina.zonget.app.PetsItem;
import es.ulpgc.montesdeoca110.cristina.zonget.data.RepositoryContract;
import java.lang.ref.WeakReference;
import java.util.List;

public class UserPetsPresenter implements UserPetsContract.Presenter {

  public static String TAG = UserPetsPresenter.class.getSimpleName();

  private WeakReference<UserPetsContract.View> view;
  private UserPetsViewModel viewModel;
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
    Log.e("", "Holi");
    model.fetchPetsData(item, new RepositoryContract.Accounts.GetUserPetsListCallback() {
      @Override
      public void setUserPetsList(List<PetsItem> userPets) {
        //Log.e(TAG, userPets.get(0).name);
        viewModel.pets = userPets;
        view.get().displayUserPetsData(viewModel);
      }
    });
    // set passed state
    /*UserPetsState state = router.getDataFromPreviousScreen();
    viewModel.animales = model.fetchPetsData();
    view.get().displayUserPetsData(viewModel);*/

  }

  @Override
  public void selectUserPetsData(PetsItem item) {
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
