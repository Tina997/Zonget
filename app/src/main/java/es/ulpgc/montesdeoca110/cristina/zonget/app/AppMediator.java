package es.ulpgc.montesdeoca110.cristina.zonget.app;

import android.app.Application;

import es.ulpgc.montesdeoca110.cristina.zonget.administratorAgenda.AdministratorAgendaState;
import es.ulpgc.montesdeoca110.cristina.zonget.administratorButtonsMenuList.AdministratorButtonsMenuListState;
import es.ulpgc.montesdeoca110.cristina.zonget.administratorInbox.AdministratorInboxState;
import es.ulpgc.montesdeoca110.cristina.zonget.administratorQueryAnswer.AdministratorQueryAnswerState;
import es.ulpgc.montesdeoca110.cristina.zonget.administratorQueryDetail.AdministratorQueryDetailState;
import es.ulpgc.montesdeoca110.cristina.zonget.administratorSearchUsers.AdministratorSearchUsersState;
import es.ulpgc.montesdeoca110.cristina.zonget.administratorUserEditPet.AdministratorUserEditPetState;
import es.ulpgc.montesdeoca110.cristina.zonget.administratorUsersAddPet.AdministratorUsersAddPetState;
import es.ulpgc.montesdeoca110.cristina.zonget.administratorUsersList.AdministratorUsersListState;
import es.ulpgc.montesdeoca110.cristina.zonget.administratorUsersPetDetail.AdministratorUserPetsDetailState;
import es.ulpgc.montesdeoca110.cristina.zonget.administratorUsersPets.AdministratorUsersPetsListState;
import es.ulpgc.montesdeoca110.cristina.zonget.lostPets.LostPetsListState;
import es.ulpgc.montesdeoca110.cristina.zonget.petsForAdoption.PetsForAdoptionState;
import es.ulpgc.montesdeoca110.cristina.zonget.userAgenda.UserAgendaState;
import es.ulpgc.montesdeoca110.cristina.zonget.userPickDate.UserPickDateState;
import es.ulpgc.montesdeoca110.cristina.zonget.userQueriesMenu.UserQueriesMenuState;
import es.ulpgc.montesdeoca110.cristina.zonget.userButtonsMenuList.UserButtonsMenuListState;
import es.ulpgc.montesdeoca110.cristina.zonget.userNewQuery.UserNewQueryState;
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

    private UserQueriesMenuState userQueriesMenuState;

    private UserNewQueryState userNewQueryState;

    private UserPetsState clientPetsState = new UserPetsState();

    private UserAgendaState userAgendaState = new UserAgendaState();

    private AdministratorAgendaState administratorAgendaState = new AdministratorAgendaState();

    private UserPetsDetailState userPetDetailState = new UserPetsDetailState();

    private AddEventState addEventState = new AddEventState();

    private ModifyEventState modifyEventState = new ModifyEventState();

    private AdministratorInboxState administratorInboxState = new AdministratorInboxState();

    private AdministratorQueryDetailState administratorQueryDetailState = new AdministratorQueryDetailState();

    private AdministratorQueryAnswerState administratorQueryAnswerState = new AdministratorQueryAnswerState();

    private AdministratorSearchUsersState administratorSearchUserState = new AdministratorSearchUsersState();

    private AdministratorUsersListState administratorUsersListState = new AdministratorUsersListState();

    private AdministratorUsersPetsListState administratorUsersPetsListState = new AdministratorUsersPetsListState();

    private AdministratorUserPetsDetailState administratorUserPetsDetailState = new AdministratorUserPetsDetailState();
    private AdministratorUsersAddPetState administratorUsersAddPetState = new AdministratorUsersAddPetState();
    private AdministratorUserEditPetState administratorUserEditPetState = new AdministratorUserEditPetState();
    private UserPickDateState userPickDateState = new UserPickDateState();
    private LostPetsListState lostPetsListState = new LostPetsListState();

    private PetsForAdoptionState petsForAdoptionState = new PetsForAdoptionState();
    //Variables de las activities
    private PetsItem animal;
    private UserItem userItem;

    //Estados entre activities
    private SignInToMenuState signInToMenuState;
    private MenuToSignInState menuToSignInState;
    private MenuToSelectedActivityState menuToSelectedActivityState;
    private UserMenuToUserPickDateState userMenuToUserPickDateState;


    @Override
    public void onCreate() {
        super.onCreate();

        //Inicialización de los estados
        signInState = new SignInState();
        signUpState = new SignUpState();
        signUpConfirmationState = new SignUpConfirmationState();
        administratorButtonsMenuListState = new AdministratorButtonsMenuListState();
        userButtonsMenuListState = new UserButtonsMenuListState();
        userQueriesMenuState = new UserQueriesMenuState();
        userNewQueryState = new UserNewQueryState();
    }
    //PetsListUser

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
    public UserQueriesMenuState getUserQueriesMenuState() {
        return userQueriesMenuState;
    }

    public void setUserQueriesMenuState(UserQueriesMenuState userQueriesMenuState) {
        this.userQueriesMenuState = userQueriesMenuState;
    }

    //UserNewQuery
    public UserNewQueryState getUserNewQueryState() {
        return userNewQueryState;
    }

    public void setUserNewQueryState(UserNewQueryState userNewQueryState) {
        this.userNewQueryState = userNewQueryState;
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

    //AdministratorQueryDetail
    public AdministratorQueryDetailState getAdministratorQueryDetailState() {
        return administratorQueryDetailState;
    }

    public void setAdministratorQueryDetailState(AdministratorQueryDetailState administratorQueryDetailState) {
        this.administratorQueryDetailState = administratorQueryDetailState;
    }

    //AdministratorQueryAnswer
    public AdministratorQueryAnswerState getAdministratorQueryAnswerState() {
        return administratorQueryAnswerState;
    }

    public void setAdministratorQueryAnswerState(AdministratorQueryAnswerState administratorQueryAnswerState) {
        this.administratorQueryAnswerState = administratorQueryAnswerState;
    }

    //UsersList
    public void setAdministratorUsersListState(AdministratorUsersListState administratorUsersListState) {
        this.administratorUsersListState = administratorUsersListState;
    }

    public void setUserItem(UserItem item) {
        this.userItem = item;
    }
    public AdministratorUsersListState getAdministratorUsersListState() {
    return administratorUsersListState;
    }

    //UsersPetList Admin
    public void setAdministratorUsersPetsListState(AdministratorUsersPetsListState state) {
        this.administratorUsersPetsListState = state;
    }

    public AdministratorUsersPetsListState getAdministratorUsersPetsListState() {
        return administratorUsersPetsListState;
    }
    //AdminUserPet Detail
    public AdministratorUserPetsDetailState getAdministratorUserPetsDetailState() {
        return administratorUserPetsDetailState;
    }

    public void setAdministratorUserPetsDetailState(AdministratorUserPetsDetailState administratorUserPetsDetailState) {
        this.administratorUserPetsDetailState = administratorUserPetsDetailState;
    }

    //------------------------------------- States between activities ------------------------------------------

    //SignInToMenu
    public SignInToMenuState getSignInToMenuState() {
        return signInToMenuState;
    }

    public void setSignInToMenuState(SignInToMenuState signInToMenuState) {
        this.signInToMenuState = signInToMenuState;
    }

    //MenuToSingIn
    public MenuToSignInState getMenuToSignInState() {
        return menuToSignInState;
    }

    public void setMenuToSignInState(MenuToSignInState menuToSignInState) {
        this.menuToSignInState = menuToSignInState;
    }

    //MenuToSelectedActivity
    public MenuToSelectedActivityState getMenuToSelectedActivityState() {
        return menuToSelectedActivityState;
    }

    public void setMenuToSelectedActivityState(MenuToSelectedActivityState menuToSelectedActivityState) {
        this.menuToSelectedActivityState = menuToSelectedActivityState;
    }

    //UserMenuToUserPickDate
    public UserMenuToUserPickDateState getUserMenuToUserPickDateState() {
        return userMenuToUserPickDateState;
    }

    public void setUserMenuToUserPickDateState(UserMenuToUserPickDateState userMenuToUserPickDateState) {
        this.userMenuToUserPickDateState = userMenuToUserPickDateState;
    }

    //AddPet
    public void setAdministratorUsersAddPetState(AdministratorUsersAddPetState administratorUsersAddPetState) {
        this.administratorUserPetsDetailState = administratorUserPetsDetailState;
    }

    public AdministratorUsersAddPetState getAdministratorUsersAddPetState() {
        return administratorUsersAddPetState;
    }
    //EditPet
    public void setAdministratorUserEditPetState(AdministratorUserEditPetState administratorUserEditPetState) {
        this.administratorUserPetsDetailState = administratorUserPetsDetailState;
    }

    public AdministratorUserEditPetState getAdministratorUserEditPetState() {
        return administratorUserEditPetState;
    }

    public UserPickDateState getUserPickDateState() {
        return userPickDateState;
    }

    //UserAgenda
    public UserAgendaState getUserAgendaState() {
        return userAgendaState;
    }

    public void setUserAgendaState(UserAgendaState userAgendaState) {
        this.userAgendaState = userAgendaState;
    }

    public void setlostPetsListState(LostPetsListState lostPetsListState) {
        this.lostPetsListState = lostPetsListState;
    }

    public LostPetsListState getlostPetsListState() {
        return lostPetsListState;
    }

    //PetsForAdoption
    public PetsForAdoptionState getPetsForAdoptionState() {
        return petsForAdoptionState;
    }

    public void setPetsForAdoptionState(PetsForAdoptionState petsForAdoptionState) {
        this.petsForAdoptionState = petsForAdoptionState;
    }

}
