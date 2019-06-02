package es.ulpgc.montesdeoca110.cristina.zonget.changeTheme;

import android.content.Context;
import android.content.Intent;

import es.ulpgc.montesdeoca110.cristina.zonget.administratorButtonsMenuList.AdministratorButtonsMenuListActivity;
import es.ulpgc.montesdeoca110.cristina.zonget.app.AppMediator;
import es.ulpgc.montesdeoca110.cristina.zonget.app.statesBetweenActivities.ChangeThemeToMenuState;
import es.ulpgc.montesdeoca110.cristina.zonget.userButtonsMenuList.UserButtonsMenuListActivity;

public class ChangeThemeRouter implements ChangeThemeContract.Router {

  private final AppMediator mediator;

  public ChangeThemeRouter(AppMediator mediator) {
    this.mediator = mediator;
  }

  @Override
  public String getActualThemeName() {
    return mediator.getactualThemeName();
  }

  @Override
  public void changeActualTheme(String themeName) {
    mediator.setActualThemeName(themeName);
  }

  @Override
  public void navigateToMenuScreen() {
    Context context = mediator.getApplicationContext();
    Intent intent = new Intent();
    switch (mediator.getSignInToMenuState().account.getType()) {

      case "administrator":
        intent = new Intent(context, AdministratorButtonsMenuListActivity.class);
        break;

      case "user":
        intent = new Intent(context, UserButtonsMenuListActivity.class);
        break;

      default:
        break;

    }
    intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
    context.startActivity(intent);
  }

  @Override
  public void passDataToMenuScreen(ChangeThemeToMenuState state) {
    mediator.setChangeThemeToMenuState(state);
  }

  @Override
  public ChangeThemeState getDataFromPreviousScreen() {
    return mediator.getChangeThemeState();
  }
}
