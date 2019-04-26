package es.ulpgc.montesdeoca110.cristina.zonget.administratorSearchUsers;

import java.lang.ref.WeakReference;

interface AdministratorSearchUsersContract {

    interface View {
        void injectPresenter(Presenter presenter);

        void displayData(AdministratorSearchUsersViewModel viewModel);
    }

    interface Presenter {
        void injectView(WeakReference<View> view);

        void injectModel(Model model);

        void injectRouter(Router router);

        void fetchData();

        void searchButtonClicked(String nameOrDni);

        String getActualThemeName();
    }

    interface Model {
        String fetchData();
    }

    interface Router {
        void navigateToNextScreen();

        void passDataToNextScreen(AdministratorSearchUsersState state);

        AdministratorSearchUsersState getDataFromPreviousScreen();

        String getActualThemeName();
    }
}
