package es.ulpgc.montesdeoca110.cristina.zonget.administratorUsersList;

import java.lang.ref.WeakReference;

interface AdministratorUsersListContract {

    interface View {
        void injectPresenter(Presenter presenter);

        void displayData(AdministratorUsersListViewModel viewModel);
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

        void passDataToNextScreen(AdministratorUsersListState state);

        AdministratorUsersListState getDataFromPreviousScreen();
    }
}
