package es.ulpgc.montesdeoca110.cristina.zonget.agendaAdmin;

import android.content.Intent;
import android.content.Context;

import es.ulpgc.montesdeoca110.cristina.zonget.app.AppMediator;
import es.ulpgc.montesdeoca110.cristina.zonget.agregarCita.AgregarCitaActivity;

public class AgendaAdminRouter implements AgendaAdminContract.Router {

    public static String TAG = AgendaAdminRouter.class.getSimpleName();

    private AppMediator mediator;

    public AgendaAdminRouter(AppMediator mediator) {
        this.mediator = mediator;
    }

    @Override
    public void navigateToNextScreen() {
        Context context = mediator.getApplicationContext();
        Intent intent = new Intent(context, AgendaAdminActivity.class);
        context.startActivity(intent);
    }

    @Override
    public void passDataToNextScreen(AgendaAdminState state) {
       // mediator.setAgendaAdminState(state);
    }

    @Override
    public AgendaAdminState getDataFromPreviousScreen() {
       // AgendaAdminState state = mediator.getAgendaAdminState();
      //  return state;
        return null;
    }

    //Navegar entre pantallas
    @Override
    public void navigateToAgregarCitaScreen(){
        Context context = mediator.getApplicationContext();
        Intent intent = new Intent(context, AgregarCitaActivity.class);
        context.startActivity(intent);
    }
}
