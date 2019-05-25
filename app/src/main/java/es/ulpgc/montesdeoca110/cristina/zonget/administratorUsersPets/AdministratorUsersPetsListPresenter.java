package es.ulpgc.montesdeoca110.cristina.zonget.administratorUsersPets;

import android.util.Log;

import java.lang.ref.WeakReference;
import java.util.List;

import es.ulpgc.montesdeoca110.cristina.zonget.app.AccountItem;
import es.ulpgc.montesdeoca110.cristina.zonget.app.UserPetItem;
import es.ulpgc.montesdeoca110.cristina.zonget.data.RepositoryContract;

public class AdministratorUsersPetsListPresenter implements AdministratorUsersPetsListContract.Presenter {

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
        AccountItem item = router.getDataFromPreviousScreen().user;
    if(item != null){
        model.fetchPetsData(item, new RepositoryContract.Accounts.GetUserPetsListCallback() {
            @Override
            public void setUserPetsList(List<UserPetItem> userPets) {
  //              Log.e(TAG, userPets.get(0).getName());
                viewModel.pets = userPets;
//                Log.e(TAG,viewModel.pets.get(0).getName());
                view.get().displayUserPetsData(viewModel);
            }
        });}
    }

    @Override
    public void selectUserPetsData(UserPetItem item) {
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
