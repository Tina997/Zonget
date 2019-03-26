package es.ulpgc.montesdeoca110.cristina.zonget.userNewQuery;

import android.content.Intent;
import android.content.Context;

import es.ulpgc.montesdeoca110.cristina.zonget.app.AppMediator;

public class UserNewQueryRouter implements UserNewQueryContract.Router {

    public static String TAG = UserNewQueryRouter.class.getSimpleName();

    private AppMediator mediator;

    public UserNewQueryRouter(AppMediator mediator) {
        this.mediator = mediator;
    }

    @Override
    public void navigateToNextScreen() {
        Context context = mediator.getApplicationContext();
        Intent intent = new Intent(context, UserNewQueryActivity.class);
        context.startActivity(intent);
    }

    @Override
    public void passDataToNextScreen(UserNewQueryState state) {
        mediator.setUserNewQueryState(state);
    }

    @Override
    public UserNewQueryState getDataFromPreviousScreen() {
        UserNewQueryState state = mediator.getUserNewQueryState();
        return state;
    }
}
