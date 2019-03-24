package es.ulpgc.montesdeoca110.cristina.zonget.administratorUsersList;

import android.util.Log;

import java.lang.ref.WeakReference;

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
        // Log.e(TAG, "fetchData()");

        // set passed state
        AdministratorUsersListState state = router.getDataFromPreviousScreen();
        /*if (state != null) {
            viewModel.data = state.data;
        }

        if (viewModel.data == null) {
            // call the model
            String data = model.fetchData();

            // set initial state
            viewModel.data = data;
        }
*/
        // update the view
        view.get().displayData(viewModel);

    }


}
