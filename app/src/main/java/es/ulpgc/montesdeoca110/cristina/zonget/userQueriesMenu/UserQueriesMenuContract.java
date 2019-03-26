package es.ulpgc.montesdeoca110.cristina.zonget.userQueriesMenu;

import java.lang.ref.WeakReference;

interface UserQueriesMenuContract {

    interface View {
        void injectPresenter(Presenter presenter);

        void displayData(UserQueriesMenuViewModel viewModel);
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

        void passDataToNextScreen(UserQueriesMenuState state);

        UserQueriesMenuState getDataFromPreviousScreen();
    }
}
