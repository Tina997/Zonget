package es.ulpgc.montesdeoca110.cristina.zonget.userButtonsMenuList;

import java.lang.ref.WeakReference;

interface UserButtonsMenuListContract {

    interface View {
        void injectPresenter(Presenter presenter);

        void displayData(UserButtonsMenuListViewModel viewModel);
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

        void passDataToNextScreen(UserButtonsMenuListState state);

        UserButtonsMenuListState getDataFromPreviousScreen();
    }
}
