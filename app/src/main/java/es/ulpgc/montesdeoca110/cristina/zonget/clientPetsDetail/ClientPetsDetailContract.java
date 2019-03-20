package es.ulpgc.montesdeoca110.cristina.zonget.clientPetsDetail;

import java.lang.ref.WeakReference;

import es.ulpgc.montesdeoca110.cristina.zonget.app.PetsItem;

interface ClientPetsDetailContract {

    interface View {
        void injectPresenter(Presenter presenter);

        void displayData(ClientPetsDetailViewModel viewModel);
    }

    interface Presenter {
        void injectView(WeakReference<View> view);

        void injectModel(Model model);

        void injectRouter(Router router);

        void fetchPetsData();
    }

    interface Model {
        String fetchData();
    }

    interface Router {
        void navigateToNextScreen();

        void passDataToNextScreen(ClientPetsDetailState state);

        PetsItem getDataFromPreviousScreen();
    }
}
