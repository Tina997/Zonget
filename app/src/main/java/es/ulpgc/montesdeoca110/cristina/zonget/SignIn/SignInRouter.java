package es.ulpgc.montesdeoca110.cristina.zonget.signIn;

import android.content.Intent;
import android.content.Context;

import es.ulpgc.montesdeoca110.cristina.zonget.app.AppMediator;

public class SignInRouter implements SignInContract.Router {

    public static String TAG = SignInRouter.class.getSimpleName();

    private AppMediator mediator;

    public SignInRouter(AppMediator mediator) {
        this.mediator = mediator;
    }

    @Override
    public void navigateToNextScreen() {
        Context context = mediator.getApplicationContext();
        Intent intent = new Intent(context, SignInActivity.class);
        context.startActivity(intent);
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
