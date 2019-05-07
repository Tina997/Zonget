package es.ulpgc.montesdeoca110.cristina.zonget.administratorUsersList;

import android.util.Log;
import android.content.Intent;
import android.content.Context;

import es.ulpgc.montesdeoca110.cristina.zonget.administratorSearchUsers.AdministratorSearchUsersActivity;
import es.ulpgc.montesdeoca110.cristina.zonget.administratorUsersPets.AdministratorUsersPetsListActivity;
import es.ulpgc.montesdeoca110.cristina.zonget.administratorUsersPets.AdministratorUsersPetsListState;
import es.ulpgc.montesdeoca110.cristina.zonget.app.AccountItem;
import es.ulpgc.montesdeoca110.cristina.zonget.app.AppMediator;
import es.ulpgc.montesdeoca110.cristina.zonget.app.UserItem;
import es.ulpgc.montesdeoca110.cristina.zonget.app.statesBetweenActivities.SearchToListUserState;

public class AdministratorUsersListRouter implements AdministratorUsersListContract.Router {

    public static String TAG = AdministratorUsersListRouter.class.getSimpleName();

    private AppMediator mediator;

    public AdministratorUsersListRouter(AppMediator mediator) {
        this.mediator = mediator;
    }


    @Override
    public AdministratorUsersListState getDataFromPreviousScreen() {
        AdministratorUsersListState state = mediator.getAdministratorUsersListState();
        return state;
    }

    @Override
    public void passDataToUserDetailScreen(AccountItem item) {
        AdministratorUsersPetsListState state = new AdministratorUsersPetsListState();
        state.user = item;
        mediator.setAdministratorUsersPetsListState(state);
    }

    @Override
    public void navigateToUserDetailScreen() {
        Context context = mediator.getApplicationContext();
        Intent intent = new Intent(context, AdministratorUsersPetsListActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        context.startActivity(intent);
    }

    @Override
    public String getActualThemeName() {
        return mediator.getactualThemeName();
    }

    @Override
    public void onBackButtonPressed() {
        Context context = mediator.getApplicationContext();
        Intent intent = new Intent(context, AdministratorSearchUsersActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        context.startActivity(intent);
    }

    @Override
    public SearchToListUserState getSearchToListUserState() {
        SearchToListUserState state = mediator.getUserToListUserState();
        return state;
    }
}
