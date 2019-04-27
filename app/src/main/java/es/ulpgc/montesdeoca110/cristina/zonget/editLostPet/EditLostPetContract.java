package es.ulpgc.montesdeoca110.cristina.zonget.editLostPet;

import java.lang.ref.WeakReference;

interface EditLostPetContract {

    interface View {
        void injectPresenter(Presenter presenter);

        void displayData(EditLostPetViewModel viewModel);
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

        void passDataToNextScreen(EditLostPetState state);

        EditLostPetState getDataFromPreviousScreen();

        void navigateToLostPetDetailScreen();

        String getActualThemeName();

        void onBackButtonPressed();
    }
}
