package es.ulpgc.montesdeoca110.cristina.zonget.administratorQueryDetail;

import java.lang.ref.WeakReference;

interface AdministratorQueryDetailContract {

    interface View {
        void injectPresenter(Presenter presenter);

        void displayData(AdministratorQueryDetailViewModel viewModel);
    }

    interface Presenter {
        void injectView(WeakReference<View> view);

        void injectModel(Model model);

        void injectRouter(Router router);

        void fetchData();

        void navigateToAdministratorQueryAnswerScreen();
    }

    interface Model {
        String fetchData();
    }

    interface Router {
        void navigateToNextScreen();

        void passDataToNextScreen(AdministratorQueryDetailState state);

        AdministratorQueryDetailState getDataFromPreviousScreen();

        void navigateToAdministratorQueryAnswerScreen();
    }
}
