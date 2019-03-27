package es.ulpgc.montesdeoca110.cristina.zonget.administratorButtonsMenuList;

import java.lang.ref.WeakReference;
import java.util.List;

import es.ulpgc.montesdeoca110.cristina.zonget.app.AdministratorButtonMenuItem;

interface AdministratorButtonsMenuListContract {

    interface View {
        void injectPresenter(Presenter presenter);

        void displayAdministratorButtonsMenuListData(AdministratorButtonsMenuListViewModel viewModel);
    }

    interface Presenter {
        void injectView(WeakReference<View> view);

        void injectModel(Model model);

        void injectRouter(Router router);

        void fetchAdministratorButtonsMenuListData();

        void signOutButtonPressed();

        void selectAdministratorButtonsMenuListData(AdministratorButtonMenuItem item);
    }

    interface Model {
        List<AdministratorButtonMenuItem> fetchAdministratorButtonsMenuListData();
    }

    interface Router {

        //--------------- Navegación entre pantallas -----------

        void navigateToSignInScreen();

        //------------- Paso de datos entre pantallas ----------

        void passDataToNextScreen(AdministratorButtonsMenuListState state);

        //------------- Obtener datos entre pantallas ----------

        AdministratorButtonsMenuListState getDataFromPreviousScreen();


    }
}
