package es.ulpgc.montesdeoca110.cristina.zonget.editLostPet;

import android.content.Context;
import android.content.Intent;

import es.ulpgc.montesdeoca110.cristina.zonget.app.AppMediator;
import es.ulpgc.montesdeoca110.cristina.zonget.lostPetsDetail.LostPetsDetailActivity;

public class EditLostPetRouter implements EditLostPetContract.Router {

  public static String TAG = EditLostPetRouter.class.getSimpleName();

  private final AppMediator mediator;

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
    //mediator.setEditLostPetState(state);
  }

  @Override
  public EditLostPetState getDataFromPreviousScreen() {
    return mediator.getEditLostPetState();

  }

  @Override
  public void navigateToLostPetDetailScreen() {
    Context context = mediator.getApplicationContext();
    Intent intent = new Intent(context, LostPetsDetailActivity.class);
    intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
    context.startActivity(intent);
  }

  @Override
  public String getActualThemeName() {
    return mediator.getactualThemeName();
  }

  @Override
  public void onBackButtonPressed() {
    Context context = mediator.getApplicationContext();
    Intent intent = new Intent(context, LostPetsDetailActivity.class);
    intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
    context.startActivity(intent);
  }
}
