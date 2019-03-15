package es.ulpgc.montesdeoca110.cristina.zonget.SignUpConfirmation;

import android.util.Log;
import android.content.Intent;
import android.content.Context;

import es.ulpgc.montesdeoca110.cristina.zonget.App.AppMediator;


public class SignUpConfirmationRouter implements SignUpConfirmationContract.Router {

    public static String TAG = SignUpConfirmationRouter.class.getSimpleName();

    private AppMediator mediator;

    public SignUpConfirmationRouter(AppMediator mediator) {
        this.mediator = mediator;
    }

    @Override
    public void navigateToNextScreen() {
        Context context = mediator.getApplicationContext();
        Intent intent = new Intent(context, SignUpConfirmationActivity.class);
        context.startActivity(intent);
    }

    @Override
    public void passDataToNextScreen(SignUpConfirmationState state) {
        mediator.setSignUpConfirmationState(state);
    }

    @Override
    public SignUpConfirmationState getDataFromPreviousScreen() {
        SignUpConfirmationState state = mediator.getSignUpConfirmationState();
        return state;
    }
}
