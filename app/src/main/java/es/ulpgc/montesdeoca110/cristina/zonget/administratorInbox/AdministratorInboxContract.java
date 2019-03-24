package es.ulpgc.montesdeoca110.cristina.zonget.administratorInbox;

import java.lang.ref.WeakReference;

interface AdministratorInboxContract {

    interface View {
        void injectPresenter(Presenter presenter);

        void displayData(AdministratorInboxViewModel viewModel);
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

        void passDataToNextScreen(AdministratorInboxState state);

        AdministratorInboxState getDataFromPreviousScreen();
    }
}
