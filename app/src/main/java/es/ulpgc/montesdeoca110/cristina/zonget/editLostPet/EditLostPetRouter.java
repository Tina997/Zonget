package es.ulpgc.montesdeoca110.cristina.zonget.editLostPet;

import android.util.Log;
import android.content.Intent;
import android.content.Context;

import es.ulpgc.montesdeoca110.cristina.zonget.administratorUsersList.AdministratorUsersListActivity;
import es.ulpgc.montesdeoca110.cristina.zonget.app.AppMediator;
import es.ulpgc.montesdeoca110.cristina.zonget.lostPetsDetail.LostPetsDetailActivity;

public class EditLostPetRouter implements EditLostPetContract.Router {

    public static String TAG = EditLostPetRouter.class.getSimpleName();

    private AppMediator mediator;

    public EditLostPetRouter(AppMediator mediator) {
        this.mediator = mediator;
    }

    @Override
    public void navigateToNextScreen() {
        Context context = mediator.getApplicationContext();
        Intent intent = new Intent(context, EditLostPetActivity.class);
        context.startActivity(intent);
    }

    @Override
    public void passDataToNextScreen(EditLostPetState state) {
        //mediator.setEditLostPetState(state);
    }

    @Override
    public EditLostPetState getDataFromPreviousScreen() {
        EditLostPetState state = mediator.getEditLostPetState();
        return state;

    }

    @Override
    public void navigateToLostPetDetailScreen() {
        Context context = mediator.getApplicationContext();
        Intent intent = new Intent(context, LostPetsDetailActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        context.startActivity(intent);
    }
}
