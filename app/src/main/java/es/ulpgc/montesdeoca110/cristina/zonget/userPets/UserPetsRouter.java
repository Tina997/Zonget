package es.ulpgc.montesdeoca110.cristina.zonget.userPets;

import android.content.Intent;
import android.content.Context;

import es.ulpgc.montesdeoca110.cristina.zonget.app.AppMediator;
import es.ulpgc.montesdeoca110.cristina.zonget.app.PetsItem;
import es.ulpgc.montesdeoca110.cristina.zonget.userButtonsMenuList.UserButtonsMenuListActivity;
import es.ulpgc.montesdeoca110.cristina.zonget.userPetsDetail.UserPetsDetailActivity;

public class UserPetsRouter implements UserPetsContract.Router {

    public static String TAG = UserPetsRouter.class.getSimpleName();

    private AppMediator mediator;

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
    public void passDataToPetsDetailScreen(PetsItem item) {
        mediator.setUserPetsState(item);
    }

    @Override
    public UserPetsState getDataFromPreviousScreen() {
        UserPetsState state = mediator.getUserPetsState();
        return state;
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
}
