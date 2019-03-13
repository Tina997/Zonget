package es.ulpgc.montesdeoca110.cristina.zonget;

import android.app.Application;

import es.ulpgc.montesdeoca110.cristina.zonget.SignIn.SignInState;
import es.ulpgc.montesdeoca110.cristina.zonget.SignUp.SignUpState;

public class AppMediator extends Application {

    //JUJUJU
    //Funciona maldito
    //Estados de las distintas activities de la aplicación
    private SignInState signInState;

    private SignUpState signUpState;

    @Override
    public void onCreate() {
        super.onCreate();

        signInState = new SignInState();
    }

    public SignInState getSignInState() {
        return signInState;
    }

    public void setSignInState(SignInState signInState) {
        this.signInState = signInState;
    }

    public SignUpState getSignUpState() {
        return signUpState;
    }

    public void setSignUpState(SignUpState signUpState) {
        this.signUpState = signUpState;
    }
}
