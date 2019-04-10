package es.ulpgc.montesdeoca110.cristina.zonget.editPetForAdoption;

import java.lang.ref.WeakReference;

interface EditPetForAdoptionContract {

    interface View {
        void injectPresenter(Presenter presenter);

        void displayData(EditPetForAdoptionViewModel viewModel);
    }

    interface Presenter {
        void injectView(WeakReference<View> view);

        void injectModel(Model model);

        void injectRouter(Router router);

        void fetchData();

        void onAcceptButtonClicked();
    }

    interface Model {
        String fetchData();
    }

    interface Router {
        void navigateToNextScreen();

        void passDataToNextScreen(EditPetForAdoptionState state);

        EditPetForAdoptionState getDataFromPreviousScreen();

        void navigateToPetForAdoptionDetailScreen();
    }
}
