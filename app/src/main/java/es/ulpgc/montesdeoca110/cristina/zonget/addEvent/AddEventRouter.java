package es.ulpgc.montesdeoca110.cristina.zonget.addEvent;

import android.content.Intent;
import android.content.Context;

import es.ulpgc.montesdeoca110.cristina.zonget.app.AppMediator;
import es.ulpgc.montesdeoca110.cristina.zonget.agendaAdmin.AgendaAdminActivity;

public class AddEventRouter implements AddEventContract.Router {

    public static String TAG = AddEventRouter.class.getSimpleName();

    private AppMediator mediator;

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
        AddEventState state = mediator.getAddEventState();
        return state;
    }

    @Override
    public void navigateToAgendaAdminScreen(){
        Context context = mediator.getApplicationContext();
        Intent intent = new Intent(context, AgendaAdminActivity.class);
        context.startActivity(intent);
    }
}
