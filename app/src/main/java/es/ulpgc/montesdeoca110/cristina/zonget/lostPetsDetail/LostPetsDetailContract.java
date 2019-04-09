package es.ulpgc.montesdeoca110.cristina.zonget.lostPetsDetail;

import java.lang.ref.WeakReference;

import es.ulpgc.montesdeoca110.cristina.zonget.app.LostPetItem;

interface LostPetsDetailContract {

    interface View {
        void injectPresenter(Presenter presenter);

        void displayLostPetDetailData(LostPetsDetailViewModel viewModel);

        void onDeleteButtonClicked();
    }

    interface Presenter {
        void injectView(WeakReference<View> view);

        void injectModel(Model model);

        void injectRouter(Router router);

        void fetchLostPetDetailData();

        void onEditButtonClicked();

        void deletePet();
    }

    interface Model {
    }

    interface Router {
        void navigateToNextScreen();

        void passDataToNextScreen(LostPetsDetailState state);

        LostPetItem getDataFromLostPetsListScreen();

        void navigateToEditScreen();

        void navigateToLostPetListScreen();
    }
}
