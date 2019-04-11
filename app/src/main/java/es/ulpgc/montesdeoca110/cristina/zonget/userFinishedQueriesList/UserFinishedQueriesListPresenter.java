package es.ulpgc.montesdeoca110.cristina.zonget.userFinishedQueriesList;


import java.lang.ref.WeakReference;

public class UserFinishedQueriesListPresenter implements UserFinishedQueriesListContract.Presenter {

    private WeakReference<UserFinishedQueriesListContract.View> view;
    private UserFinishedQueriesListViewModel viewModel;
    private UserFinishedQueriesListContract.Model model;
    private UserFinishedQueriesListContract.Router router;

    public UserFinishedQueriesListPresenter(UserFinishedQueriesListState state) {
        viewModel = state;
    }

    @Override
    public void fetchUserFinishedQueriesListData() {

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

    @Override
    public void backButtonPressed() {
        router.navigateToUserQueriesMenuScreen();
    }
}
