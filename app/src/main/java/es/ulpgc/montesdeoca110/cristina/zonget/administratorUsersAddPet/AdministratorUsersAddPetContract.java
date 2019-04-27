package es.ulpgc.montesdeoca110.cristina.zonget.administratorUsersAddPet;

import java.lang.ref.WeakReference;

interface AdministratorUsersAddPetContract {

    interface View {
        void injectPresenter(Presenter presenter);

        void displayData(AdministratorUsersAddPetViewModel viewModel);
    }

    interface Presenter {
        void injectView(WeakReference<View> view);

        void injectModel(Model model);

        void injectRouter(Router router);

        void fetchData();

        void insertNewPet();

        String getActualThemeName();

        void onBackButtonPressed();
    }

    interface Model {
        String fetchData();
    }

    interface Router {
        void navigateToNextScreen();

        void passDataToNextScreen(AdministratorUsersAddPetState state);

        AdministratorUsersAddPetState getDataFromPreviousScreen();

        String getActualThemeName();

        void onBackButtonPressed();
    }
}
