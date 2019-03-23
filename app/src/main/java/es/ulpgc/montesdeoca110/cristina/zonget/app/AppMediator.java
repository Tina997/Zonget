package es.ulpgc.montesdeoca110.cristina.zonget.app;

import android.app.Application;

import es.ulpgc.montesdeoca110.cristina.zonget.administratorAgenda.AdministratorAdministratorAgendaState;
import es.ulpgc.montesdeoca110.cristina.zonget.administratorButtonsMenuList.AdministratorButtonsMenuListState;
import es.ulpgc.montesdeoca110.cristina.zonget.userPets.UserPetsState;
import es.ulpgc.montesdeoca110.cristina.zonget.signIn.SignInState;
import es.ulpgc.montesdeoca110.cristina.zonget.signUp.SignUpState;
import es.ulpgc.montesdeoca110.cristina.zonget.signUpConfirmation.SignUpConfirmationState;
import es.ulpgc.montesdeoca110.cristina.zonget.addEvent.AddEventState;
import es.ulpgc.montesdeoca110.cristina.zonget.modifyEvent.ModifyEventState;
import es.ulpgc.montesdeoca110.cristina.zonget.userPetsDetail.UserPetsDetailState;

public class AppMediator extends Application {

    //Estados de las distintas activities de la aplicación
    private SignInState signInState;

    private SignUpState signUpState;

    private SignUpConfirmationState signUpConfirmationState;

    private AdministratorButtonsMenuListState administratorButtonsMenuListState;

    private UserPetsState clientPetsState = new UserPetsState();

    private AdministratorAdministratorAgendaState administratorAgendaState = new AdministratorAdministratorAgendaState();

    private UserPetsDetailState userPetDetailState = new UserPetsDetailState();

    private AddEventState addEventState = new AddEventState();

    private ModifyEventState modifyEventState = new ModifyEventState();

    //Variables de las activities

    private PetsItem animal;

    @Override
    public void onCreate() {
        super.onCreate();

        //Inicialización de los estados
        signInState = new SignInState();
        signUpState = new SignUpState();
        signUpConfirmationState = new SignUpConfirmationState();
        administratorButtonsMenuListState = new AdministratorButtonsMenuListState();
    }
    //Lista animales maestro y detalle

    public void setUserPetsState(PetsItem item) {
        animal = item;
    }
    public UserPetsDetailState getUserPetsDetailState() {
        return userPetDetailState;
    }
    public PetsItem getAnimal(){
        PetsItem item = animal;
        return item;
    }
    public UserPetsState getUserPetsState() {
        return clientPetsState;
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

    //AdministratorMenuList
    public AdministratorButtonsMenuListState getAdministratorMenuListState() {
        return administratorButtonsMenuListState;
    }

    public void setAdministratorMenuListState(AdministratorButtonsMenuListState administratorButtonsMenuListState) {
        this.administratorButtonsMenuListState = administratorButtonsMenuListState;
    }


    //AdministratorAgenda
    public AdministratorAdministratorAgendaState getAdministratorAgendaState() {
        return administratorAgendaState;
    }

    public void setAdministratorAgendaState(AdministratorAdministratorAgendaState administratorAgendaState) {
        this.administratorAgendaState = administratorAgendaState;
    }


    //AddEvent
    public AddEventState getAddEventState() {
        return addEventState;
    }

    public void setAddEventState(AddEventState addEventState) {
        this.addEventState = addEventState;
    }

    //ModifyEvent
    public ModifyEventState getModifyEventState() {
        return modifyEventState;
    }

    public void setModifyEventState(ModifyEventState modifyEventState) {
        this.modifyEventState = modifyEventState;
    }

}
