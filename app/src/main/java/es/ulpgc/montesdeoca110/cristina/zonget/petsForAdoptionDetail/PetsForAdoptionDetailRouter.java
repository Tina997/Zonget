package es.ulpgc.montesdeoca110.cristina.zonget.petsForAdoptionDetail;

import android.util.Log;
import android.content.Intent;
import android.content.Context;

import es.ulpgc.montesdeoca110.cristina.zonget.app.AppMediator;

public class PetsForAdoptionDetailRouter implements PetsForAdoptionDetailContract.Router {

    public static String TAG = PetsForAdoptionDetailRouter.class.getSimpleName();

    private AppMediator mediator;

    public PetsForAdoptionDetailRouter(AppMediator mediator) {
        this.mediator = mediator;
    }

    @Override
    public void navigateToNextScreen() {
        Context context = mediator.getApplicationContext();
        Intent intent = new Intent(context, PetsForAdoptionDetailActivity.class);
        context.startActivity(intent);
    }

    @Override
    public void passDataToNextScreen(PetsForAdoptionDetailState state) {
        mediator.setPetsForAdoptionDetailState(state);
    }

    @Override
    public PetsForAdoptionDetailState getDataFromPreviousScreen() {
        PetsForAdoptionDetailState state = mediator.getPetsForAdoptionDetailState();
        return state;
    }
}
