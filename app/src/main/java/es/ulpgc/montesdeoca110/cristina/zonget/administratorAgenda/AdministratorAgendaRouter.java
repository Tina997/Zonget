package es.ulpgc.montesdeoca110.cristina.zonget.administratorAgenda;

import android.content.Intent;
import android.content.Context;

import es.ulpgc.montesdeoca110.cristina.zonget.app.AppMediator;
import es.ulpgc.montesdeoca110.cristina.zonget.addEvent.AddEventActivity;

public class AdministratorAgendaRouter implements AdministratorAgendaContract.Router {

    public static String TAG = AdministratorAgendaRouter.class.getSimpleName();

    private AppMediator mediator;

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
    public void passDataToNextScreen(AdministratorAdministratorAgendaState state) {
       // mediator.setAdministratorAgendaState(state);
    }

    @Override
    public AdministratorAdministratorAgendaState getDataFromPreviousScreen() {
       // AdministratorAdministratorAgendaState state = mediator.getAdministratorAgendaState();
      //  return state;
        return null;
    }

    //Navegar entre pantallas
    @Override
    public void navigateToAgregarCitaScreen(){
        Context context = mediator.getApplicationContext();
        Intent intent = new Intent(context, AddEventActivity.class);
        context.startActivity(intent);
    }
}