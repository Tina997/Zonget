package es.ulpgc.montesdeoca110.cristina.zonget.queriesMenu;

import java.lang.ref.WeakReference;

interface QueriesMenuContract {

    interface View {
        void injectPresenter(Presenter presenter);

        void displayData(QueriesMenuViewModel viewModel);
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

        void passDataToNextScreen(QueriesMenuState state);

        QueriesMenuState getDataFromPreviousScreen();
    }
}
