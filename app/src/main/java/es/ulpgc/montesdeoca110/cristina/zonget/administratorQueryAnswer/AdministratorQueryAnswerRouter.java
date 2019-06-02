package es.ulpgc.montesdeoca110.cristina.zonget.administratorQueryAnswer;

import android.content.Context;
import android.content.Intent;
import es.ulpgc.montesdeoca110.cristina.zonget.administratorInbox.AdministratorInboxActivity;
import es.ulpgc.montesdeoca110.cristina.zonget.administratorQueryDetail.AdministratorQueryDetailActivity;
import es.ulpgc.montesdeoca110.cristina.zonget.administratorQueryDetail.AdministratorQueryDetailState;
import es.ulpgc.montesdeoca110.cristina.zonget.app.AppMediator;
import es.ulpgc.montesdeoca110.cristina.zonget.app.statesBetweenActivities.InboxToQueryDetailState;

public class AdministratorQueryAnswerRouter implements AdministratorQueryAnswerContract.Router {

  public static String TAG = AdministratorQueryAnswerRouter.class.getSimpleName();

  private final AppMediator mediator;

  public AdministratorQueryAnswerRouter(AppMediator mediator) {
    this.mediator = mediator;
  }

  @Override
  public void navigateToNextScreen() {
    Context context = mediator.getApplicationContext();
    Intent intent = new Intent(context, AdministratorQueryAnswerActivity.class);
    context.startActivity(intent);
  }

  @Override
  public void passDataToNextScreen(AdministratorQueryAnswerState state) {
    mediator.setAdministratorQueryAnswerState(state);
  }

  @Override
  public InboxToQueryDetailState getDataFromPreviousScreen() {
    return mediator.getInboxToQueryDetailState();
  }

  @Override
  public String getActualThemeName() {
    return mediator.getactualThemeName();
  }

  @Override
  public void navigateToAdministratorInboxScreen() {
    Context context = mediator.getApplicationContext();
    Intent intent = new Intent(context, AdministratorInboxActivity.class);
    intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
    context.startActivity(intent);
  }

  @Override
  public InboxToQueryDetailState getInboxToQueryDetailState(){
    return mediator.getInboxToQueryDetailState();
  }

  @Override
  public void navigateToQueryDetailScreen() {
    Context context = mediator.getApplicationContext();
    Intent intent = new Intent(context, AdministratorQueryDetailActivity.class);
    intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
    context.startActivity(intent);
  }
}
