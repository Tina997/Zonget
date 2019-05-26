package es.ulpgc.montesdeoca110.cristina.zonget.userNewQuery;

import android.content.Context;
import android.content.Intent;
import es.ulpgc.montesdeoca110.cristina.zonget.app.AppMediator;
import es.ulpgc.montesdeoca110.cristina.zonget.app.statesBetweenActivities.SignInToMenuState;
import es.ulpgc.montesdeoca110.cristina.zonget.userQueriesMenu.UserQueriesMenuActivity;

public class UserNewQueryRouter implements UserNewQueryContract.Router {

  private AppMediator mediator;

  public UserNewQueryRouter(AppMediator mediator) {
    this.mediator = mediator;
  }

  @Override
  public String getActualThemeName() {
    return mediator.getactualThemeName();
  }

  // UserQueriesMenu

  @Override
  public void passDataToUserQueriesMenuScreen() {}

  @Override
  public void navigateToUserQueriesMenuScreen() {
    Context context = mediator.getApplicationContext();
    Intent intent = new Intent(context, UserQueriesMenuActivity.class);
    intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
    context.startActivity(intent);
  }

  @Override
  public SignInToMenuState getDataFromSignInToMenuState() {
    return mediator.getSignInToMenuState();
  }

}
