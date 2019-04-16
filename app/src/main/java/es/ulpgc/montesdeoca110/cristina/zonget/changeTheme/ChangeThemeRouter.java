package es.ulpgc.montesdeoca110.cristina.zonget.changeTheme;

import android.content.Intent;
import android.content.Context;

import es.ulpgc.montesdeoca110.cristina.zonget.app.AppMediator;

public class ChangeThemeRouter implements ChangeThemeContract.Router {

    private AppMediator mediator;

    public ChangeThemeRouter(AppMediator mediator) {
        this.mediator = mediator;
    }

    @Override
    public void navigateToNextScreen() {
        Context context = mediator.getApplicationContext();
        Intent intent = new Intent(context, ChangeThemeActivity.class);
        context.startActivity(intent);
    }

    @Override
    public void passDataToNextScreen(ChangeThemeState state) {
        mediator.setChangeThemeState(state);
    }

    @Override
    public ChangeThemeState getDataFromPreviousScreen() {
        ChangeThemeState state = mediator.getChangeThemeState();
        return state;
    }
}
