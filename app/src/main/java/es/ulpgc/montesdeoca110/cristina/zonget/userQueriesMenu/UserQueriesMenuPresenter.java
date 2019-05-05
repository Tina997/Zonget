package es.ulpgc.montesdeoca110.cristina.zonget.userQueriesMenu;

import java.lang.ref.WeakReference;

public class UserQueriesMenuPresenter implements UserQueriesMenuContract.Presenter {

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
    router.navigateToUserMenuScreen();
  }

  @Override
  public void newQueryButtonPressed() {
    router.passDataToUserNewQueryScreen();
    router.navigateToUserNewQueryScreen();
  }

  @Override
  public void pendingQueriesButtonPressed() {
    router.passDataToUserPendingQueriesListScreen();
    router.navigateToUserPendingQueriesScreen();
  }

  @Override
  public void finishedQueriesButtonPressed() {
    router.passDataToUserFinishedQueriesListScreen();
    router.navigateToUserFinishedQueriesScreen();
  }

  @Override
  public void fetchUserQueriesMenuData() {

  }


}
