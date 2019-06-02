package es.ulpgc.montesdeoca110.cristina.zonget.modifyEvent;

import android.content.Context;
import android.content.Intent;
import es.ulpgc.montesdeoca110.cristina.zonget.administratorAgenda.AdministratorAgendaActivity;

import es.ulpgc.montesdeoca110.cristina.zonget.app.AppMediator;

public class ModifyEventRouter implements ModifyEventContract.Router {

  public static String TAG = ModifyEventRouter.class.getSimpleName();

  private final AppMediator mediator;

  public ModifyEventRouter(AppMediator mediator) {
    this.mediator = mediator;
  }

  @Override
  public void navigateToNextScreen() {
    Context context = mediator.getApplicationContext();
    Intent intent = new Intent(context, ModifyEventActivity.class);
    context.startActivity(intent);
  }

  @Override
  public void passDataToNextScreen(ModifyEventState state) {
    mediator.setModifyEventState(state);
  }

  @Override
  public ModifyEventState getDataFromPreviousScreen() {
    return mediator.getModifyEventState();
  }

  @Override
  public String getActualThemeName() {
    return mediator.getactualThemeName();
  }

  @Override
  public void navigateToAdministratorAgendaScreen() {
    Context context = mediator.getApplicationContext();
    Intent intent = new Intent(context, AdministratorAgendaActivity.class);
    intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
    context.startActivity(intent);
  }
}
