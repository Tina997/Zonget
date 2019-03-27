package es.ulpgc.montesdeoca110.cristina.zonget.userButtonsMenuList;

import java.lang.ref.WeakReference;
import java.util.List;

import es.ulpgc.montesdeoca110.cristina.zonget.app.UserButtonMenuItem;

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
        List<UserButtonMenuItem> fetchUserButtonsMenuListData();
    }

    interface Router {

        //--------------- Navegación entre pantallas -----------

        void navigateToSignInScreen();

        //------------- Paso de datos entre pantallas ----------

        void passDataToNextScreen(UserButtonsMenuListState state);

        //------------- Obtener datos entre pantallas ----------

        UserButtonsMenuListState getDataFromPreviousScreen();


    }
}
