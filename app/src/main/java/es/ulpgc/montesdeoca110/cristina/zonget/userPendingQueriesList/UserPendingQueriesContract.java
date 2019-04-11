package es.ulpgc.montesdeoca110.cristina.zonget.userPendingQueriesList;

import java.lang.ref.WeakReference;

public interface UserPendingQueriesContract {

    interface View {
        void injectPresenter(Presenter presenter);

        void displayData(UserPendingQueriesViewModel viewModel);
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

        void passDataToNextScreen(UserPendingQueriesState state);

        UserPendingQueriesState getDataFromPreviousScreen();
    }
}
