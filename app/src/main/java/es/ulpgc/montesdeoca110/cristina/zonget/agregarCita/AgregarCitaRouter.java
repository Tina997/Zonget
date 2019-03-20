package es.ulpgc.montesdeoca110.cristina.zonget.agregarCita;

import android.content.Intent;
import android.content.Context;

import es.ulpgc.montesdeoca110.cristina.zonget.app.AppMediator;
import es.ulpgc.montesdeoca110.cristina.zonget.agendaAdmin.AgendaAdminActivity;

public class AgregarCitaRouter implements AgregarCitaContract.Router {

    public static String TAG = AgregarCitaRouter.class.getSimpleName();

    private AppMediator mediator;

    public AgregarCitaRouter(AppMediator mediator) {
        this.mediator = mediator;
    }

    @Override
    public void navigateToNextScreen() {
        Context context = mediator.getApplicationContext();
        Intent intent = new Intent(context, AgregarCitaActivity.class);
        context.startActivity(intent);
    }

    @Override
    public void passDataToNextScreen(AgregarCitaState state) {
        mediator.setAgregarCitaState(state);
    }

    @Override
    public AgregarCitaState getDataFromPreviousScreen() {
        AgregarCitaState state = mediator.getAgregarCitaState();
        return state;
    }

    @Override
    public void navigateToAgendaAdminScreen(){
        Context context = mediator.getApplicationContext();
        Intent intent = new Intent(context, AgendaAdminActivity.class);
        context.startActivity(intent);
    }
}
