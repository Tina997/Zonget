package es.ulpgc.montesdeoca110.cristina.zonget.userButtonsMenuList;

import android.util.Log;
import android.content.Intent;
import android.content.Context;

import es.ulpgc.montesdeoca110.cristina.zonget.app.AppMediator;

public class UserButtonsMenuListRouter implements UserButtonsMenuListContract.Router {

    public static String TAG = UserButtonsMenuListRouter.class.getSimpleName();

    private AppMediator mediator;

    public UserButtonsMenuListRouter(AppMediator mediator) {
        this.mediator = mediator;
    }

    @Override
    public void navigateToNextScreen() {
        Context context = mediator.getApplicationContext();
        Intent intent = new Intent(context, UserButtonsMenuListActivity.class);
        context.startActivity(intent);
    }

    @Override
    public void passDataToNextScreen(UserButtonsMenuListState state) {
        mediator.setUserButtonsMenuListState(state);
    }

    @Override
    public UserButtonsMenuListState getDataFromPreviousScreen() {
        UserButtonsMenuListState state = mediator.getUserButtonsMenuListState();
        return state;
    }
}
