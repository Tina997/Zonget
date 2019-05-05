package es.ulpgc.montesdeoca110.cristina.zonget.addLostPet;

import android.content.Context;
import android.content.Intent;

import es.ulpgc.montesdeoca110.cristina.zonget.app.AppMediator;
import es.ulpgc.montesdeoca110.cristina.zonget.lostPetsDetail.LostPetsDetailActivity;

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
    AddLostPetState state = mediator.getAddLostPetState();
    return state;

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
