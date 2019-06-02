package es.ulpgc.montesdeoca110.cristina.zonget.userNewQuery;

import java.lang.ref.WeakReference;

import es.ulpgc.montesdeoca110.cristina.zonget.app.statesBetweenActivities.SignInToMenuState;
import es.ulpgc.montesdeoca110.cristina.zonget.data.RepositoryContract;

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
  public String getActualThemeName() {
    return router.getActualThemeName();
  }

  @Override
  public void backButtonPressed() {
    router.navigateToUserQueriesMenuScreen();
  }

  @Override
  public void fetchUserNewQueryData() {
  }

  @Override
  public void sendButtonPressed(String title, String content) {
    if (title != "" || content != "") {
      view.get().startSendQuery();
      SignInToMenuState state = router.getDataFromSignInToMenuState();
      model.setNewQuery(state.account.getId(), title, content, new RepositoryContract.Queries.SetNewQueryCallback() {
        @Override
        public void onNewQuerySet(boolean correct) {
          if (correct) {
            view.get().finish();
            router.navigateToUserQueriesMenuScreen();
          } else {
            view.get().displayToastMessage("La pregunta no ha sido enviada correctamemte.");
          }
        }
      });
    } else {
      view.get().displayToastMessage("Falta información por introducir.");
    }
  }

}
