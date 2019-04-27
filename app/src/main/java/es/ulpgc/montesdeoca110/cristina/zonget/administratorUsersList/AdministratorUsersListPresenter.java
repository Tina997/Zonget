package es.ulpgc.montesdeoca110.cristina.zonget.administratorUsersList;

import android.util.Log;

import java.lang.ref.WeakReference;

import es.ulpgc.montesdeoca110.cristina.zonget.administratorSearchUsers.AdministratorSearchUsersState;
import es.ulpgc.montesdeoca110.cristina.zonget.app.UserItem;

public class AdministratorUsersListPresenter implements AdministratorUsersListContract.Presenter {

    public static String TAG = AdministratorUsersListPresenter.class.getSimpleName();

    private WeakReference<AdministratorUsersListContract.View> view;
    private AdministratorUsersListViewModel viewModel;
    private AdministratorUsersListContract.Model model;
    private AdministratorUsersListContract.Router router;

    public AdministratorUsersListPresenter(AdministratorUsersListState state) {
        viewModel = state;
    }

    @Override
    public void injectView(WeakReference<AdministratorUsersListContract.View> view) {
        this.view = view;
    }

    @Override
    public void injectModel(AdministratorUsersListContract.Model model) {
        this.model = model;
    }

    @Override
    public void injectRouter(AdministratorUsersListContract.Router router) {
        this.router = router;
    }

    @Override
    public void fetchAdminUsersData() {
        // Log.e(TAG, "fetchPetsForAdoptionListData()");
        // set passed state
        //AdministratorUsersListState state = router.getDataFromPreviousScreen();
        viewModel.users=model.fetchUsersData();
        // update the view
        view.get().displayData(viewModel);

    }
    @Override
    public void selectAdminUserData(UserItem item) {
        router.passDataToUserDetailScreen(item);
        router.navigateToUserDetailScreen();
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
