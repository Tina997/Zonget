package es.ulpgc.montesdeoca110.cristina.zonget.userPendingQueriesList;

import android.content.Intent;
import android.content.Context;

import es.ulpgc.montesdeoca110.cristina.zonget.app.AppMediator;
import es.ulpgc.montesdeoca110.cristina.zonget.userQueriesMenu.UserQueriesMenuActivity;

public class UserPendingQueriesListRouter implements UserPendingQueriesListContract.Router {

    private AppMediator mediator;

    public UserPendingQueriesListRouter(AppMediator mediator) {
        this.mediator = mediator;
    }

    // UserQueriesMenu

    @Override
    public void passDataToUserQueriesMenuScreen() {

    }

    @Override
    public void navigateToUserQueriesMenuScreen() {
        Context context = mediator.getApplicationContext();
        Intent intent = new Intent(context, UserQueriesMenuActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        context.startActivity(intent);
    }

}
