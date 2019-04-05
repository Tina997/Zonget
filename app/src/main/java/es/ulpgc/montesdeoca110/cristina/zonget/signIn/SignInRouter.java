package es.ulpgc.montesdeoca110.cristina.zonget.signIn;

import android.content.Intent;
import android.content.Context;
import android.util.Log;

import es.ulpgc.montesdeoca110.cristina.zonget.administratorButtonsMenuList.AdministratorButtonsMenuListActivity;
import es.ulpgc.montesdeoca110.cristina.zonget.app.AppMediator;
import es.ulpgc.montesdeoca110.cristina.zonget.app.SignInToMenuState;
import es.ulpgc.montesdeoca110.cristina.zonget.app.UserButtonMenuItem;
import es.ulpgc.montesdeoca110.cristina.zonget.signUp.SignUpActivity;
import es.ulpgc.montesdeoca110.cristina.zonget.userButtonsMenuList.UserButtonsMenuListActivity;
import es.ulpgc.montesdeoca110.cristina.zonget.userPickDate.UserPickDateActivity;

public class SignInRouter implements SignInContract.Router {

    private AppMediator mediator;

    public SignInRouter(AppMediator mediator) {
        this.mediator = mediator;
    }

    @Override
    public SignInState getDataFromSplashActivityScreen() {
        SignInState state = mediator.getSignInState();
        return state;
    }

    // To MenuActivity

    @Override
    public void passDataToMenuScreen(SignInToMenuState state) {
        mediator.setSignInToMenuState(state);
    }

    @Override
    public void navigateToMenuScreen() {
        Context context = mediator.getApplicationContext();
        Intent intent;
        intent = new Intent(context, UserButtonsMenuListActivity.class);
        if (mediator.getSignInToMenuState().account.getType().equals("administrator")){
            intent = new Intent(context, AdministratorButtonsMenuListActivity.class);
        }
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        context.startActivity(intent);
    }

    //To SignUpActivity

    @Override
    public void navigateToSignUpScreen() {
        Context context = mediator.getApplicationContext();
        Intent intent = new Intent(context, SignUpActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        context.startActivity(intent);
    }

    //To UserPickDateActivity

    @Override
    public void navigateToUserPickDateScreen() {
        Context context = mediator.getApplicationContext();
        Intent intent = new Intent(context, UserPickDateActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        context.startActivity(intent);
    }

}
