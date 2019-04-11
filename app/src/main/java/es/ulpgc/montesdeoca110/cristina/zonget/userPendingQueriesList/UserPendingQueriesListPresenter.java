package es.ulpgc.montesdeoca110.cristina.zonget.userPendingQueriesList;

import java.lang.ref.WeakReference;

public class UserPendingQueriesListPresenter implements UserPendingQueriesListContract.Presenter {

    private WeakReference<UserPendingQueriesListContract.View> view;
    private UserPendingQueriesListViewModel viewModel;
    private UserPendingQueriesListContract.Model model;
    private UserPendingQueriesListContract.Router router;

    public UserPendingQueriesListPresenter(UserPendingQueriesListState state) {
        viewModel = state;
    }

    @Override
    public void fetchUserPendingQueriesListData() {

    }

    @Override
    public void injectView(WeakReference<UserPendingQueriesListContract.View> view) {
        this.view = view;
    }

    @Override
    public void injectModel(UserPendingQueriesListContract.Model model) {
        this.model = model;
    }

    @Override
    public void injectRouter(UserPendingQueriesListContract.Router router) {
        this.router = router;
    }

    @Override
    public void backButtonPressed() {
        router.navigateToUserQueriesMenuScreen();
    }
}
