package es.ulpgc.montesdeoca110.cristina.zonget.administratorQueryAnswer;

import android.content.Context;
import android.content.Intent;
import es.ulpgc.montesdeoca110.cristina.zonget.administratorInbox.AdministratorInboxActivity;
import es.ulpgc.montesdeoca110.cristina.zonget.app.AppMediator;

public class AdministratorQueryAnswerRouter implements AdministratorQueryAnswerContract.Router {

  public static String TAG = AdministratorQueryAnswerRouter.class.getSimpleName();

  private AppMediator mediator;

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
  public AdministratorQueryAnswerState getDataFromPreviousScreen() {
    AdministratorQueryAnswerState state = mediator.getAdministratorQueryAnswerState();
    return state;
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
}
