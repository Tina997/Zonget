package es.ulpgc.montesdeoca110.cristina.zonget.administratorButtonsMenuList;

import android.content.Intent;
import android.content.Context;

import es.ulpgc.montesdeoca110.cristina.zonget.app.AppMediator;
import es.ulpgc.montesdeoca110.cristina.zonget.app.ChangeThemeToMenuState;
import es.ulpgc.montesdeoca110.cristina.zonget.app.MenuToSelectedActivityState;
import es.ulpgc.montesdeoca110.cristina.zonget.app.MenuToSignInState;
import es.ulpgc.montesdeoca110.cristina.zonget.changeTheme.ChangeThemeActivity;
import es.ulpgc.montesdeoca110.cristina.zonget.signIn.SignInActivity;

public class AdministratorButtonsMenuListRouter implements AdministratorButtonsMenuListContract.Router {

    private AppMediator mediator;

    public AdministratorButtonsMenuListRouter(AppMediator mediator) {
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

    // To SignInActivity
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

    // To SelectedActivity
    @Override
    public void passDataToSelectedActivityScreen(MenuToSelectedActivityState state) {
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

    // To ChangeTheme

    @Override
    public void navigateToChangeThemeScreen() {
        Context context = mediator.getApplicationContext();
        Intent intent = new Intent(context, ChangeThemeActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        context.startActivity(intent);
    }

}
