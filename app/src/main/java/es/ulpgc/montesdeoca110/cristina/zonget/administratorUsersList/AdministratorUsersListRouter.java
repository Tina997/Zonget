package es.ulpgc.montesdeoca110.cristina.zonget.administratorUsersList;

import android.util.Log;
import android.content.Intent;
import android.content.Context;

public class AdministratorUsersListRouter implements AdministratorUsersListContract.Router {

    public static String TAG = AdministratorUsersListRouter.class.getSimpleName();

    private AppMediator mediator;

    public AdministratorUsersListRouter(AppMediator mediator) {
        this.mediator = mediator;
    }

    @Override
    public void navigateToNextScreen() {
        Context context = mediator.getApplicationContext();
        Intent intent = new Intent(context, AdministratorUsersListActivity.class);
        context.startActivity(intent);
    }

    @Override
    public void passDataToNextScreen(AdministratorUsersListState state) {
        mediator.setAdministratorUsersListState(state);
    }

    @Override
    public AdministratorUsersListState getDataFromPreviousScreen() {
        AdministratorUsersListState state = mediator.getAdministratorUsersListState();
        return state;
    }
}
