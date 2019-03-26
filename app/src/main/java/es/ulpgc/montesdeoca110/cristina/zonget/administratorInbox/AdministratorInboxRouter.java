package es.ulpgc.montesdeoca110.cristina.zonget.administratorInbox;

import android.util.Log;
import android.content.Intent;
import android.content.Context;

import es.ulpgc.montesdeoca110.cristina.zonget.administratorQueryDetail.AdministratorQueryDetailActivity;
import es.ulpgc.montesdeoca110.cristina.zonget.app.AppMediator;

public class AdministratorInboxRouter implements AdministratorInboxContract.Router {

    public static String TAG = AdministratorInboxRouter.class.getSimpleName();

    private AppMediator mediator;

    public AdministratorInboxRouter(AppMediator mediator) {
        this.mediator = mediator;
    }

    @Override
    public void navigateToNextScreen() {
        Context context = mediator.getApplicationContext();
        Intent intent = new Intent(context, AdministratorInboxActivity.class);
        context.startActivity(intent);
    }

    @Override
    public void passDataToNextScreen(AdministratorInboxState state) {
        mediator.setAdministratorInboxState(state);
    }

    @Override
    public AdministratorInboxState getDataFromPreviousScreen() {
        AdministratorInboxState state = mediator.getAdministratorInboxState();
        return state;
    }

    @Override
    public void navigateToAdministratorQueryDetailScreen(){
        Context context = mediator.getApplicationContext();
        Intent intent = new Intent(context, AdministratorQueryDetailActivity.class);
        context.startActivity(intent);
    }
}
