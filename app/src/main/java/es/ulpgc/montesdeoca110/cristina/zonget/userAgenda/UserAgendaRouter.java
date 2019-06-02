package es.ulpgc.montesdeoca110.cristina.zonget.userAgenda;

import android.content.Context;
import android.content.Intent;

import es.ulpgc.montesdeoca110.cristina.zonget.app.AppMediator;
import es.ulpgc.montesdeoca110.cristina.zonget.userButtonsMenuList.UserButtonsMenuListActivity;

public class UserAgendaRouter implements UserAgendaContract.Router {

  public static String TAG = UserAgendaRouter.class.getSimpleName();

  private final AppMediator mediator;

  public UserAgendaRouter(AppMediator mediator) {
    this.mediator = mediator;
  }

  @Override
  public void navigateToNextScreen() {
    Context context = mediator.getApplicationContext();
    Intent intent = new Intent(context, UserAgendaActivity.class);
    context.startActivity(intent);
  }

  @Override
  public void passDataToNextScreen(UserAgendaState state) {
    mediator.setUserAgendaState(state);
  }

  @Override
  public UserAgendaState getDataFromPreviousScreen() {
    return mediator.getUserAgendaState();
  }

  @Override
  public String getActualThemeName() {
    return mediator.getactualThemeName();
  }

  @Override
  public void onBackButtonPressed() {
    Context context = mediator.getApplicationContext();
    Intent intent = new Intent(context, UserButtonsMenuListActivity.class);
    intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
    context.startActivity(intent);
  }
}
