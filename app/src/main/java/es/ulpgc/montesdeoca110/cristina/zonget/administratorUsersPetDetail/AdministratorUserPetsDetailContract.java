package es.ulpgc.montesdeoca110.cristina.zonget.administratorUsersPetDetail;

import android.content.Context;
import android.app.AlertDialog;

import java.lang.ref.WeakReference;

import es.ulpgc.montesdeoca110.cristina.zonget.app.PetsItem;

interface AdministratorUserPetsDetailContract {

    interface View {
        void injectPresenter(Presenter presenter);

        void displayData(AdministratorUserPetsDetailViewModel viewModel);
    }

    interface Presenter {
        void injectView(WeakReference<View> view);

        void injectModel(Model model);

        void injectRouter(Router router);

        void fetchData();

        void onEditButtonClicked();

    }

    interface Model {
        String fetchData();
    }

    interface Router {
        void navigateToNextScreen();

        void passDataToNextScreen(AdministratorUserPetsDetailState state);

        PetsItem getDataFromPreviousScreen();

        void navigateToEditScreen();

    }
}
