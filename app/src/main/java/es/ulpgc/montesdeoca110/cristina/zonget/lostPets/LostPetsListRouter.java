package es.ulpgc.montesdeoca110.cristina.zonget.lostPets;

import android.content.Intent;
import android.content.Context;

import es.ulpgc.montesdeoca110.cristina.zonget.app.AppMediator;

public class LostPetsListRouter implements LostPetsListContract.Router {

    public static String TAG = LostPetsListRouter.class.getSimpleName();

    private AppMediator mediator;

    public LostPetsListRouter(AppMediator mediator) {
        this.mediator = mediator;
    }

    @Override
    public void navigateToNextScreen() {
        Context context = mediator.getApplicationContext();
        Intent intent = new Intent(context, LostPetsListActivity.class);
        context.startActivity(intent);
    }

    @Override
    public void passDataToNextScreen(LostPetsListState state) {
        mediator.setlostPetsListState(state);
    }

    @Override
    public LostPetsListState getDataFromPreviousScreen() {
        LostPetsListState state = mediator.getlostPetsListState();
        return state;
    }
}
