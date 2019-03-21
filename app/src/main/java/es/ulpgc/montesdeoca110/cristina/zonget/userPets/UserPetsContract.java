package es.ulpgc.montesdeoca110.cristina.zonget.userPets;

import java.lang.ref.WeakReference;
import java.util.List;

import es.ulpgc.montesdeoca110.cristina.zonget.app.PetsItem;

interface UserPetsContract {

    interface View {
        void injectPresenter(Presenter presenter);

        void displayUserPetsData(UserPetsViewModel viewModel);
    }

    interface Presenter {
        void injectView(WeakReference<View> view);

        void injectModel(Model model);

        void injectRouter(Router router);

        void fetchUserPetsData();

        void selectUserPetsData(PetsItem item);
    }

    interface Model {
        List<PetsItem> fetchPetsData();
    }

    interface Router {
        void navigateToPetsDetailScreen();

        void passDataToPetsDetailScreen(PetsItem item);

        UserPetsState getDataFromPreviousScreen();
    }
}
