package es.ulpgc.montesdeoca110.cristina.zonget.petsForAdoption;

import android.util.Log;
import android.content.Intent;
import android.content.Context;

import es.ulpgc.montesdeoca110.cristina.zonget.app.AppMediator;

public class PetsForAdoptionRouter implements PetsForAdoptionContract.Router {

    public static String TAG = PetsForAdoptionRouter.class.getSimpleName();

    private AppMediator mediator;

    public PetsForAdoptionRouter(AppMediator mediator) {
        this.mediator = mediator;
    }

    @Override
    public void navigateToNextScreen() {
        Context context = mediator.getApplicationContext();
        Intent intent = new Intent(context, PetsForAdoptionActivity.class);
        context.startActivity(intent);
    }

    @Override
    public void passDataToNextScreen(PetsForAdoptionState state) {
        mediator.setPetsForAdoptionState(state);
    }

    @Override
    public PetsForAdoptionState getDataFromPreviousScreen() {
        PetsForAdoptionState state = mediator.getPetsForAdoptionState();
        return state;
    }
}
