package es.ulpgc.montesdeoca110.cristina.zonget.administratorUsersList;

import java.lang.ref.WeakReference;
import java.util.List;

import es.ulpgc.montesdeoca110.cristina.zonget.app.AccountItem;
import es.ulpgc.montesdeoca110.cristina.zonget.app.UserItem;
import es.ulpgc.montesdeoca110.cristina.zonget.data.RepositoryContract;

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
        /*model.fetchUsersData(new RepositoryContract.Accounts().GetUsersListCallback() {
            @Override
            public void setUsersList(List<AccountItem> users) {
                viewModel.users = users;
                view.get().displayData(viewModel);
            }
        });*/
        // update the view
        view.get().displayData(viewModel);

    }
    @Override
    public void selectAdminUserData(AccountItem item) {
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
