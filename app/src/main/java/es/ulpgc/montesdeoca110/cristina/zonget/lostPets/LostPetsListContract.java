package es.ulpgc.montesdeoca110.cristina.zonget.lostPets;

import java.lang.ref.WeakReference;

interface LostPetsListContract {

    interface View {
        void injectPresenter(Presenter presenter);

        void displayData(LostPetsListViewModel viewModel);
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

        void passDataToNextScreen(LostPetsListState state);

        LostPetsListState getDataFromPreviousScreen();
    }
}
