package es.ulpgc.montesdeoca110.cristina.zonget.userNewQuery;

import java.lang.ref.WeakReference;

interface UserNewQueryContract {

    interface View {

        void injectPresenter(Presenter presenter);

        void displayUserNewQueryData(UserNewQueryViewModel viewModel);

    }

    interface Presenter {

        void injectView(WeakReference<View> view);

        void injectModel(Model model);

        void injectRouter(Router router);

        void backButtonPressed();

        void fetchUserNewQueryData();

    }

    interface Model {

        void fetchUserNewQueryData();

    }

    interface Router {

        //--------------- Navegación entre pantallas -----------

        void navigateToUserQueriesMenuScreen();

        //------------- Paso de datos entre pantallas ----------

        void passDataToUserQueriesMenuScreen();

        //------------- Obtener datos entre pantallas ----------

        //UserNewQueryState getDataFromPreviousScreen();

    }
}
