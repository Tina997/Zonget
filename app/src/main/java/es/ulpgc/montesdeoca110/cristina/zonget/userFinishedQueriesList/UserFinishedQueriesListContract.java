package es.ulpgc.montesdeoca110.cristina.zonget.userFinishedQueriesList;

import java.lang.ref.WeakReference;

public interface UserFinishedQueriesListContract {

    interface View {
        void injectPresenter(Presenter presenter);

        void displayData(UserFinishedQueriesListViewModel viewModel);
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

        void passDataToNextScreen(UserFinishedQueriesListState state);

        UserFinishedQueriesListState getDataFromPreviousScreen();
    }
}
