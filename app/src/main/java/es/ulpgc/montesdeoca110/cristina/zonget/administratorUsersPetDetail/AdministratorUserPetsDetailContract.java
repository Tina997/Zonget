package es.ulpgc.montesdeoca110.cristina.zonget.administratorUsersPetDetail;

import android.content.Context;
import android.app.AlertDialog;

import java.lang.ref.WeakReference;

import es.ulpgc.montesdeoca110.cristina.zonget.app.PetsItem;
import es.ulpgc.montesdeoca110.cristina.zonget.app.UserPetItem;
import es.ulpgc.montesdeoca110.cristina.zonget.data.RepositoryContract;

interface AdministratorUserPetsDetailContract {

    interface View {
        void injectPresenter(Presenter presenter);

        void displayData(AdministratorUserPetsDetailViewModel viewModel);

        void onDeleteButtonClicked();
    }

    interface Presenter {
        void injectView(WeakReference<View> view);

        void injectModel(Model model);

        void injectRouter(Router router);

        void fetchData();

        void onEditButtonClicked();

        void onDeleteButtonClicked();

        String getActualThemeName();

        void onBackButtonPressed();
    }

    interface Model {
        String fetchData();

        void deletePet(UserPetItem pet, RepositoryContract.Accounts.DeleteUserPetCallback deleteUserPetCallback);
    }

    interface Router {
        void navigateToNextScreen();

        void passDataToNextScreen(AdministratorUserPetsDetailState state);

        UserPetItem getDataFromPreviousScreen();

        void navigateToEditScreen();

        void navigateToPetListScreen();

        String getActualThemeName();

        void onBackButtonPressed();
    }
}
