package es.ulpgc.montesdeoca110.cristina.zonget.addPetForAdoption;

import android.content.Context;

import android.content.Intent;

import es.ulpgc.montesdeoca110.cristina.zonget.app.AppMediator;
import es.ulpgc.montesdeoca110.cristina.zonget.petsForAdoption.PetsForAdoptionActivity;

public class AddPetForAdoptionRouter implements AddPetForAdoptionContract.Router {

  public static String TAG = AddPetForAdoptionRouter.class.getSimpleName();

  private final AppMediator mediator;

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
    return mediator.getAddPetForAdoptionState();
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
  public void navigateToPetForAdoptionDetailScreen() {
    Context context = mediator.getApplicationContext();
    Intent intent = new Intent(context, PetsForAdoptionActivity.class);
    intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
    context.startActivity(intent);
  }
}
