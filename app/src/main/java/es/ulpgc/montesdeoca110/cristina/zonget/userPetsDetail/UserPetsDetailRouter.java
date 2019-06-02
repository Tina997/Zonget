package es.ulpgc.montesdeoca110.cristina.zonget.userPetsDetail;

import android.content.Intent;
import android.content.Context;

import es.ulpgc.montesdeoca110.cristina.zonget.app.AppMediator;
import es.ulpgc.montesdeoca110.cristina.zonget.app.UserPetItem;
import es.ulpgc.montesdeoca110.cristina.zonget.userPets.UserPetsActivity;

public class UserPetsDetailRouter implements UserPetsDetailContract.Router {

  public static String TAG = UserPetsDetailRouter.class.getSimpleName();

  private final AppMediator mediator;

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
  public UserPetItem getDataFromPreviousScreen() {
    return mediator.getAnimal();
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
