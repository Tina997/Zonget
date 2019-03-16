package es.ulpgc.montesdeoca110.cristina.zonget.App;

import android.app.Application;

import es.ulpgc.montesdeoca110.cristina.zonget.AnimalesCliente.AnimalesClienteListState;
import es.ulpgc.montesdeoca110.cristina.zonget.SignIn.SignInState;
import es.ulpgc.montesdeoca110.cristina.zonget.SignUp.SignUpState;
import es.ulpgc.montesdeoca110.cristina.zonget.agregarCita.AgregarCitaState;

public class AppMediator extends Application {

    //Estados de las distintas activities de la aplicación
    private SignInState signInState;

    private SignUpState signUpState;

    private AnimalesClienteListState animalesClienteListState = new AnimalesClienteListState();

    private AgregarCitaState agregarCitaState = new AgregarCitaState();

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

    public void setAnimalesClienteListState(AnimalesClienteListState state) {
        animalesClienteListState = state;
    }

    public AnimalesClienteListState getAnimalesClienteListState() {
        return animalesClienteListState;
    }

    //AgregarCita
    public AgregarCitaState getAgregarCitaState() {
        return agregarCitaState;
    }

    public void setAgregarCitaState(AgregarCitaState agregarCitaState) {
        this.agregarCitaState = agregarCitaState;
    }
}
