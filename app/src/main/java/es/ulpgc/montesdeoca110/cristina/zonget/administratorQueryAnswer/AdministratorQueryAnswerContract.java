package es.ulpgc.montesdeoca110.cristina.zonget.administratorQueryAnswer;

import java.lang.ref.WeakReference;

interface AdministratorQueryAnswerContract {

    interface View {
        void injectPresenter(Presenter presenter);

        void displayData(AdministratorQueryAnswerViewModel viewModel);
    }

    interface Presenter {
        void injectView(WeakReference<View> view);

        void injectModel(Model model);

        void injectRouter(Router router);

        void fetchData();

        void navigateToAdministratorInboxScreen();
    }

    interface Model {
        String fetchData();
    }

    interface Router {
        void navigateToNextScreen();

        void passDataToNextScreen(AdministratorQueryAnswerState state);

        AdministratorQueryAnswerState getDataFromPreviousScreen();

        void navigateToAdministratorInboxScreen();
    }
}
