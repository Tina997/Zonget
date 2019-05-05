package es.ulpgc.montesdeoca110.cristina.zonget.administratorUsersPets;

import java.lang.ref.WeakReference;
import java.util.List;

import es.ulpgc.montesdeoca110.cristina.zonget.app.UserPetItem;


interface AdministratorUsersPetsListContract {

    interface View {
        void injectPresenter(Presenter presenter);

        void displayUserPetsData(AdministratorUsersPetsListViewModel viewModel);
    }

    interface Presenter {
        void injectView(WeakReference<AdministratorUsersPetsListContract.View> view);

        void injectModel(AdministratorUsersPetsListContract.Model model);

        void injectRouter(AdministratorUsersPetsListContract.Router router);

        void fetchUserPetsData();

        void selectUserPetsData(UserPetItem item);

        void onClickAddButton();

        String getActualThemeName();

        void onBackButtonPressed();
    }

    interface Model {
        List<UserPetItem> fetchPetsData();
    }

    interface Router {
        void navigateToPetsDetailScreen();

        void passDataToPetsDetailScreen(UserPetItem item);

        AdministratorUsersPetsListState getDataFromPreviousScreen();

        void navigateToAddScreen();

        String getActualThemeName();

        void onBackButtonPressed();
    }
}
