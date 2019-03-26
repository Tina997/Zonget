package es.ulpgc.montesdeoca110.cristina.zonget.userNewQuery;

import java.lang.ref.WeakReference;

interface UserNewQueryContract {

    interface View {
        void injectPresenter(Presenter presenter);

        void displayData(UserNewQueryViewModel viewModel);
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

        void passDataToNextScreen(UserNewQueryState state);

        UserNewQueryState getDataFromPreviousScreen();
    }
}
