package es.ulpgc.montesdeoca110.cristina.zonget.userNewQuery;

import java.lang.ref.WeakReference;

public class UserNewQueryPresenter implements UserNewQueryContract.Presenter {

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
    public void backButtonPressed() {
        router.navigateToUserQueriesMenuScreen();
    }

    @Override
    public void fetchUserNewQueryData() {

    }

}
