package es.ulpgc.montesdeoca110.cristina.zonget.userQueriesMenu;

import android.content.Context;
import android.content.Intent;

import es.ulpgc.montesdeoca110.cristina.zonget.app.AppMediator;
import es.ulpgc.montesdeoca110.cristina.zonget.userButtonsMenuList.UserButtonsMenuListActivity;
import es.ulpgc.montesdeoca110.cristina.zonget.userFinishedQueriesList.UserFinishedQueriesListActivity;
import es.ulpgc.montesdeoca110.cristina.zonget.userNewQuery.UserNewQueryActivity;
import es.ulpgc.montesdeoca110.cristina.zonget.userPendingQueriesList.UserPendingQueriesListActivity;

public class UserQueriesMenuRouter implements UserQueriesMenuContract.Router {

  private AppMediator mediator;

  public UserQueriesMenuRouter(AppMediator mediator) {
    this.mediator = mediator;
  }

  //UserButtonsMenuList

  @Override
  public void navigateToUserMenuScreen() {
    Context context = mediator.getApplicationContext();
    Intent intent = new Intent(context, UserButtonsMenuListActivity.class);
    intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
    context.startActivity(intent);
  }

  // UserNewQuery

  @Override
  public void passDataToUserNewQueryScreen() {

  }

  @Override
  public void navigateToUserNewQueryScreen() {
    Context context = mediator.getApplicationContext();
    Intent intent = new Intent(context, UserNewQueryActivity.class);
    intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
    context.startActivity(intent);
  }

  // UserPendingQueriesList

  @Override
  public void passDataToUserPendingQueriesListScreen() {

  }

  @Override
  public void navigateToUserPendingQueriesScreen() {
    Context context = mediator.getApplicationContext();
    Intent intent = new Intent(context, UserPendingQueriesListActivity.class);
    intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
    context.startActivity(intent);
  }

  // UserFinishedQueriesList

  @Override
  public void passDataToUserFinishedQueriesListScreen() {

  }

  @Override
  public void navigateToUserFinishedQueriesScreen() {
    Context context = mediator.getApplicationContext();
    Intent intent = new Intent(context, UserFinishedQueriesListActivity.class);
    intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
    context.startActivity(intent);
  }

}
