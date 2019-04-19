package es.ulpgc.montesdeoca110.cristina.zonget.administratorButtonsMenuList;

import java.lang.ref.WeakReference;

import es.ulpgc.montesdeoca110.cristina.zonget.app.AdministratorButtonMenuItem;
import es.ulpgc.montesdeoca110.cristina.zonget.app.ChangeThemeToMenuState;
import es.ulpgc.montesdeoca110.cristina.zonget.app.MenuToSelectedActivityState;
import es.ulpgc.montesdeoca110.cristina.zonget.app.MenuToSignInState;
import es.ulpgc.montesdeoca110.cristina.zonget.data.RepositoryContract;

interface AdministratorButtonsMenuListContract {

    interface View {

        void injectPresenter(Presenter presenter);

        void displayAdministratorButtonsMenuListData(AdministratorButtonsMenuListViewModel viewModel);

        String getActualThemeName();

        void reboot();

        void finish();

    }

    interface Presenter {

        void injectView(WeakReference<View> view);

        void injectModel(Model model);

        void injectRouter(Router router);

        String getActualThemeName();

        void fetchAdministratorButtonsMenuListData();

        void signOutButtonPressed();

        void selectAdministratorButtonsMenuListData(AdministratorButtonMenuItem item);

        void changeThemeButtonPressed();

        void checkThemeChanged();
    }

    interface Model {

        
        void fetchAdministratorButtonsMenuListData(RepositoryContract.Settings.GetAdministratorMenuButtonsListCallback callback);

    }

    interface Router {

        //------------------------- Tema ---------------------

        String getActualThemeName();

        //--------------- Navegación entre pantallas -----------

        void navigateToSignInScreen();

        void navigateToSelectedActivityScreen(String activityClassName);

        void navigateToChangeThemeScreen();

        //------------- Paso de datos entre pantallas ----------

        void passDataToSignInScreen(MenuToSignInState state);

        void passDataToSelectedActivityScreen(MenuToSelectedActivityState state);

        //void passDataToChangeThemeScreen();

        //------------- Obtener datos entre pantallas ----------

        //AdministratorButtonsMenuListState getDataFromSignInScreen();

        ChangeThemeToMenuState getDataFromChangeThemeScreen();

    }
}
