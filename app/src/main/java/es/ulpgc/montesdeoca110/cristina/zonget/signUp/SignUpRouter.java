package es.ulpgc.montesdeoca110.cristina.zonget.signUp;

import android.content.Intent;
import android.content.Context;

import es.ulpgc.montesdeoca110.cristina.zonget.app.AppMediator;
import es.ulpgc.montesdeoca110.cristina.zonget.app.SignUpToSignUpConfirmedState;
import es.ulpgc.montesdeoca110.cristina.zonget.signUpConfirmation.SignUpConfirmationActivity;


public class SignUpRouter implements SignUpContract.Router {

    private AppMediator mediator;

    public SignUpRouter(AppMediator mediator) {
        this.mediator = mediator;
    }

    @Override
    public void setSignUpState(SignUpState state) {

    }


    @Override
    public void navigateSignUpConfirmationScreen() {
        Context context = mediator.getApplicationContext();
        Intent intent = new Intent(context, SignUpConfirmationActivity.class);
        context.startActivity(intent);
    }

    @Override
    public void passDataSignUpConfirmationScreen(SignUpToSignUpConfirmedState state) {

    }
}
