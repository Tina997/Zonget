package es.ulpgc.montesdeoca110.cristina.zonget.administratorUsersPets;

import android.util.Log;
import android.content.Intent;
import android.content.Context;

import es.ulpgc.montesdeoca110.cristina.zonget.app.AppMediator;
import es.ulpgc.montesdeoca110.cristina.zonget.app.PetsItem;

public class AdministratorUsersPetsListRouter implements AdministratorUsersPetsListContract.Router {

    public static String TAG = AdministratorUsersPetsListRouter.class.getSimpleName();

    private AppMediator mediator;

    public AdministratorUsersPetsListRouter(AppMediator mediator) {
        this.mediator = mediator;
    }

    @Override
    public void navigateToPetsDetailScreen() {
        Context context = mediator.getApplicationContext();
        Intent intent = new Intent(context, AdministratorUsersPetsListActivity.class);
        context.startActivity(intent);
    }

    @Override
    public void passDataToPetsDetailScreen(PetsItem item) {
        mediator.setUserPetsState(item);
    }

    @Override
    public AdministratorUsersPetsListState getDataFromPreviousScreen() {
        AdministratorUsersPetsListState state = mediator.getAdministratorUsersPetsListState();
        return state;
    }
}
