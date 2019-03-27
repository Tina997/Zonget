package es.ulpgc.montesdeoca110.cristina.zonget.signIn;

import android.content.Intent;
import android.content.Context;

import es.ulpgc.montesdeoca110.cristina.zonget.app.AppMediator;
import es.ulpgc.montesdeoca110.cristina.zonget.signUp.SignUpActivity;

public class SignInRouter implements SignInContract.Router {

    public static String TAG = SignInRouter.class.getSimpleName();

    private AppMediator mediator;

    public SignInRouter(AppMediator mediator) {
        this.mediator = mediator;
    }

    @Override
    public void navigateToMenuScreen() {

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
    public void passDataToNextScreen(SignInState state) {
        mediator.setSignInState(state);
    }

    @Override
    public SignInState getDataFromPreviousScreen() {
        SignInState state = mediator.getSignInState();
        return state;
    }

}
