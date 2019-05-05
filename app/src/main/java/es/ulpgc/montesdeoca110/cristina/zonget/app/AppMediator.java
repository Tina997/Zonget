package es.ulpgc.montesdeoca110.cristina.zonget.app;

import android.app.Application;

import es.ulpgc.montesdeoca110.cristina.zonget.addLostPet.AddLostPetState;
import es.ulpgc.montesdeoca110.cristina.zonget.addPetForAdoption.AddPetForAdoptionState;
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
import es.ulpgc.montesdeoca110.cristina.zonget.app.statesBetweenActivities.ChangeThemeToMenuState;
import es.ulpgc.montesdeoca110.cristina.zonget.app.statesBetweenActivities.MenuToSelectedActivityState;
import es.ulpgc.montesdeoca110.cristina.zonget.app.statesBetweenActivities.MenuToSignInState;
import es.ulpgc.montesdeoca110.cristina.zonget.app.statesBetweenActivities.SignInToMenuState;
import es.ulpgc.montesdeoca110.cristina.zonget.app.statesBetweenActivities.SignUpToSignUpConfirmationState;
import es.ulpgc.montesdeoca110.cristina.zonget.app.statesBetweenActivities.SplashToSignInState;
import es.ulpgc.montesdeoca110.cristina.zonget.app.statesBetweenActivities.UserMenuToUserPickDateState;
import es.ulpgc.montesdeoca110.cristina.zonget.changeTheme.ChangeThemeState;
import es.ulpgc.montesdeoca110.cristina.zonget.editLostPet.EditLostPetState;
import es.ulpgc.montesdeoca110.cristina.zonget.editPetForAdoption.EditPetForAdoptionState;
import es.ulpgc.montesdeoca110.cristina.zonget.lostPets.LostPetsListState;
import es.ulpgc.montesdeoca110.cristina.zonget.lostPetsDetail.LostPetsDetailState;
import es.ulpgc.montesdeoca110.cristina.zonget.petsForAdoption.PetsForAdoptionState;
import es.ulpgc.montesdeoca110.cristina.zonget.petsForAdoptionDetail.PetsForAdoptionDetailState;
import es.ulpgc.montesdeoca110.cristina.zonget.userAgenda.UserAgendaState;
import es.ulpgc.montesdeoca110.cristina.zonget.userFinishedQueriesList.UserFinishedQueriesListState;
import es.ulpgc.montesdeoca110.cristina.zonget.userPendingQueriesList.UserPendingQueriesListState;
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

    private String actualThemeName;

    //Estados de las distintas activities de la aplicación

    private SignInState signInState;
    private SignUpState signUpState;
    private SignUpConfirmationState signUpConfirmationState;

    private AdministratorButtonsMenuListState administratorButtonsMenuListState;
    private UserButtonsMenuListState userButtonsMenuListState;
    private ChangeThemeState changeThemeActivityState;

    private UserQueriesMenuState userQueriesMenuState;
    private UserNewQueryState userNewQueryState;
    private UserPendingQueriesListState userPendingQueriesListState;
    private UserFinishedQueriesListState userFinishedQueriesListState;

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
    private LostPetsDetailState lostPetsDetailState = new LostPetsDetailState();

    private PetsForAdoptionState petsForAdoptionState = new PetsForAdoptionState();
    private PetsForAdoptionDetailState petsForAdoptionDetailState = new PetsForAdoptionDetailState();
    private EditPetForAdoptionState editPetForAdoptionState = new EditPetForAdoptionState();
    private AddPetForAdoptionState addPetForAdoptionState = new AddPetForAdoptionState();

    private AddLostPetState addLostPetState = new AddLostPetState();
    private EditLostPetState editLostPetState = new EditLostPetState();

    //Variables de las activities

    private UserPetItem animal;
    private UserItem userItem;
    private LostPetItem lostPet;
    private PetForAdoptionItem petForAdoptionItem;

    //Estados entre activities

    private SplashToSignInState splashToSignInState;
    private SignInToMenuState signInToMenuState;
    private ChangeThemeToMenuState changeThemeToMenuState;
    private MenuToSignInState menuToSignInState;
    private SignUpToSignUpConfirmationState signUpToSignUpConfirmationState;
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
        changeThemeActivityState = new ChangeThemeState();

        userQueriesMenuState = new UserQueriesMenuState();
        userNewQueryState = new UserNewQueryState();
        userPendingQueriesListState = new UserPendingQueriesListState();
        userFinishedQueriesListState = new UserFinishedQueriesListState();
    }

    //Theme
    public String getactualThemeName() {
        return actualThemeName;
    }

    public void setActualThemeName(String themeState) {
        this.actualThemeName = themeState;
    }

    //PetsListUser

    public void setUserPetsState(UserPetItem item) {
        animal = item;
    }
    public UserPetsDetailState getUserPetsDetailState() {
        return userPetDetailState;
    }
    public UserPetItem getAnimal(){
        return animal;
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

    //ChangeTheme
    public ChangeThemeState getChangeThemeState() {
        return changeThemeActivityState;
    }

    public void setChangeThemeState(ChangeThemeState changeThemeActivityState) {
        this.changeThemeActivityState = changeThemeActivityState;
    }

    //UserQueriesMenu
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

    //UserPendingQueriesList
    public UserPendingQueriesListState getUserPendingQueriesListState() {
        return userPendingQueriesListState;
    }

    public void setUserPendingQueriesListState(UserPendingQueriesListState userPendingQueriesListState) {
        this.userPendingQueriesListState = userPendingQueriesListState;
    }

    //UserFinishedQueriesList
    public UserFinishedQueriesListState getUserFinishedQueriesListState() {
        return userFinishedQueriesListState;
    }

    public void setUserFinishedQueriesListState(UserFinishedQueriesListState userFinishedQueriesListState) {
        this.userFinishedQueriesListState = userFinishedQueriesListState;
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

    //UserPickDate
    public void setUserPickDateState(UserPickDateState userPickDateState) {
        this.userPickDateState = userPickDateState;
    }

    public UserPickDateState getUserPickDateState() {
        return userPickDateState;
    }

    //PetsForAdoptionDetail
    public PetsForAdoptionDetailState getPetsForAdoptionDetailState() {
        return petsForAdoptionDetailState;
    }

    public void setPetsForAdoptionDetailState(PetsForAdoptionDetailState petsForAdoptionDetailState) {
        this.petsForAdoptionDetailState = petsForAdoptionDetailState;
    }

    //EditPetForAdoption
    public EditPetForAdoptionState getEditPetForAdoptionState() {
        return editPetForAdoptionState;
    }

    public void setEditPetForAdoptionState(EditPetForAdoptionState editPetForAdoptionState) {
        this.editPetForAdoptionState = editPetForAdoptionState;
    }

    //AddPetForAdoption
    public AddPetForAdoptionState getAddPetForAdoptionState() {
        return addPetForAdoptionState;
    }

    public void setAddPetForAdoptionState(AddPetForAdoptionState addPetForAdoptionState) {
        this.addPetForAdoptionState = addPetForAdoptionState;
    }

    //PetsForAdoption
    public PetsForAdoptionState getPetsForAdoptionState() {
        return petsForAdoptionState;
    }

    public void setPetsForAdoptionState(PetsForAdoptionState petsForAdoptionState) {
        this.petsForAdoptionState = petsForAdoptionState;
    }

    public PetForAdoptionItem getPetForAdoptionItem() {
        return petForAdoptionItem;
    }

    public void setPetForAdoptionItem(PetForAdoptionItem petForAdoptionItem) {
        this.petForAdoptionItem = petForAdoptionItem;
    }

    //AddPet
    public void setAdministratorUsersAddPetState(AdministratorUsersAddPetState administratorUsersAddPetState) {
        this.administratorUsersAddPetState = administratorUsersAddPetState;
    }

    public AdministratorUsersAddPetState getAdministratorUsersAddPetState() {
        return administratorUsersAddPetState;
    }
    //EditPet
    public void setAdministratorUserEditPetState(AdministratorUserEditPetState administratorUserEditPetState) {
        this.administratorUserEditPetState = administratorUserEditPetState;
    }

    public AdministratorUserEditPetState getAdministratorUserEditPetState() {
        return administratorUserEditPetState;
    }

    //UserAgenda
    public UserAgendaState getUserAgendaState() {
        return userAgendaState;
    }

    public void setUserAgendaState(UserAgendaState userAgendaState) {
        this.userAgendaState = userAgendaState;
    }

    //LostPetsDetail
    public LostPetsDetailState getLostPetsDetailState() {
        return lostPetsDetailState;
    }

    public LostPetItem getLostPetsDetailItem() {
        return lostPet;
    }

    //AddLostPets
    public AddLostPetState getAddLostPetState() {
        return addLostPetState;
    }

    //EditLostPets
    public EditLostPetState getEditLostPetState() {
        return editLostPetState;
    }

    //LostPets
    public void setlostPetsListState(LostPetItem lostPetsItem) {
        lostPetsItem = lostPet;
    }

    public void setLostPet(LostPetItem lostPetItem) {
        lostPet = lostPetItem;

    }

    public LostPetsListState getlostPetsListState() {
        return lostPetsListState;
    }

    //------------------------------------- Estados entre actividades ------------------------------------------

    //SplashToSignIn
    public SplashToSignInState getSplashToSignInState() {
        return splashToSignInState;
    }

    public void setSplashToSignInState(SplashToSignInState splashToSignInState) {
        this.splashToSignInState = splashToSignInState;
    }

    //SignInToMenu
    public SignInToMenuState getSignInToMenuState() {
        return signInToMenuState;
    }

    public void setSignInToMenuState(SignInToMenuState signInToMenuState) {
        this.signInToMenuState = signInToMenuState;
    }

    //ChangeThemeToMenu
    public ChangeThemeToMenuState getChangeThemeToMenuState() {
        return changeThemeToMenuState;
    }

    public void setChangeThemeToMenuState(ChangeThemeToMenuState changeThemeToMenuState) {
        this.changeThemeToMenuState = changeThemeToMenuState;
    }

    //SignUpToSignUpConfirmation
    public SignUpToSignUpConfirmationState getSignUpToSignUpConfirmationState() {
        return signUpToSignUpConfirmationState;
    }

    public void setSignUpToSignUpConfirmationState(SignUpToSignUpConfirmationState signUpToSignUpConfirmationState) {
        this.signUpToSignUpConfirmationState = signUpToSignUpConfirmationState;
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

}
