package es.ulpgc.montesdeoca110.cristina.zonget.administratorUsersAddPet;

import android.util.Log;
import android.content.Intent;
import android.content.Context;

import es.ulpgc.montesdeoca110.cristina.zonget.administratorUsersPetDetail.AdministratorUserPetsDetailActivity;
import es.ulpgc.montesdeoca110.cristina.zonget.administratorUsersPets.AdministratorUsersPetsListActivity;
import es.ulpgc.montesdeoca110.cristina.zonget.app.AppMediator;

public class AdministratorUsersAddPetRouter implements AdministratorUsersAddPetContract.Router {

    public static String TAG = AdministratorUsersAddPetRouter.class.getSimpleName();

    private AppMediator mediator;

    public AdministratorUsersAddPetRouter(AppMediator mediator) {
        this.mediator = mediator;
    }

    @Override
    public void navigateToNextScreen() {
        Context context = mediator.getApplicationContext();
        Intent intent = new Intent(context, AdministratorUsersPetsListActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        context.startActivity(intent);
    }

    @Override
    public void passDataToNextScreen(AdministratorUsersAddPetState state) {
        mediator.setAdministratorUsersAddPetState(state);
    }

    @Override
    public AdministratorUsersAddPetState getDataFromPreviousScreen() {
        AdministratorUsersAddPetState state = mediator.getAdministratorUsersAddPetState();
        return state;
    }

    @Override
    public String getActualThemeName() {
        return mediator.getactualThemeName();
    }

    @Override
    public void onBackButtonPressed() {
        Context context = mediator.getApplicationContext();
        Intent intent = new Intent(context, AdministratorUserPetsDetailActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        context.startActivity(intent);
    }
}
