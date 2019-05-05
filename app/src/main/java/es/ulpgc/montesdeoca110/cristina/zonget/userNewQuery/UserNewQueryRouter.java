package es.ulpgc.montesdeoca110.cristina.zonget.userNewQuery;

import android.content.Context;
import android.content.Intent;
import es.ulpgc.montesdeoca110.cristina.zonget.app.AppMediator;
import es.ulpgc.montesdeoca110.cristina.zonget.userQueriesMenu.UserQueriesMenuActivity;

public class UserNewQueryRouter implements UserNewQueryContract.Router {

  private AppMediator mediator;

  public UserNewQueryRouter(AppMediator mediator) {
    this.mediator = mediator;
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
