package es.ulpgc.montesdeoca110.cristina.zonget.userPickDate;

import android.content.Context;
import android.content.Intent;

import es.ulpgc.montesdeoca110.cristina.zonget.app.AppMediator;

public class UserPickDateRouter implements UserPickDateContract.Router {

  public static String TAG = UserPickDateRouter.class.getSimpleName();

  private final AppMediator mediator;

  public UserPickDateRouter(AppMediator mediator) {
    this.mediator = mediator;
  }

  @Override
  public void navigateToNextScreen() {
    Context context = mediator.getApplicationContext();
    Intent intent = new Intent(context, UserPickDateActivity.class);
    context.startActivity(intent);
  }

  @Override
  public void passDataToNextScreen(UserPickDateState state) {
    mediator.setUserPickDateState(state);
  }

  @Override
  public UserPickDateState getDataFromPreviousScreen() {
    return mediator.getUserPickDateState();

  }

  @Override
  public String getActualThemeName() {
    return mediator.getactualThemeName();
  }
}
