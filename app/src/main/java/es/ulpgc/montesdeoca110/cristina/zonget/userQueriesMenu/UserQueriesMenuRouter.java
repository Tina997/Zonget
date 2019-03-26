package es.ulpgc.montesdeoca110.cristina.zonget.userQueriesMenu;

import android.content.Intent;
import android.content.Context;

import es.ulpgc.montesdeoca110.cristina.zonget.app.AppMediator;

public class UserQueriesMenuRouter implements UserQueriesMenuContract.Router {

    public static String TAG = UserQueriesMenuRouter.class.getSimpleName();

    private AppMediator mediator;

    public UserQueriesMenuRouter(AppMediator mediator) {
        this.mediator = mediator;
    }

    @Override
    public void navigateToNextScreen() {
        Context context = mediator.getApplicationContext();
        Intent intent = new Intent(context, UserQueriesMenuActivity.class);
        context.startActivity(intent);
    }

    @Override
    public void passDataToNextScreen(UserQueriesMenuState state) {
        mediator.setUserQueriesMenuState(state);
    }

    @Override
    public UserQueriesMenuState getDataFromPreviousScreen() {
        UserQueriesMenuState state = mediator.getUserQueriesMenuState();
        return state;
    }
}
