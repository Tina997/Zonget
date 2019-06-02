package es.ulpgc.montesdeoca110.cristina.zonget.petsForAdoptionDetail;

import android.content.Context;
import android.content.Intent;

import es.ulpgc.montesdeoca110.cristina.zonget.app.AppMediator;
import es.ulpgc.montesdeoca110.cristina.zonget.app.PetForAdoptionItem;
import es.ulpgc.montesdeoca110.cristina.zonget.editPetForAdoption.EditPetForAdoptionActivity;
import es.ulpgc.montesdeoca110.cristina.zonget.petsForAdoption.PetsForAdoptionActivity;

public class PetsForAdoptionDetailRouter implements PetsForAdoptionDetailContract.Router {

  public static String TAG = PetsForAdoptionDetailRouter.class.getSimpleName();

  private final AppMediator mediator;

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
  public PetForAdoptionItem getDataFromPreviousScreen() {
    return mediator.getPetForAdoptionItem();
  }

  @Override
  public String getActualThemeName() {
    return mediator.getactualThemeName();
  }

  @Override
  public void onBackButtonClicked() {
    Context context = mediator.getApplicationContext();
    Intent intent = new Intent(context, PetsForAdoptionActivity.class);
    intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
    context.startActivity(intent);
  }

  @Override
  public void navigateToEditPetForAdoptionScreen() {
    Context context = mediator.getApplicationContext();
    Intent intent = new Intent(context, EditPetForAdoptionActivity.class);
    intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
    context.startActivity(intent);
  }
}
