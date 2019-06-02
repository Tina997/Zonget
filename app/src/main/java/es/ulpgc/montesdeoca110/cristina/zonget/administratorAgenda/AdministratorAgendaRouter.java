package es.ulpgc.montesdeoca110.cristina.zonget.administratorAgenda;

import android.content.Context;
import android.content.Intent;
import es.ulpgc.montesdeoca110.cristina.zonget.addEvent.AddEventActivity;
import es.ulpgc.montesdeoca110.cristina.zonget.administratorButtonsMenuList.AdministratorButtonsMenuListActivity;

import es.ulpgc.montesdeoca110.cristina.zonget.app.AppMediator;

import es.ulpgc.montesdeoca110.cristina.zonget.modifyEvent.ModifyEventActivity;

public class AdministratorAgendaRouter implements AdministratorAgendaContract.Router {

  public static String TAG = AdministratorAgendaRouter.class.getSimpleName();

  private final AppMediator mediator;

  public AdministratorAgendaRouter(AppMediator mediator) {
    this.mediator = mediator;
  }

  @Override
  public void navigateToNextScreen() {
    Context context = mediator.getApplicationContext();
    Intent intent = new Intent(context, AdministratorAgendaActivity.class);
    context.startActivity(intent);
  }

  @Override
  public void passDataToNextScreen(AdministratorAgendaState state) {
    mediator.setAdministratorAgendaState(state);
  }


  @Override
  public AdministratorAgendaState getDataFromPreviousScreen() {
    return mediator.getAdministratorAgendaState();
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

  //Navegar entre pantallas
  @Override
  public void navigateToAddEventScreen() {
    Context context = mediator.getApplicationContext();
    Intent intent = new Intent(context, AddEventActivity.class);
    intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
    context.startActivity(intent);
  }

  @Override
  public void navigateToModifyEventScreen() {
    Context context = mediator.getApplicationContext();
    Intent intent = new Intent(context, ModifyEventActivity.class);
    intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
    context.startActivity(intent);
  }

}
