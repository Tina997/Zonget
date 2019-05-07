package es.ulpgc.montesdeoca110.cristina.zonget.userButtonsMenuList;

import java.lang.ref.WeakReference;

import es.ulpgc.montesdeoca110.cristina.zonget.app.statesBetweenActivities.ChangeThemeToMenuState;
import es.ulpgc.montesdeoca110.cristina.zonget.app.statesBetweenActivities.MenuToSelectedActivityState;
import es.ulpgc.montesdeoca110.cristina.zonget.app.statesBetweenActivities.MenuToSignInState;
import es.ulpgc.montesdeoca110.cristina.zonget.app.UserButtonMenuItem;
import es.ulpgc.montesdeoca110.cristina.zonget.data.RepositoryContract;

public interface UserButtonsMenuListContract {

    interface View {

        void injectPresenter(Presenter presenter);

        void displayUserButtonsMenuListData(UserButtonsMenuListViewModel viewModel);

        void reboot();

        void finish();

    }

    interface Presenter {

        void injectView(WeakReference<View> view);

        void injectModel(Model model);

        void injectRouter(Router router);

        String getActualThemeName();

        void fetchUserButtonsMenuListData();

        void signOutButtonPressed();

        void pickForADateButtonPressed();

        void selectUserButtonsMenuListData(UserButtonMenuItem item);

        void changeThemeButtonPressed();

        void checkThemeChanged();

    }

    interface Model {

        void fetchUserButtonsMenuListData(RepositoryContract.Settings.GetUserMenuButtonsListCallback callback);

    }

    interface Router {

        //------------------------- Tema ---------------------

        String getActualThemeName();

        void setChangeThemeToMenuState(boolean isChanged);

        //--------------- Navegación entre pantallas -----------

        void navigateToSignInScreen();

        void navigateToSelectedActivityScreen(String activityClassName);

        void navigateToUserPickDateScreen();

        void navigateToChangeThemeScreen();

        //------------- Paso de datos entre pantallas ----------

        void passDataToSignInScreen(MenuToSignInState state);

        void passDataToSelectedScreen(MenuToSelectedActivityState state);

        void passDataToUserPickDateScreen();

        //------------- Obtener datos entre pantallas ----------

        //UserButtonsMenuListState getDataFromSignInScreen();

        ChangeThemeToMenuState getDataFromChangeThemeScreen();

    }
}
