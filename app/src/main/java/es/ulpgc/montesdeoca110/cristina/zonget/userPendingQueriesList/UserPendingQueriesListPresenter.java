package es.ulpgc.montesdeoca110.cristina.zonget.userPendingQueriesList;

import android.util.Log;

import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.List;

import es.ulpgc.montesdeoca110.cristina.zonget.app.Query;
import es.ulpgc.montesdeoca110.cristina.zonget.app.statesBetweenActivities.SignInToMenuState;
import es.ulpgc.montesdeoca110.cristina.zonget.data.RepositoryContract;

public class UserPendingQueriesListPresenter implements UserPendingQueriesListContract.Presenter {

  private WeakReference<UserPendingQueriesListContract.View> view;
  private UserPendingQueriesListViewModel viewModel;
  private UserPendingQueriesListContract.Model model;
  private UserPendingQueriesListContract.Router router;

  public UserPendingQueriesListPresenter(UserPendingQueriesListState state) {
    viewModel = state;
  }

  @Override
  public String getActualThemeName() {
    return router.getActualThemeName();
  }

  @Override
  public void fetchUserPendingQueriesListData() {

    SignInToMenuState state = router.getDataFromSignInToMenuState();

    model.fetchUserPendingQueriesListData(state.account.getId(),new RepositoryContract.Queries.GetPendingQueriesListCallback() {
      @Override
      public void setQueriesList(List<Query> pendingQueries) {

        viewModel.pendingQueriesList = pendingQueries;

        view.get().displayUserPendingQueriesListData(viewModel);
      }
    });
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
