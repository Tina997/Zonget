package es.ulpgc.montesdeoca110.cristina.zonget.userQueriesMenu;

import java.lang.ref.WeakReference;

public class UserQueriesMenuPresenter implements UserQueriesMenuContract.Presenter {

    public static String TAG = UserQueriesMenuPresenter.class.getSimpleName();

    private WeakReference<UserQueriesMenuContract.View> view;
    private UserQueriesMenuViewModel viewModel;
    private UserQueriesMenuContract.Model model;
    private UserQueriesMenuContract.Router router;

    public UserQueriesMenuPresenter(UserQueriesMenuState state) {
        viewModel = state;
    }

    @Override
    public void injectView(WeakReference<UserQueriesMenuContract.View> view) {
        this.view = view;
    }

    @Override
    public void injectModel(UserQueriesMenuContract.Model model) {
        this.model = model;
    }

    @Override
    public void injectRouter(UserQueriesMenuContract.Router router) {
        this.router = router;
    }

    @Override
    public void backButtonPressed() {
        router.navigateToUserMenu();
    }

    @Override
    public void fetchData() {
        // Log.e(TAG, "fetchInboxData()");

        // set passed state
        UserQueriesMenuState state = router.getDataFromPreviousScreen();
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
