package es.ulpgc.montesdeoca110.cristina.zonget.userPetsDetail;

import java.lang.ref.WeakReference;

import es.ulpgc.montesdeoca110.cristina.zonget.app.PetsItem;

interface UserPetsDetailContract {

    interface View {
        void injectPresenter(Presenter presenter);

        void displayData(UserPetsDetailViewModel viewModel);

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

        void passDataToNextScreen(UserPetsDetailState state);

        PetsItem getDataFromPreviousScreen();
    }
}
