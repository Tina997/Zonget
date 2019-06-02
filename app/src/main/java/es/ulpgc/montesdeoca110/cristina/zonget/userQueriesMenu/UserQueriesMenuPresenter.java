package es.ulpgc.montesdeoca110.cristina.zonget.userQueriesMenu;

import android.view.View;

import java.lang.ref.WeakReference;

import es.ulpgc.montesdeoca110.cristina.zonget.app.statesBetweenActivities.SignInToMenuState;
import es.ulpgc.montesdeoca110.cristina.zonget.data.RepositoryContract;

public class UserQueriesMenuPresenter implements UserQueriesMenuContract.Presenter {

  private WeakReference<UserQueriesMenuContract.View> view;
  private final UserQueriesMenuViewModel viewModel;
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
  public String getActualThemeName() {
    return router.getActualThemeName();
  }

  @Override
  public void backButtonPressed() {
    router.navigateToUserMenuScreen();
  }

  @Override
  public void fetchUserQueriesMenuData() {
    SignInToMenuState state = router.getSignInToMenuState();

    model.fetchUserQueriesMenuData(state.account.getId(), new RepositoryContract.Queries.GetQueriesListSizeCallback() {
      @Override
      public void setQueriesListSize(int pendingQueriesListSize, int finishedQueriesListSize) {
        if (pendingQueriesListSize > 0) {
          viewModel.penndingQueriesCardViewVisibility = View.VISIBLE;
          viewModel.pendingQueriesCounter = pendingQueriesListSize;
        } else {
          viewModel.penndingQueriesCardViewVisibility = View.GONE;
        }

        if (finishedQueriesListSize > 0) {
          viewModel.finishedQueriesCardViewVisibility = View.VISIBLE;
          viewModel.finishedQueriesCounter = finishedQueriesListSize;
        } else {
          viewModel.finishedQueriesCardViewVisibility = View.GONE;
        }

        view.get().displayUserQueriesMenuData(viewModel);
      }
    });
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

}
