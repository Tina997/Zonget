package es.ulpgc.montesdeoca110.cristina.zonget.addLostPet;

import android.util.Log;
import android.content.Intent;
import android.content.Context;

import es.ulpgc.montesdeoca110.cristina.zonget.app.AppMediator;

public class AddLostPetRouter implements AddLostPetContract.Router {

    public static String TAG = AddLostPetRouter.class.getSimpleName();

    private AppMediator mediator;

    public AddLostPetRouter(AppMediator mediator) {
        this.mediator = mediator;
    }

    @Override
    public void navigateToNextScreen() {
        Context context = mediator.getApplicationContext();
        Intent intent = new Intent(context, AddLostPetActivity.class);
        context.startActivity(intent);
    }

    @Override
    public void passDataToNextScreen(AddLostPetState state) {
        //mediator.setAddLostPetState(state);
    }

    @Override
    public AddLostPetState getDataFromPreviousScreen() {
        /*AddLostPetState state = mediator.getAddLostPetState();
        return state;*/
        return null;
    }
}
