package es.ulpgc.montesdeoca110.cristina.zonget.userPetsDetail;

import android.content.Context;
import android.content.Intent;

import es.ulpgc.montesdeoca110.cristina.zonget.app.AppMediator;
import es.ulpgc.montesdeoca110.cristina.zonget.app.PetsItem;
import es.ulpgc.montesdeoca110.cristina.zonget.userPets.UserPetsActivity;

public class UserPetsDetailRouter implements UserPetsDetailContract.Router {

  public static String TAG = UserPetsDetailRouter.class.getSimpleName();

  private AppMediator mediator;

  public UserPetsDetailRouter(AppMediator mediator) {
    this.mediator = mediator;
  }

  @Override
  public void navigateToNextScreen() {
    Context context = mediator.getApplicationContext();
    Intent intent = new Intent(context, UserPetsDetailActivity.class);
    context.startActivity(intent);
  }

  @Override
  public void passDataToNextScreen(UserPetsDetailState state) {
    // mediator.setClientPetsDetailState(state);
  }

  @Override
  public PetsItem getDataFromPreviousScreen() {
    PetsItem pet = mediator.getAnimal();
    return pet;
  }

  @Override
  public String getActualThemeName() {
    return mediator.getactualThemeName();
  }

  @Override
  public void onBackButtonClicked() {
    Context context = mediator.getApplicationContext();
    Intent intent = new Intent(context, UserPetsActivity.class);
    intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
    context.startActivity(intent);
  }
}
