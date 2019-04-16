package es.ulpgc.montesdeoca110.cristina.zonget.changeTheme;

import android.util.Log;
import android.content.Intent;
import android.content.Context;

public class ChangeThemeRouter implements ChangeThemeContract.Router {

    public static String TAG = ChangeThemeRouter.class.getSimpleName();

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
