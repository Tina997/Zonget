package es.ulpgc.montesdeoca110.cristina.zonget.userQueriesMenu;

import java.lang.ref.WeakReference;

interface UserQueriesMenuContract {

    interface View {

        void injectPresenter(Presenter presenter);

        void displayUserQueriesMenuData(UserQueriesMenuViewModel viewModel);

    }

    interface Presenter {

        void injectView(WeakReference<View> view);

        void injectModel(Model model);

        void injectRouter(Router router);

        void backButtonPressed();

        void fetchUserQueriesMenuData();

        void newQueryButtonPressed();

        void pendingQueriesButtonPressed();

        void finishedQueriesButtonPressed();

    }

    interface Model {

        String fetchUserQueriesMenuData();

    }

    interface Router {

        //--------------- Navegación entre pantallas -----------

        void navigateToUserMenuScreen();

        void navigateToUserNewQueryScreen();

        void navigateToUserPendingQueriesScreen();

        void navigateToUserFinishedQueriesScreen();

        //------------- Paso de datos entre pantallas ----------

        void passDataToUserNewQueryScreen();

        void passDataToUserPendingQueriesListScreen();

        void passDataToUserFinishedQueriesListScreen();

        //------------- Obtener datos entre pantallas ----------

        //UserQueriesMenuState getDataFromPreviousScreen();

    }
}
