package es.ulpgc.montesdeoca110.cristina.zonget.editPetForAdoption;

import android.content.Context;
import android.content.Intent;
import es.ulpgc.montesdeoca110.cristina.zonget.app.AppMediator;
import es.ulpgc.montesdeoca110.cristina.zonget.petsForAdoptionDetail.PetsForAdoptionDetailActivity;

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

  @Override
  public String getActualThemeName() {
    return mediator.getactualThemeName();
  }

  @Override
  public void onBackButtonPressed() {
    Context context = mediator.getApplicationContext();
    Intent intent = new Intent(context, PetsForAdoptionDetailActivity.class);
    intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
    context.startActivity(intent);
  }

  @Override
  public void navigateToPetForAdoptionDetailScreen() {
    Context context = mediator.getApplicationContext();
    Intent intent = new Intent(context, PetsForAdoptionDetailActivity.class);
    intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
    context.startActivity(intent);
  }
}
