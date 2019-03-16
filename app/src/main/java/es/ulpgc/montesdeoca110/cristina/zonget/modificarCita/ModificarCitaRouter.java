package es.ulpgc.montesdeoca110.cristina.zonget.modificarCita;

import android.util.Log;
import android.content.Intent;
import android.content.Context;

import es.ulpgc.montesdeoca110.cristina.zonget.App.AppMediator;
import es.ulpgc.montesdeoca110.cristina.zonget.agendaAdmin.AgendaAdminActivity;

public class ModificarCitaRouter implements ModificarCitaContract.Router {

    public static String TAG = ModificarCitaRouter.class.getSimpleName();

    private AppMediator mediator;

    public ModificarCitaRouter(AppMediator mediator) {
        this.mediator = mediator;
    }

    @Override
    public void navigateToNextScreen() {
        Context context = mediator.getApplicationContext();
        Intent intent = new Intent(context, ModificarCitaActivity.class);
        context.startActivity(intent);
    }

    @Override
    public void passDataToNextScreen(ModificarCitaState state) {
        mediator.setModificarCitaState(state);
    }

    @Override
    public ModificarCitaState getDataFromPreviousScreen() {
        ModificarCitaState state = mediator.getModificarCitaState();
        return state;
    }

    @Override
    public void navigateToAgendaAdminScreen(){
        Context context = mediator.getApplicationContext();
        Intent intent = new Intent(context, AgendaAdminActivity.class);
        context.startActivity(intent);
    }
}
