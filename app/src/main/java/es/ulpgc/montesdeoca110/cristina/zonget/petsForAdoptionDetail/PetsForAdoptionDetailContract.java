package es.ulpgc.montesdeoca110.cristina.zonget.petsForAdoptionDetail;

import java.lang.ref.WeakReference;

interface PetsForAdoptionDetailContract {

    interface View {
        void injectPresenter(Presenter presenter);

        void displayData(PetsForAdoptionDetailViewModel viewModel);
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

        void passDataToNextScreen(PetsForAdoptionDetailState state);

        PetsForAdoptionDetailState getDataFromPreviousScreen();
    }
}
