package es.ulpgc.montesdeoca110.cristina.zonget.AdministratorMenu;

import android.util.Log;
import android.content.Intent;
import android.content.Context;

import es.ulpgc.montesdeoca110.cristina.zonget.App.AppMediator;

public class AdministratorMenuRouter implements AdministratorMenuContract.Router {

    public static String TAG = AdministratorMenuRouter.class.getSimpleName();

    private AppMediator mediator;

    public AdministratorMenuRouter(AppMediator mediator) {
        this.mediator = mediator;
    }

    @Override
    public void navigateToNextScreen() {
        Context context = mediator.getApplicationContext();
        Intent intent = new Intent(context, AdministratorMenuActivity.class);
        context.startActivity(intent);
    }

    @Override
    public void passDataToNextScreen(AdministratorMenuState state) {
        mediator.setAdministratorMenuState(state);
    }

    @Override
    public AdministratorMenuState getDataFromPreviousScreen() {
        AdministratorMenuState state = mediator.getAdministratorMenuState();
        return state;
    }
}
