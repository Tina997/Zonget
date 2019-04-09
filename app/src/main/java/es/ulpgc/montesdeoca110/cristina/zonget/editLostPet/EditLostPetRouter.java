package es.ulpgc.montesdeoca110.cristina.zonget.editLostPet;

import android.util.Log;
import android.content.Intent;
import android.content.Context;

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
        mediator.setEditLostPetState(state);
    }

    @Override
    public EditLostPetState getDataFromPreviousScreen() {
        EditLostPetState state = mediator.getEditLostPetState();
        return state;
    }
}
