package es.ulpgc.montesdeoca110.cristina.zonget.userFinishedQueriesList;

import android.util.Log;
import android.content.Intent;
import android.content.Context;

public class UserFinishedQueriesListRouter implements UserFinishedQueriesListContract.Router {

    public static String TAG = UserFinishedQueriesListRouter.class.getSimpleName();

    private AppMediator mediator;

    public UserFinishedQueriesListRouter(AppMediator mediator) {
        this.mediator = mediator;
    }

    @Override
    public void navigateToNextScreen() {
        Context context = mediator.getApplicationContext();
        Intent intent = new Intent(context, UserFinishedQueriesListActivity.class);
        context.startActivity(intent);
    }

    @Override
    public void passDataToNextScreen(UserFinishedQueriesListState state) {
        mediator.setUserFinishedQueriesListState(state);
    }

    @Override
    public UserFinishedQueriesListState getDataFromPreviousScreen() {
        UserFinishedQueriesListState state = mediator.getUserFinishedQueriesListState();
        return state;
    }
}
