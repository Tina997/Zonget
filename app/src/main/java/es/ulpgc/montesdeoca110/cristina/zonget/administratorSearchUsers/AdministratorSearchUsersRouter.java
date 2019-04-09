package es.ulpgc.montesdeoca110.cristina.zonget.administratorSearchUsers;

import android.content.Intent;
import android.content.Context;

import es.ulpgc.montesdeoca110.cristina.zonget.administratorUsersList.AdministratorUsersListActivity;
import es.ulpgc.montesdeoca110.cristina.zonget.app.AppMediator;
import es.ulpgc.montesdeoca110.cristina.zonget.userPets.UserPetsActivity;

public class AdministratorSearchUsersRouter implements AdministratorSearchUsersContract.Router {

    public static String TAG = AdministratorSearchUsersRouter.class.getSimpleName();

    private AppMediator mediator;

    public AdministratorSearchUsersRouter(AppMediator mediator) {
        this.mediator = mediator;
    }

    //Cambio de vista
    @Override
    public void navigateToNextScreen() {
        Context context = mediator.getApplicationContext();
        Intent intent = new Intent(context, AdministratorUsersListActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        context.startActivity(intent);
    }
    //Envio de informacion a la siguiente vista
    @Override
    public void passDataToNextScreen(AdministratorSearchUsersState state) {
        mediator.setadminSearchUsersState(state);
    }
    //TODO metodo a limpiar
    @Override
    public AdministratorSearchUsersState getDataFromPreviousScreen() {
        AdministratorSearchUsersState state = mediator.getadminSearchUsersState();
        return state;
    }
}
