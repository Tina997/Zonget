package es.ulpgc.montesdeoca110.cristina.zonget.petsForAdoptionDetail;

import java.lang.ref.WeakReference;

import es.ulpgc.montesdeoca110.cristina.zonget.app.PetForAdoptionItem;

interface PetsForAdoptionDetailContract {

    interface View {
        void injectPresenter(Presenter presenter);

        void displayData(PetsForAdoptionDetailViewModel viewModel);

        void onDeleteButtonClicked();
    }

    interface Presenter {
        void injectView(WeakReference<View> view);

        void injectModel(Model model);

        void injectRouter(Router router);

        void fetchPetForAdoptionDetailData();

        void onEditButtonClicked();

        String getActualThemeName();

        void onBackButtonClicked();
    }

    interface Model {
        String fetchData();
    }

    interface Router {
        void navigateToNextScreen();

        void passDataToNextScreen(PetsForAdoptionDetailState state);

        PetForAdoptionItem getDataFromPreviousScreen();

        void navigateToEditPetForAdoptionScreen();

        String getActualThemeName();

        void onBackButtonClicked();
    }
}
