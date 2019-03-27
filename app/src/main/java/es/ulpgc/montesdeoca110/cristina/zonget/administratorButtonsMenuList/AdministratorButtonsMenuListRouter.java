package es.ulpgc.montesdeoca110.cristina.zonget.administratorButtonsMenuList;

import android.content.Intent;
import android.content.Context;

import es.ulpgc.montesdeoca110.cristina.zonget.app.AppMediator;
import es.ulpgc.montesdeoca110.cristina.zonget.signIn.SignInActivity;

public class AdministratorButtonsMenuListRouter implements AdministratorButtonsMenuListContract.Router {

    private AppMediator mediator;

    public AdministratorButtonsMenuListRouter(AppMediator mediator) {
        this.mediator = mediator;
    }

    @Override
    public void navigateToSignInScreen() {
        Context context = mediator.getApplicationContext();
        Intent intent = new Intent(context, SignInActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
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
