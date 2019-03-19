package es.ulpgc.montesdeoca110.cristina.zonget.AdministratorMenu;

import java.lang.ref.WeakReference;

interface AdministratorMenuContract {

    interface View {
        void injectPresenter(Presenter presenter);

        void displayData(AdministratorMenuViewModel viewModel);
    }

    interface Presenter {
        void injectView(WeakReference<View> view);

        void injectModel(Model model);

        void injectRouter(Router router);

        void fetchData();
    }

    interface Model {
        String fetchData();
    }

    interface Router {
        void navigateToNextScreen();

        void passDataToNextScreen(AdministratorMenuState state);

        AdministratorMenuState getDataFromPreviousScreen();
    }
}
