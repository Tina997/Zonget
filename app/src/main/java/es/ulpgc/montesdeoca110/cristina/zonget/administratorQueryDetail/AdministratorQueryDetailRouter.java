package es.ulpgc.montesdeoca110.cristina.zonget.administratorQueryDetail;

import android.content.Context;
import android.content.Intent;

import es.ulpgc.montesdeoca110.cristina.zonget.administratorQueryAnswer.AdministratorQueryAnswerActivity;
import es.ulpgc.montesdeoca110.cristina.zonget.app.AppMediator;
import es.ulpgc.montesdeoca110.cristina.zonget.app.statesBetweenActivities.InboxToQueryDetailState;

public class AdministratorQueryDetailRouter implements AdministratorQueryDetailContract.Router {

  public static String TAG = AdministratorQueryDetailRouter.class.getSimpleName();

  private AppMediator mediator;

  public AdministratorQueryDetailRouter(AppMediator mediator) {
    this.mediator = mediator;
  }

  @Override
  public void navigateToNextScreen() {
    Context context = mediator.getApplicationContext();
    Intent intent = new Intent(context, AdministratorQueryDetailActivity.class);
    context.startActivity(intent);
  }

  @Override
  public void passDataToNextScreen(AdministratorQueryDetailState state) {
    mediator.setAdministratorQueryDetailState(state);
  }

  @Override
  public InboxToQueryDetailState getDataFromPreviousScreen() {
    InboxToQueryDetailState state = mediator.getInboxToQueryDetailState();
    return state;
  }

  @Override
  public String getActualThemeName() {
    return mediator.getactualThemeName();
  }

  @Override
  public void navigateToAdministratorQueryAnswerScreen() {
    Context context = mediator.getApplicationContext();
    Intent intent = new Intent(context, AdministratorQueryAnswerActivity.class);
    intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
    context.startActivity(intent);
  }
}
