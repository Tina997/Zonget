package es.ulpgc.montesdeoca110.cristina.zonget.app;

import android.app.Application;

import es.ulpgc.montesdeoca110.cristina.zonget.administratorAgenda.AdministratorAgendaState;
import es.ulpgc.montesdeoca110.cristina.zonget.administratorButtonsMenuList.AdministratorButtonsMenuListState;
import es.ulpgc.montesdeoca110.cristina.zonget.administratorInbox.AdministratorInboxActivity;
import es.ulpgc.montesdeoca110.cristina.zonget.administratorInbox.AdministratorInboxState;
import es.ulpgc.montesdeoca110.cristina.zonget.administratorSearchUsers.AdministratorSearchUsersState;
import es.ulpgc.montesdeoca110.cristina.zonget.administratorUsersList.AdministratorUsersListState;
import es.ulpgc.montesdeoca110.cristina.zonget.queriesMenu.QueriesMenuActivity;
import es.ulpgc.montesdeoca110.cristina.zonget.queriesMenu.QueriesMenuState;
import es.ulpgc.montesdeoca110.cristina.zonget.userButtonsMenuList.UserButtonsMenuListActivity;
import es.ulpgc.montesdeoca110.cristina.zonget.userButtonsMenuList.UserButtonsMenuListState;
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

    private UserButtonsMenuListState userButtonsMenuListState;

    private QueriesMenuState queriesMenuState;

    private UserPetsState clientPetsState = new UserPetsState();

    private AdministratorAgendaState administratorAgendaState = new AdministratorAgendaState();

    private UserPetsDetailState userPetDetailState = new UserPetsDetailState();

    private AddEventState addEventState = new AddEventState();

    private ModifyEventState modifyEventState = new ModifyEventState();

    private AdministratorInboxState administratorInboxState = new AdministratorInboxState();

    private AdministratorSearchUsersState administratorSearchUserState = new AdministratorSearchUsersState("");

    private AdministratorUsersListState administratorUsersListState;

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
        userButtonsMenuListState = new UserButtonsMenuListState();
        queriesMenuState = new QueriesMenuState();
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

    //UserButtonsMenuList
    public UserButtonsMenuListState getUserButtonsMenuListState() {
        return userButtonsMenuListState;
    }

    public void setUserButtonsMenuListState(UserButtonsMenuListState userButtonsMenuListState) {
        this.userButtonsMenuListState = userButtonsMenuListState;
    }

    //QueriesMenu
    public QueriesMenuState getQueriesMenuState() {
        return queriesMenuState;
    }

    public void setQueriesMenuState(QueriesMenuState queriesMenuState) {
        this.queriesMenuState = queriesMenuState;
    }

    //AdministratorAgenda
    public AdministratorAgendaState getAdministratorAgendaState() {
        return administratorAgendaState;
    }

    public void setAdministratorAgendaState(AdministratorAgendaState administratorAgendaState) {
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
    //AdministratorSearchUsers
    public AdministratorSearchUsersState getadminSearchUsersState() {
        return administratorSearchUserState;
    }
    public void setadminSearchUsersState(AdministratorSearchUsersState administratorSearchUsersState) {
        administratorSearchUserState = administratorSearchUsersState;
    }
    //AdministratorInbox
    public AdministratorInboxState getAdministratorInboxState() {
        return administratorInboxState;
    }

    public void setAdministratorInboxState(AdministratorInboxState administratorInboxState) {
        this.administratorInboxState = administratorInboxState;
    }

    //UsersList
    public void setAdministratorUsersListState(AdministratorUsersListState administratorUsersListState) {
        this.administratorUsersListState = administratorUsersListState;
    }

    public AdministratorUsersListState getAdministratorUsersListState() {
    return administratorUsersListState;
    }
}
