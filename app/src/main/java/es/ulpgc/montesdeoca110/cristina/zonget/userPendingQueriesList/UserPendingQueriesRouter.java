package es.ulpgc.montesdeoca110.cristina.zonget.userPendingQueriesList;

import android.util.Log;
import android.content.Intent;
import android.content.Context;

public class UserPendingQueriesRouter implements UserPendingQueriesContract.Router {

    public static String TAG = UserPendingQueriesRouter.class.getSimpleName();

    private AppMediator mediator;

    public UserPendingQueriesRouter(AppMediator mediator) {
        this.mediator = mediator;
    }

    @Override
    public void navigateToNextScreen() {
        Context context = mediator.getApplicationContext();
        Intent intent = new Intent(context, UserPendingQueriesActivity.class);
        context.startActivity(intent);
    }

    @Override
    public void passDataToNextScreen(UserPendingQueriesState state) {
        mediator.setUserPendingQueriesState(state);
    }

    @Override
    public UserPendingQueriesState getDataFromPreviousScreen() {
        UserPendingQueriesState state = mediator.getUserPendingQueriesState();
        return state;
    }
}
