package es.ulpgc.montesdeoca110.cristina.zonget.administratorUsersPets;

import android.content.Intent;
import android.content.Context;

import es.ulpgc.montesdeoca110.cristina.zonget.administratorSearchUsers.AdministratorSearchUsersActivity;
import es.ulpgc.montesdeoca110.cristina.zonget.administratorUsersAddPet.AdministratorUsersAddPetActivity;
import es.ulpgc.montesdeoca110.cristina.zonget.administratorUsersPetDetail.AdministratorUserPetsDetailActivity;
import es.ulpgc.montesdeoca110.cristina.zonget.app.AppMediator;
import es.ulpgc.montesdeoca110.cristina.zonget.app.UserPetItem;

public class AdministratorUsersPetsListRouter implements AdministratorUsersPetsListContract.Router {

  public static String TAG = AdministratorUsersPetsListRouter.class.getSimpleName();

  private final AppMediator mediator;

  public AdministratorUsersPetsListRouter(AppMediator mediator) {
    this.mediator = mediator;
  }

  @Override
  public void navigateToPetsDetailScreen() {
    Context context = mediator.getApplicationContext();
    Intent intent = new Intent(context, AdministratorUserPetsDetailActivity.class);
    intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
    context.startActivity(intent);
  }

  @Override
  public void passDataToPetsDetailScreen(UserPetItem item) {
    mediator.setUserPetsState(item);
  }

  @Override
  public AdministratorUsersPetsListState getDataFromPreviousScreen() {
    return mediator.getAdministratorUsersPetsListState();
  }

  @Override
  public void navigateToAddScreen() {
    Context context = mediator.getApplicationContext();
    Intent intent = new Intent(context, AdministratorUsersAddPetActivity.class);
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
    Intent intent = new Intent(context, AdministratorSearchUsersActivity.class);
    intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
    context.startActivity(intent);
  }
}
