package es.ulpgc.montesdeoca110.cristina.zonget.userButtonsMenuList;

import android.content.Intent;
import android.content.Context;

import es.ulpgc.montesdeoca110.cristina.zonget.app.AppMediator;
import es.ulpgc.montesdeoca110.cristina.zonget.signIn.SignInActivity;

public class UserButtonsMenuListRouter implements UserButtonsMenuListContract.Router {

    public static String TAG = UserButtonsMenuListRouter.class.getSimpleName();

    private AppMediator mediator;

    public UserButtonsMenuListRouter(AppMediator mediator) {
        this.mediator = mediator;
    }

    @Override
    public void navigateToSignInScreen() {
        Context context = mediator.getApplicationContext();
        Intent intent = new Intent(context, SignInActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        context.startActivity(intent);
    }

    @Override
    public void navigateToNextActivityScreen(String activityClassName) {
        Context context = mediator.getApplicationContext();
        Class activity = null;
        try {
            activity = Class.forName(activityClassName);
        } catch (ClassNotFoundException e) {}
        Intent intent = new Intent(context, activity);
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
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
