package es.ulpgc.montesdeoca110.cristina.zonget.petsForAdoption;

import android.util.Log;
import android.content.Intent;
import android.content.Context;

import es.ulpgc.montesdeoca110.cristina.zonget.addPetForAdoption.AddPetForAdoptionActivity;
import es.ulpgc.montesdeoca110.cristina.zonget.app.AppMediator;
import es.ulpgc.montesdeoca110.cristina.zonget.app.PetForAdoptionItem;
import es.ulpgc.montesdeoca110.cristina.zonget.petsForAdoptionDetail.PetsForAdoptionDetailActivity;
import es.ulpgc.montesdeoca110.cristina.zonget.userButtonsMenuList.UserButtonsMenuListActivity;

public class PetsForAdoptionRouter implements PetsForAdoptionContract.Router {

    public static String TAG = PetsForAdoptionRouter.class.getSimpleName();

    private AppMediator mediator;

    public PetsForAdoptionRouter(AppMediator mediator) {
        this.mediator = mediator;
    }

    @Override
    public void navigateToNextScreen() {
        Context context = mediator.getApplicationContext();
        Intent intent = new Intent(context, PetsForAdoptionDetailActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        context.startActivity(intent);
    }

    @Override
    public void passDataToDetailScreen(PetForAdoptionItem petForAdoptionItem) {
        mediator.setPetForAdoptionItem(petForAdoptionItem);
    }

    @Override
    public PetsForAdoptionState getDataFromPreviousScreen() {
        PetsForAdoptionState state = mediator.getPetsForAdoptionState();
        return state;
    }

    @Override
    public String getActualThemeName() {
        return mediator.getactualThemeName();
    }

    @Override
    public void onBackButtonPressed() {
        Context context = mediator.getApplicationContext();
        Intent intent = new Intent(context, UserButtonsMenuListActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        context.startActivity(intent);
    }

    @Override
    public void navigateToAddLostPetScreen() {
        Context context = mediator.getApplicationContext();
        Intent intent = new Intent(context, AddPetForAdoptionActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        context.startActivity(intent);
    }
}
