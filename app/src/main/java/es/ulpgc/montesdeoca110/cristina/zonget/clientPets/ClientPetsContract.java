package es.ulpgc.montesdeoca110.cristina.zonget.clientPets;

import java.lang.ref.WeakReference;
import java.util.List;

import es.ulpgc.montesdeoca110.cristina.zonget.app.PetsItem;

interface ClientPetsContract {

    interface View {
        void injectPresenter(Presenter presenter);

        void displayClientPetsData(ClientPetsViewModel viewModel);
    }

    interface Presenter {
        void injectView(WeakReference<View> view);

        void injectModel(Model model);

        void injectRouter(Router router);

        void fetchClientPetsData();

        void selectClientPetsData(PetsItem item);
    }

    interface Model {
        List<PetsItem> fetchPetsData();
    }

    interface Router {
        void navigateToPetsDetailScreen();

        void passDataToPetsDetailScreen(PetsItem item);

        ClientPetsState getDataFromPreviousScreen();
    }
}
