package es.ulpgc.montesdeoca110.cristina.zonget.userAgenda;

import android.content.Intent;
import android.content.Context;

import es.ulpgc.montesdeoca110.cristina.zonget.app.AppMediator;

public class UserAgendaRouter implements UserAgendaContract.Router {

    public static String TAG = UserAgendaRouter.class.getSimpleName();

    private AppMediator mediator;

    public UserAgendaRouter(AppMediator mediator) {
        this.mediator = mediator;
    }

    @Override
    public void navigateToNextScreen() {
        Context context = mediator.getApplicationContext();
        Intent intent = new Intent(context, UserAgendaActivity.class);
        context.startActivity(intent);
    }

    @Override
    public void passDataToNextScreen(UserAgendaState state) {
        mediator.setUserAgendaState(state);
    }

    @Override
    public UserAgendaState getDataFromPreviousScreen() {
        UserAgendaState state = mediator.getUserAgendaState();
        return state;
    }

    @Override
    public String getActualThemeName() {
        return mediator.getactualThemeName();
    }
}
