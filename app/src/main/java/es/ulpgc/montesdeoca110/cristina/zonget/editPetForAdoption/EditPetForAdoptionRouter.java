package es.ulpgc.montesdeoca110.cristina.zonget.editPetForAdoption;

import android.util.Log;
import android.content.Intent;
import android.content.Context;

import es.ulpgc.montesdeoca110.cristina.zonget.app.AppMediator;

public class EditPetForAdoptionRouter implements EditPetForAdoptionContract.Router {

    public static String TAG = EditPetForAdoptionRouter.class.getSimpleName();

    private AppMediator mediator;

    public EditPetForAdoptionRouter(AppMediator mediator) {
        this.mediator = mediator;
    }

    @Override
    public void navigateToNextScreen() {
        Context context = mediator.getApplicationContext();
        Intent intent = new Intent(context, EditPetForAdoptionActivity.class);
        context.startActivity(intent);
    }

    @Override
    public void passDataToNextScreen(EditPetForAdoptionState state) {
        mediator.setEditPetForAdoptionState(state);
    }

    @Override
    public EditPetForAdoptionState getDataFromPreviousScreen() {
        EditPetForAdoptionState state = mediator.getEditPetForAdoptionState();
        return state;
    }
}
