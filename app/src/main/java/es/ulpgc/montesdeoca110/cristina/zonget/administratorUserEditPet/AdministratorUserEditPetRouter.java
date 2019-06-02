package es.ulpgc.montesdeoca110.cristina.zonget.administratorUserEditPet;

import android.content.Context;
import android.content.Intent;
import es.ulpgc.montesdeoca110.cristina.zonget.administratorUsersPetDetail.AdministratorUserPetsDetailActivity;
import es.ulpgc.montesdeoca110.cristina.zonget.administratorUsersPets.AdministratorUsersPetsListActivity;
import es.ulpgc.montesdeoca110.cristina.zonget.app.AppMediator;
import es.ulpgc.montesdeoca110.cristina.zonget.app.UserPetItem;

public class AdministratorUserEditPetRouter implements AdministratorUserEditPetContract.Router {

  public static String TAG = AdministratorUserEditPetRouter.class.getSimpleName();

  private final AppMediator mediator;

  public AdministratorUserEditPetRouter(AppMediator mediator) {
    this.mediator = mediator;
  }

  @Override
  public void navigateToNextScreen() {
    Context context = mediator.getApplicationContext();
    Intent intent = new Intent(context, AdministratorUsersPetsListActivity.class);
    intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
    context.startActivity(intent);
  }

  @Override
  public void passDataToNextScreen(AdministratorUserEditPetState state) {
    mediator.setAdministratorUserEditPetState(state);
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
  public void onBackButtonPressed() {
    Context context = mediator.getApplicationContext();
    Intent intent = new Intent(context, AdministratorUserPetsDetailActivity.class);
    intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
    context.startActivity(intent);
  }
}
