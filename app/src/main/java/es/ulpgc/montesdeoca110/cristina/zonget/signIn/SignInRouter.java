package es.ulpgc.montesdeoca110.cristina.zonget.signIn;

import android.content.Intent;
import android.content.Context;

import es.ulpgc.montesdeoca110.cristina.zonget.administratorButtonsMenuList.AdministratorButtonsMenuListActivity;
import es.ulpgc.montesdeoca110.cristina.zonget.app.AppMediator;
import es.ulpgc.montesdeoca110.cristina.zonget.app.SignInToMenuState;
import es.ulpgc.montesdeoca110.cristina.zonget.app.UserButtonMenuItem;
import es.ulpgc.montesdeoca110.cristina.zonget.signUp.SignUpActivity;
import es.ulpgc.montesdeoca110.cristina.zonget.userButtonsMenuList.UserButtonsMenuListActivity;

public class SignInRouter implements SignInContract.Router {

    public static String TAG = SignInRouter.class.getSimpleName();

    private AppMediator mediator;

    public SignInRouter(AppMediator mediator) {
        this.mediator = mediator;
    }



    @Override
    public void navigateToMenuScreen() {
        Context context = mediator.getApplicationContext();
        Intent intent;
        if(mediator.getSignInToMenuState().account.getType() == "administrator") {
            intent = new Intent(context, AdministratorButtonsMenuListActivity.class);
        }else{
            intent = new Intent(context, UserButtonsMenuListActivity.class);
        }
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        context.startActivity(intent);
    }

    @Override
    public void navigateToSignUpScreen() {
        Context context = mediator.getApplicationContext();
        Intent intent = new Intent(context, SignUpActivity.class);
        context.startActivity(intent);
    }

    @Override
    public void navigateToPickDateScreen() {

    }

    @Override
    public void passDataToMenuScreen(SignInToMenuState state) {
        mediator.setSignInToMenuState(state);
    }

    @Override
    public SignInState getDataFromPreviousScreen() {
        SignInState state = mediator.getSignInState();
        return state;
    }

}
