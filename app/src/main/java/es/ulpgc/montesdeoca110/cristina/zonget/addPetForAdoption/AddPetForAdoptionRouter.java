package es.ulpgc.montesdeoca110.cristina.zonget.addPetForAdoption;

import android.util.Log;
import android.content.Intent;
import android.content.Context;

import es.ulpgc.montesdeoca110.cristina.zonget.app.AppMediator;
import es.ulpgc.montesdeoca110.cristina.zonget.petsForAdoption.PetsForAdoptionActivity;
import es.ulpgc.montesdeoca110.cristina.zonget.petsForAdoptionDetail.PetsForAdoptionDetailActivity;

public class AddPetForAdoptionRouter implements AddPetForAdoptionContract.Router {

    public static String TAG = AddPetForAdoptionRouter.class.getSimpleName();

    private AppMediator mediator;

    public AddPetForAdoptionRouter(AppMediator mediator) {
        this.mediator = mediator;
    }

    @Override
    public void navigateToNextScreen() {
        Context context = mediator.getApplicationContext();
        Intent intent = new Intent(context, AddPetForAdoptionActivity.class);
        context.startActivity(intent);
    }

    @Override
    public void passDataToNextScreen(AddPetForAdoptionState state) {
        mediator.setAddPetForAdoptionState(state);
    }

    @Override
    public AddPetForAdoptionState getDataFromPreviousScreen() {
        AddPetForAdoptionState state = mediator.getAddPetForAdoptionState();
        return state;
    }

    @Override
    public String getActualThemeName() {
        return mediator.getactualThemeName();
    }

    @Override
    public void onBackButtonPressed() {
        Context context = mediator.getApplicationContext();
        Intent intent = new Intent(context, PetsForAdoptionActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        context.startActivity(intent);
    }

    @Override
    public void navigateToPetForAdoptionDetailScreen(){
        Context context = mediator.getApplicationContext();
        Intent intent = new Intent(context, PetsForAdoptionActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        context.startActivity(intent);
    }
}
