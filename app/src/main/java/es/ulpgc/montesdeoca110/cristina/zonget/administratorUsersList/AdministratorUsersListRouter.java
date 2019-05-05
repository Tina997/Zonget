package es.ulpgc.montesdeoca110.cristina.zonget.administratorUsersList;

import android.content.Context;
import android.content.Intent;

import es.ulpgc.montesdeoca110.cristina.zonget.administratorSearchUsers.AdministratorSearchUsersActivity;
import es.ulpgc.montesdeoca110.cristina.zonget.administratorUsersPets.AdministratorUsersPetsListActivity;
import es.ulpgc.montesdeoca110.cristina.zonget.app.AppMediator;
import es.ulpgc.montesdeoca110.cristina.zonget.app.UserItem;

public class AdministratorUsersListRouter implements AdministratorUsersListContract.Router {

  public static String TAG = AdministratorUsersListRouter.class.getSimpleName();

  private AppMediator mediator;

  public AdministratorUsersListRouter(AppMediator mediator) {
    this.mediator = mediator;
  }


  @Override
  public AdministratorUsersListState getDataFromPreviousScreen() {
    AdministratorUsersListState state = mediator.getAdministratorUsersListState();
    return state;
  }

  @Override
  public void passDataToUserDetailScreen(UserItem item) {
    mediator.setUserItem(item);
  }

  @Override
  public void navigateToUserDetailScreen() {
    Context context = mediator.getApplicationContext();
    Intent intent = new Intent(context, AdministratorUsersPetsListActivity.class);
    intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
    context.startActivity(intent);
  }

  @Override
  public String getActualThemeName() {
    return mediator.getactualThemeName();
  }

  @Override
  public void onBackButtonPressed() {
    Context context = mediator.getApplicationContext();
    Intent intent = new Intent(context, AdministratorSearchUsersActivity.class);
    intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
    context.startActivity(intent);
  }
}
