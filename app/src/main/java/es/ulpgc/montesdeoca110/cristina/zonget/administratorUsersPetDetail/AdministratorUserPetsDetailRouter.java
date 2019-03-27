package es.ulpgc.montesdeoca110.cristina.zonget.administratorUsersPetDetail;

import android.util.Log;
import android.content.Intent;
import android.content.Context;

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
}
