package es.ulpgc.montesdeoca110.cristina.zonget.userButtonsMenuList;

import android.content.Intent;
import android.content.Context;

import es.ulpgc.montesdeoca110.cristina.zonget.app.AppMediator;
import es.ulpgc.montesdeoca110.cristina.zonget.app.ChangeThemeToMenuState;
import es.ulpgc.montesdeoca110.cristina.zonget.app.MenuToSelectedActivityState;
import es.ulpgc.montesdeoca110.cristina.zonget.app.MenuToSignInState;
import es.ulpgc.montesdeoca110.cristina.zonget.app.UserMenuToUserPickDateState;
import es.ulpgc.montesdeoca110.cristina.zonget.changeTheme.ChangeThemeActivity;
import es.ulpgc.montesdeoca110.cristina.zonget.signIn.SignInActivity;
import es.ulpgc.montesdeoca110.cristina.zonget.userPickDate.UserPickDateActivity;

public class UserButtonsMenuListRouter implements UserButtonsMenuListContract.Router {

    private AppMediator mediator;

    public UserButtonsMenuListRouter(AppMediator mediator) {
        this.mediator = mediator;
    }

    @Override
    public String getActualThemeName() {
        return mediator.getactualThemeName();
    }

    @Override
    public ChangeThemeToMenuState getDataFromChangeThemeScreen() {
        return mediator.getChangeThemeToMenuState();
    }

    //To SingInActivity

    @Override
    public void passDataToSignInScreen(MenuToSignInState state) {
        mediator.setMenuToSignInState(state);
    }

    @Override
    public void navigateToSignInScreen() {
        Context context = mediator.getApplicationContext();
        Intent intent = new Intent(context, SignInActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        context.startActivity(intent);
    }

    //To SelectedActivity

    @Override
    public void passDataToSelectedScreen(MenuToSelectedActivityState state) {
        mediator.setMenuToSelectedActivityState(state);
    }

    @Override
    public void navigateToSelectedActivityScreen(String activityClassName) {
        Context context = mediator.getApplicationContext();
        Class activity = null;
        try {
            activity = Class.forName(activityClassName);
        } catch (ClassNotFoundException e) {}
        Intent intent = new Intent(context, activity);
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        context.startActivity(intent);
    }

    //To UserPickDate

    @Override
    public void passDataToUserPickDateScreen() {

    }

    @Override
    public void navigateToUserPickDateScreen() {
        Context context = mediator.getApplicationContext();
        Intent intent = new Intent(context, UserPickDateActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        context.startActivity(intent);
    }

    // To ChangeTheme

    @Override
    public void navigateToChangeThemeScreen() {
        Context context = mediator.getApplicationContext();
        Intent intent = new Intent(context, ChangeThemeActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        context.startActivity(intent);
    }

}
