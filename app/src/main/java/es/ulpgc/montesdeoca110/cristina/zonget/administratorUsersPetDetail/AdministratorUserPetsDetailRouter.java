package es.ulpgc.montesdeoca110.cristina.zonget.administratorUsersPetDetail;

import android.content.Intent;
import android.content.Context;

import es.ulpgc.montesdeoca110.cristina.zonget.administratorUserEditPet.AdministratorUserEditPetActivity;
import es.ulpgc.montesdeoca110.cristina.zonget.administratorUsersList.AdministratorUsersListActivity;
import es.ulpgc.montesdeoca110.cristina.zonget.administratorUsersPets.AdministratorUsersPetsListActivity;
import es.ulpgc.montesdeoca110.cristina.zonget.app.AppMediator;
import es.ulpgc.montesdeoca110.cristina.zonget.app.UserPetItem;

public class AdministratorUserPetsDetailRouter implements AdministratorUserPetsDetailContract.Router {

    public static String TAG = AdministratorUserPetsDetailRouter.class.getSimpleName();

    private final AppMediator mediator;

    public AdministratorUserPetsDetailRouter(AppMediator mediator) {
        this.mediator = mediator;
    }

    @Override
    public void navigateToNextScreen() {
        Context context = mediator.getApplicationContext();
        Intent intent = new Intent(context, AdministratorUserPetsDetailActivity.class);
        context.startActivity(intent);
    }

    @Override
    public void passDataToNextScreen(AdministratorUserPetsDetailState state) {
        mediator.setAdministratorUserPetsDetailState(state);
    }

    @Override
    public UserPetItem getDataFromPreviousScreen() {
      return mediator.getAnimal();
    }

    @Override
    public void navigateToEditScreen() {
        Context context = mediator.getApplicationContext();
        Intent intent = new Intent(context, AdministratorUserEditPetActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        context.startActivity(intent);
    }

    @Override
    public void navigateToPetListScreen() {
        Context context = mediator.getApplicationContext();
        Intent intent = new Intent(context, AdministratorUsersListActivity.class);
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
        Intent intent = new Intent(context, AdministratorUsersPetsListActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        context.startActivity(intent);
    }

}
