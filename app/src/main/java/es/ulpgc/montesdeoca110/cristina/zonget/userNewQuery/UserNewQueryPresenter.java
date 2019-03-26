package es.ulpgc.montesdeoca110.cristina.zonget.userNewQuery;

import java.lang.ref.WeakReference;

public class UserNewQueryPresenter implements UserNewQueryContract.Presenter {

    public static String TAG = UserNewQueryPresenter.class.getSimpleName();

    private WeakReference<UserNewQueryContract.View> view;
    private UserNewQueryViewModel viewModel;
    private UserNewQueryContract.Model model;
    private UserNewQueryContract.Router router;

    public UserNewQueryPresenter(UserNewQueryState state) {
        viewModel = state;
    }

    @Override
    public void injectView(WeakReference<UserNewQueryContract.View> view) {
        this.view = view;
    }

    @Override
    public void injectModel(UserNewQueryContract.Model model) {
        this.model = model;
    }

    @Override
    public void injectRouter(UserNewQueryContract.Router router) {
        this.router = router;
    }

    @Override
    public void fetchData() {
        // Log.e(TAG, "fetchData()");

        // set passed state
        UserNewQueryState state = router.getDataFromPreviousScreen();
        if (state != null) {
            viewModel.data = state.data;
        }

        if (viewModel.data == null) {
            // call the model
            String data = model.fetchData();

            // set initial state
            viewModel.data = data;
        }

        // update the view
        view.get().displayData(viewModel);

    }


}
