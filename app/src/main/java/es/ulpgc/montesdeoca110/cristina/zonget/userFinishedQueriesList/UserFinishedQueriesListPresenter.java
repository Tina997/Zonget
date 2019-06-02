package es.ulpgc.montesdeoca110.cristina.zonget.userFinishedQueriesList;

import java.lang.ref.WeakReference;
import java.util.List;

import es.ulpgc.montesdeoca110.cristina.zonget.app.Query;
import es.ulpgc.montesdeoca110.cristina.zonget.app.statesBetweenActivities.SignInToMenuState;
import es.ulpgc.montesdeoca110.cristina.zonget.data.RepositoryContract;

public class UserFinishedQueriesListPresenter implements UserFinishedQueriesListContract.Presenter {

  private WeakReference<UserFinishedQueriesListContract.View> view;
  private final UserFinishedQueriesListViewModel viewModel;
  private UserFinishedQueriesListContract.Model model;
  private UserFinishedQueriesListContract.Router router;

  public UserFinishedQueriesListPresenter(UserFinishedQueriesListState state) {
    viewModel = state;
  }

  @Override
  public String getActualThemeName() {
    return router.getActualThemeName();
  }

  @Override
  public void fetchUserFinishedQueriesListData() {

    SignInToMenuState state = router.getDataFromSignInToMenuState();

    model.fetchUserFinishedQueriesListData(state.account.getId(), new RepositoryContract.Queries.GetFinishedQueriesListCallback() {
      @Override
      public void setQueriesList(List<Query> finishedQueriesList) {
        viewModel.finishedQueriesList = finishedQueriesList;

        view.get().displayUserFinishedQueriesListData(viewModel);
      }
    });

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
