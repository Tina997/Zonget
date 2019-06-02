package es.ulpgc.montesdeoca110.cristina.zonget.userPets;

import android.content.Intent;
import android.content.Context;

import es.ulpgc.montesdeoca110.cristina.zonget.app.AccountItem;
import es.ulpgc.montesdeoca110.cristina.zonget.app.AppMediator;
import es.ulpgc.montesdeoca110.cristina.zonget.app.UserPetItem;
import es.ulpgc.montesdeoca110.cristina.zonget.userButtonsMenuList.UserButtonsMenuListActivity;
import es.ulpgc.montesdeoca110.cristina.zonget.userPetsDetail.UserPetsDetailActivity;

public class UserPetsRouter implements UserPetsContract.Router {

  public static String TAG = UserPetsRouter.class.getSimpleName();

  private final AppMediator mediator;

  public UserPetsRouter(AppMediator mediator) {
    this.mediator = mediator;
  }

  @Override
  public void navigateToPetsDetailScreen() {
    Context context = mediator.getApplicationContext();
    Intent intent = new Intent(context, UserPetsDetailActivity.class);
    intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
    context.startActivity(intent);
  }

  @Override
  public void passDataToPetsDetailScreen(UserPetItem item) {
    mediator.setUserPetsState(item);
  }

  @Override
  public UserPetsState getDataFromPreviousScreen() {
    return mediator.getUserPetsState();
  }

  @Override
  public String getActualThemeName() {
    return mediator.getactualThemeName();
  }

  @Override
  public void onBackButtonPressed() {
    Context context = mediator.getApplicationContext();
    Intent intent = new Intent(context, UserButtonsMenuListActivity.class);
    intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
    context.startActivity(intent);
  }

  @Override
  public AccountItem getDataFromSignIn() {
    return mediator.getSignInToMenuState().account;
  }
}
