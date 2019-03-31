package es.ulpgc.montesdeoca110.cristina.zonget.administratorUsersPetDetail;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.util.Log;
import android.content.Intent;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;

import es.ulpgc.montesdeoca110.cristina.zonget.R;
import es.ulpgc.montesdeoca110.cristina.zonget.administratorUserEditPet.AdministratorUserEditPetActivity;
import es.ulpgc.montesdeoca110.cristina.zonget.administratorUsersPets.AdministratorUsersPetsListActivity;
import es.ulpgc.montesdeoca110.cristina.zonget.app.AppMediator;
import es.ulpgc.montesdeoca110.cristina.zonget.app.PetsItem;

public class AdministratorUserPetsDetailRouter implements AdministratorUserPetsDetailContract.Router {

    public static String TAG = AdministratorUserPetsDetailRouter.class.getSimpleName();

    private AppMediator mediator;

    public AdministratorUserPetsDetailRouter(AppMediator mediator) {
        this.mediator = mediator;
    }

    @Override
    public void navigateToNextScreen() {
        Context context = mediator.getApplicationContext();
        Intent intent = new Intent(context, AdministratorUserPetsDetailActivity.class);
        context.startActivity(intent);
    }

    @Override
    public void passDataToNextScreen(AdministratorUserPetsDetailState state) {
        mediator.setAdministratorUserPetsDetailState(state);
    }

    @Override
    public PetsItem getDataFromPreviousScreen() {
        PetsItem pet = mediator.getAnimal();
        return pet;
    }

    @Override
    public void navigateToEditScreen() {
        Context context = mediator.getApplicationContext();
        Intent intent = new Intent(context, AdministratorUserEditPetActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        context.startActivity(intent);
    }

    @Override
    public void navigateToPetListScreen() {
        Context context = mediator.getApplicationContext();
        Intent intent = new Intent(context, AdministratorUsersPetsListActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        context.startActivity(intent);
    }

}
