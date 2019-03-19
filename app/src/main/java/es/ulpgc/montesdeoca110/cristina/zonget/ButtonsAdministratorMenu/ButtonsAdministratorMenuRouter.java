package es.ulpgc.montesdeoca110.cristina.zonget.ButtonsAdministratorMenu;

import android.content.Intent;
import android.content.Context;

import es.ulpgc.montesdeoca110.cristina.zonget.App.AppMediator;

public class ButtonsAdministratorMenuRouter implements ButtonsAdministratorMenuContract.Router {

    public static String TAG = ButtonsAdministratorMenuRouter.class.getSimpleName();

    private AppMediator mediator;

    public ButtonsAdministratorMenuRouter(AppMediator mediator) {
        this.mediator = mediator;
    }

    @Override
    public void navigateToNextScreen() {
        Context context = mediator.getApplicationContext();
        Intent intent = new Intent(context, ButtonsAdministratorMenuActivity.class);
        context.startActivity(intent);
    }

    @Override
    public void passDataToNextScreen(ButtonsAdministratorMenuState state) {
        mediator.setAdministratorMenuState(state);
    }

    @Override
    public ButtonsAdministratorMenuState getDataFromPreviousScreen() {
        ButtonsAdministratorMenuState state = mediator.getAdministratorMenuState();
        return state;
    }
}
