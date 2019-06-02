package es.ulpgc.montesdeoca110.cristina.zonget.addLostPet;

import android.content.Context;
import android.content.Intent;

import es.ulpgc.montesdeoca110.cristina.zonget.app.AppMediator;
import es.ulpgc.montesdeoca110.cristina.zonget.lostPets.LostPetsListActivity;

public class AddLostPetRouter implements AddLostPetContract.Router {

  public static String TAG = AddLostPetRouter.class.getSimpleName();

  private final AppMediator mediator;

  public AddLostPetRouter(AppMediator mediator) {
    this.mediator = mediator;
  }


  @Override
  public AddLostPetState getDataFromPreviousScreen() {
    return mediator.getAddLostPetState();

  }

  @Override
  public String getActualThemeName() {
    return mediator.getactualThemeName();
  }

  @Override
  public void onBackButtonPressed() {
    Context context = mediator.getApplicationContext();
    Intent intent = new Intent(context, LostPetsListActivity.class);
    intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
    context.startActivity(intent);
  }
}
