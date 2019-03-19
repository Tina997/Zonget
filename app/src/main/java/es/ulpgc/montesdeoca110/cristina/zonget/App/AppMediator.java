package es.ulpgc.montesdeoca110.cristina.zonget.App;

import android.app.Application;

import es.ulpgc.montesdeoca110.cristina.zonget.AdministratorMenu.AdministratorMenuState;
import es.ulpgc.montesdeoca110.cristina.zonget.AnimalCliente.AnimalDetailState;
import es.ulpgc.montesdeoca110.cristina.zonget.AnimalesCliente.AnimalesClienteListState;
import es.ulpgc.montesdeoca110.cristina.zonget.SignIn.SignInState;
import es.ulpgc.montesdeoca110.cristina.zonget.SignUp.SignUpState;
import es.ulpgc.montesdeoca110.cristina.zonget.SignUpConfirmation.SignUpConfirmationState;
import es.ulpgc.montesdeoca110.cristina.zonget.agendaAdmin.AgendaAdminState;
import es.ulpgc.montesdeoca110.cristina.zonget.agregarCita.AgregarCitaState;
import es.ulpgc.montesdeoca110.cristina.zonget.modificarCita.ModificarCitaState;

public class AppMediator extends Application {

    //Estados de las distintas activities de la aplicación
    private SignInState signInState;

    private SignUpState signUpState;

    private SignUpConfirmationState signUpConfirmationState;

    private AdministratorMenuState administratorMenuState;

    private AnimalesClienteListState animalesClienteListState = new AnimalesClienteListState();

    private AgendaAdminState agendaAdminState = new AgendaAdminState();

    private AnimalDetailState animalClientesDetailState = new AnimalDetailState();

    private AgregarCitaState agregarCitaState = new AgregarCitaState();

    private ModificarCitaState modificarCitaState = new ModificarCitaState();

    //Variables de las activities
    private AnimalClientesItem animal;

    @Override
    public void onCreate() {
        super.onCreate();

        signInState = new SignInState();
    }
    //Lista animales maestro y detalle

    public void setAnimalesClienteList(AnimalClientesItem item) {
        animal = item;
    }
    public AnimalDetailState getAnimalDetailState() {
        return animalClientesDetailState;
    }
    public AnimalClientesItem getAnimal(){
        AnimalClientesItem item = animal;
        return item;
    }
    public AnimalesClienteListState getAnimalesClienteListState() {
        return animalesClienteListState;
    }
    //SignIn
    public SignInState getSignInState() {
        return signInState;
    }

    public void setSignInState(SignInState signInState) {
        this.signInState = signInState;
    }

    //SignUp
    public SignUpState getSignUpState() {
        return signUpState;
    }

    public void setSignUpState(SignUpState signUpState) {
        this.signUpState = signUpState;
    }

    public SignUpConfirmationState getSignUpConfirmationState() {
        return signUpConfirmationState;
    }

    public void setSignUpConfirmationState(SignUpConfirmationState signUpConfirmationState) {
        this.signUpConfirmationState = signUpConfirmationState;
    }

    //AdministratorMenu
    public AdministratorMenuState getAdministratorMenuState() {
        return administratorMenuState;
    }

    public void setAdministratorMenuState(AdministratorMenuState administratorMenuState) {
        this.administratorMenuState = administratorMenuState;
    }


    public void setAnimalesClienteListState(AnimalesClienteListState state) {
        animalesClienteListState = state;
    }


    //AgendaAdmin
    public AgendaAdminState getAgendaAdminState() {
        return agendaAdminState;
    }

    public void setAgendaAdminState(AgendaAdminState agendaAdminState) {
        this.agendaAdminState = agendaAdminState;
    }


    //AgregarCita
    public AgregarCitaState getAgregarCitaState() {
        return agregarCitaState;
    }

    public void setAgregarCitaState(AgregarCitaState agregarCitaState) {
        this.agregarCitaState = agregarCitaState;
    }

    //ModificarCita
    public ModificarCitaState getModificarCitaState() {
        return modificarCitaState;
    }

    public void setModificarCitaState(ModificarCitaState modificarCitaState) {
        this.modificarCitaState = modificarCitaState;
    }

}
