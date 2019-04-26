package es.ulpgc.montesdeoca110.cristina.zonget.modifyEvent;

import android.content.Intent;
import android.content.Context;

import es.ulpgc.montesdeoca110.cristina.zonget.app.AppMediator;
import es.ulpgc.montesdeoca110.cristina.zonget.administratorAgenda.AdministratorAgendaActivity;

public class ModifyEventRouter implements ModifyEventContract.Router {

    public static String TAG = ModifyEventRouter.class.getSimpleName();

    private AppMediator mediator;

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
        ModifyEventState state = mediator.getModifyEventState();
        return state;
    }

    @Override
    public String getActualThemeName() {
        return mediator.getactualThemeName();
    }

    @Override
    public void navigateToAdministratorAgendaScreen(){
        Context context = mediator.getApplicationContext();
        Intent intent = new Intent(context, AdministratorAgendaActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        context.startActivity(intent);
    }
}
