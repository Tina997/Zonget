package es.ulpgc.montesdeoca110.cristina.zonget.addEvent;

import android.content.Context;
import android.content.Intent;

import es.ulpgc.montesdeoca110.cristina.zonget.administratorAgenda.AdministratorAgendaActivity;
import es.ulpgc.montesdeoca110.cristina.zonget.app.AppMediator;

public class AddEventRouter implements AddEventContract.Router {

  public static String TAG = AddEventRouter.class.getSimpleName();

  private final AppMediator mediator;

  public AddEventRouter(AppMediator mediator) {
    this.mediator = mediator;
  }

  @Override
  public void navigateToNextScreen() {
    Context context = mediator.getApplicationContext();
    Intent intent = new Intent(context, AddEventActivity.class);
    context.startActivity(intent);
  }

  @Override
  public void passDataToNextScreen(AddEventState state) {
    mediator.setAddEventState(state);
  }

  @Override
  public AddEventState getDataFromPreviousScreen() {
    return mediator.getAddEventState();
  }

  @Override
  public String getActualThemeName() {
    return mediator.getactualThemeName();
  }

  @Override
  public void onBackButtonPressed() {
    Context context = mediator.getApplicationContext();
    Intent intent = new Intent(context, AdministratorAgendaActivity.class);
    intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
    context.startActivity(intent);
  }

  @Override
  public void navigateToAdministratorAgendaScreen() {
    Context context = mediator.getApplicationContext();
    Intent intent = new Intent(context, AdministratorAgendaActivity.class);
    intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
    context.startActivity(intent);
  }
}
