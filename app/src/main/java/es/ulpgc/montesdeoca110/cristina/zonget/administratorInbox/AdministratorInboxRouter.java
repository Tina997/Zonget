package es.ulpgc.montesdeoca110.cristina.zonget.administratorInbox;

import android.content.Context;
import android.content.Intent;

import es.ulpgc.montesdeoca110.cristina.zonget.administratorButtonsMenuList.AdministratorButtonsMenuListActivity;
import es.ulpgc.montesdeoca110.cristina.zonget.administratorQueryDetail.AdministratorQueryDetailActivity;
import es.ulpgc.montesdeoca110.cristina.zonget.app.AppMediator;
import es.ulpgc.montesdeoca110.cristina.zonget.app.QueryItem;
import es.ulpgc.montesdeoca110.cristina.zonget.app.statesBetweenActivities.InboxToQueryDetailState;

public class AdministratorInboxRouter implements AdministratorInboxContract.Router {

  public static String TAG = AdministratorInboxRouter.class.getSimpleName();

  private final AppMediator mediator;

  public AdministratorInboxRouter(AppMediator mediator) {
    this.mediator = mediator;
  }

  @Override
  public void navigateToNextScreen() {
    Context context = mediator.getApplicationContext();
    Intent intent = new Intent(context, AdministratorInboxActivity.class);
    context.startActivity(intent);
  }

  @Override
  public void passDataToNextScreen(AdministratorInboxState state) {
    mediator.setAdministratorInboxState(state);
  }

  @Override
  public AdministratorInboxState getDataFromPreviousScreen() {
    return mediator.getAdministratorInboxState();
  }

  @Override
  public String getActualThemeName() {
    return mediator.getactualThemeName();
  }

  @Override
  public void onBackButtonPressed() {
    Context context = mediator.getApplicationContext();
    Intent intent = new Intent(context, AdministratorButtonsMenuListActivity.class);
    intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
    context.startActivity(intent);
  }

  @Override
  public void navigateToAdministratorQueryDetailScreen() {
    Context context = mediator.getApplicationContext();
    Intent intent = new Intent(context, AdministratorQueryDetailActivity.class);
    intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
    context.startActivity(intent);
  }

  @Override
  public void passDataToQueryDetailScreen(QueryItem item){
    InboxToQueryDetailState state = new InboxToQueryDetailState();
    state.query = item;
    mediator.setInboxToQueryDetailState(state);
  }
}
