package es.ulpgc.montesdeoca110.cristina.zonget.userFinishedQueriesList;

import android.util.Log;

import java.lang.ref.WeakReference;

public class UserFinishedQueriesListPresenter implements UserFinishedQueriesListContract.Presenter {

    public static String TAG = UserFinishedQueriesListPresenter.class.getSimpleName();

    private WeakReference<UserFinishedQueriesListContract.View> view;
    private UserFinishedQueriesListViewModel viewModel;
    private UserFinishedQueriesListContract.Model model;
    private UserFinishedQueriesListContract.Router router;

    public UserFinishedQueriesListPresenter(UserFinishedQueriesListState state) {
        viewModel = state;
    }

    @Override
    public void fetchData() {
        // Log.e(TAG, "fetchData()");

        // use passed state if is necessary
        UserFinishedQueriesListState state = router.getDataFromPreviousScreen();
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
    public void injectView(WeakReference<UserFinishedQueriesListContract.View> view) {
        this.view = view;
    }

    @Override
    public void injectModel(UserFinishedQueriesListContract.Model model) {
        this.model = model;
    }

    @Override
    public void injectRouter(UserFinishedQueriesListContract.Router router) {
        this.router = router;
    }
}
