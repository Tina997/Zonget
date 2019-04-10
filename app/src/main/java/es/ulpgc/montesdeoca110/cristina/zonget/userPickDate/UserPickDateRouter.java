package es.ulpgc.montesdeoca110.cristina.zonget.userPickDate;

import android.util.Log;
import android.content.Intent;
import android.content.Context;

import es.ulpgc.montesdeoca110.cristina.zonget.app.AppMediator;

public class UserPickDateRouter implements UserPickDateContract.Router {

    public static String TAG = UserPickDateRouter.class.getSimpleName();

    private AppMediator mediator;

    public UserPickDateRouter(AppMediator mediator) {
        this.mediator = mediator;
    }

    @Override
    public void navigateToNextScreen() {
        Context context = mediator.getApplicationContext();
        Intent intent = new Intent(context, UserPickDateActivity.class);
        context.startActivity(intent);
    }

    @Override
    public void passDataToNextScreen(UserPickDateState state) {
       // mediator.setUserPickDateState(state);
    }

    @Override
    public UserPickDateState getDataFromPreviousScreen() {
        UserPickDateState state = mediator.getUserPickDateState();
        return state;

    }
}
