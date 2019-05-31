package es.ulpgc.montesdeoca110.cristina.zonget.userFinishedQueriesList;

import android.content.Context;

import android.content.Intent;

import es.ulpgc.montesdeoca110.cristina.zonget.app.AppMediator;
import es.ulpgc.montesdeoca110.cristina.zonget.app.statesBetweenActivities.SignInToMenuState;
import es.ulpgc.montesdeoca110.cristina.zonget.userQueriesMenu.UserQueriesMenuActivity;

public class UserFinishedQueriesListRouter implements UserFinishedQueriesListContract.Router {

  private AppMediator mediator;

  public UserFinishedQueriesListRouter(AppMediator mediator) {
    this.mediator = mediator;
  }

  @Override
  public SignInToMenuState getDataFromSignInToMenuState() {
    return mediator.getSignInToMenuState();
  }

  // UserQueriesMenu

  @Override
  public void passDataToUserQueriesMenuScreen() {

  }

  @Override
  public void navigateToUserQueriesMenuScreen() {
    Context context = mediator.getApplicationContext();
    Intent intent = new Intent(context, UserQueriesMenuActivity.class);
    intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
    context.startActivity(intent);
  }

}
