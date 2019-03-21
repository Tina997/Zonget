package es.ulpgc.montesdeoca110.cristina.zonget.userPetsDetail;

import android.content.Intent;
import android.content.Context;

import es.ulpgc.montesdeoca110.cristina.zonget.app.AppMediator;
import es.ulpgc.montesdeoca110.cristina.zonget.app.PetsItem;

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
}
