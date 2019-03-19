package es.ulpgc.montesdeoca110.cristina.zonget.AdministratorButtonsMenuList;

import android.content.Intent;
import android.content.Context;

import es.ulpgc.montesdeoca110.cristina.zonget.App.AppMediator;

public class AdministratorButtonsMenuListRouter implements AdministratorMenuButtonsListContract.Router {

    public static String TAG = AdministratorButtonsMenuListRouter.class.getSimpleName();

    private AppMediator mediator;

    public AdministratorButtonsMenuListRouter(AppMediator mediator) {
        this.mediator = mediator;
    }

    @Override
    public void navigateToNextScreen() {
        Context context = mediator.getApplicationContext();
        Intent intent = new Intent(context, AdministratorButtonsMenuListActivity.class);
        context.startActivity(intent);
    }

    @Override
    public void passDataToNextScreen(AdministratorButtonsMenuListState state) {
        mediator.setAdministratorMenuListState(state);
    }

    @Override
    public AdministratorButtonsMenuListState getDataFromPreviousScreen() {
        AdministratorButtonsMenuListState state = mediator.getAdministratorMenuListState();
        return state;
    }
}
