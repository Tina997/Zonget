package es.ulpgc.montesdeoca110.cristina.zonget.userButtonsMenuList;

import java.lang.ref.WeakReference;

import es.ulpgc.montesdeoca110.cristina.zonget.app.MenuToSelectedActivityState;
import es.ulpgc.montesdeoca110.cristina.zonget.app.MenuToSignInState;
import es.ulpgc.montesdeoca110.cristina.zonget.app.UserMenuToUserPickDateState;
import es.ulpgc.montesdeoca110.cristina.zonget.app.UserButtonMenuItem;
import es.ulpgc.montesdeoca110.cristina.zonget.data.RepositoryContract;

interface UserButtonsMenuListContract {

    interface View {

        void injectPresenter(Presenter presenter);

        void displayUserButtonsMenuListData(UserButtonsMenuListViewModel viewModel);

    }

    interface Presenter {

        void injectView(WeakReference<View> view);

        void injectModel(Model model);

        void injectRouter(Router router);

        void fetchUserButtonsMenuListData();

        void signOutButtonPressed();

        void selectUserButtonsMenuListData(UserButtonMenuItem item);

    }

    interface Model {

        void fetchUserButtonsMenuListData(RepositoryContract.Settings.GetUserMenuButtonsListCallback callback);

    }

    interface Router {

        //--------------- Navegación entre pantallas -----------

        void navigateToSignInScreen();

        void navigateToSelectedActivityScreen(String activityClassName);

        void navigateToUserPickDateScreen();

        //------------- Paso de datos entre pantallas ----------

        void passDataToSignInScreen(MenuToSignInState state);

        void passDataToSelectedScreen(MenuToSelectedActivityState state);

        void passDataToUserPickDateScreen(UserMenuToUserPickDateState state);

        //------------- Obtener datos entre pantallas ----------

        UserButtonsMenuListState getDataFromSignInScreen();

    }
}
