package es.ulpgc.montesdeoca110.cristina.zonget.administratorSearchUsers;

import android.content.Intent;
import android.content.Context;

import es.ulpgc.montesdeoca110.cristina.zonget.administratorButtonsMenuList.AdministratorButtonsMenuListActivity;
import es.ulpgc.montesdeoca110.cristina.zonget.administratorUsersList.AdministratorUsersListActivity;
import es.ulpgc.montesdeoca110.cristina.zonget.app.AppMediator;
import es.ulpgc.montesdeoca110.cristina.zonget.app.statesBetweenActivities.SearchToListUserState;

public class AdministratorSearchUsersRouter implements AdministratorSearchUsersContract.Router {

    public static String TAG = AdministratorSearchUsersRouter.class.getSimpleName();

    private final AppMediator mediator;

    public AdministratorSearchUsersRouter(AppMediator mediator) {
        this.mediator = mediator;
    }

    @Override
    public void navigateToNextScreen() {
        Context context = mediator.getApplicationContext();
        Intent intent = new Intent(context, AdministratorUsersListActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        context.startActivity(intent);
    }
    //Envio de informacion a la siguiente vista
    @Override
    public void passDataToNextScreen(SearchToListUserState state) {
        mediator.setSearchToListUserState(state);
    }
    //TODO metodo a limpiar
    /*@Override
    public AdministratorSearchUsersState getDataFromPreviousScreen() {
        AdministratorSearchUsersState state = mediator.getadminSearchUsersState();
        return state;
    }*/

    @Override
    public String getActualThemeName() {
        return mediator.getactualThemeName();
    }

    @Override
    public void onBackButtonPressed() {
        Context context = mediator.getApplicationContext();
        Intent intent = new Intent(context, AdministratorButtonsMenuListActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        context.startActivity(intent);
    }
}
