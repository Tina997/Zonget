package es.ulpgc.montesdeoca110.cristina.zonget.userPendingQueriesList;

import android.util.Log;

import java.lang.ref.WeakReference;

public class UserPendingQueriesPresenter implements UserPendingQueriesContract.Presenter {

    public static String TAG = UserPendingQueriesPresenter.class.getSimpleName();

    private WeakReference<UserPendingQueriesContract.View> view;
    private UserPendingQueriesViewModel viewModel;
    private UserPendingQueriesContract.Model model;
    private UserPendingQueriesContract.Router router;

    public UserPendingQueriesPresenter(UserPendingQueriesState state) {
        viewModel = state;
    }

    @Override
    public void fetchData() {
        // Log.e(TAG, "fetchData()");

        // use passed state if is necessary
        UserPendingQueriesState state = router.getDataFromPreviousScreen();
        if (state != null) {

            // update view and model state
            viewModel.data = state.data;

            // update the view
            view.get().displayData(viewModel);

            return;
        }

        // call the model  
        String data = model.fetchData();

        // set view state
        viewModel.data = data;

        // update the view
        view.get().displayData(viewModel);

    }

    @Override
    public void injectView(WeakReference<UserPendingQueriesContract.View> view) {
        this.view = view;
    }

    @Override
    public void injectModel(UserPendingQueriesContract.Model model) {
        this.model = model;
    }

    @Override
    public void injectRouter(UserPendingQueriesContract.Router router) {
        this.router = router;
    }
}
