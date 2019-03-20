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

        void selectAdministratorButtonsMenuListData(AdministratorButtonMenuItem item);
    }

    interface Model {
        List<AdministratorButtonMenuItem> fetchAdministratorButtonsMenuListData();
    }

    interface Router {
        void navigateToNextScreen();

        void passDataToNextScreen(AdministratorButtonsMenuListState state);

        AdministratorButtonsMenuListState getDataFromPreviousScreen();
    }
}
