package es.ulpgc.montesdeoca110.cristina.zonget.petsForAdoption;

import java.lang.ref.WeakReference;

interface PetsForAdoptionContract {

    interface View {
        void injectPresenter(Presenter presenter);

        void displayData(PetsForAdoptionViewModel viewModel);
    }

    interface Presenter {
        void injectView(WeakReference<View> view);

        void injectModel(Model model);

        void injectRouter(Router router);

        void fetchPetsForAdoptionListData();
    }

    interface Model {
        String fetchData();
    }

    interface Router {
        void navigateToNextScreen();

        void passDataToNextScreen(PetsForAdoptionState state);

        PetsForAdoptionState getDataFromPreviousScreen();
    }
}
