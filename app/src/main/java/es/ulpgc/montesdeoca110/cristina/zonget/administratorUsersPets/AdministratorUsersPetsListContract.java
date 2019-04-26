package es.ulpgc.montesdeoca110.cristina.zonget.administratorUsersPets;

import java.lang.ref.WeakReference;
import java.util.List;

import es.ulpgc.montesdeoca110.cristina.zonget.administratorSearchUsers.AdministratorSearchUsersState;
import es.ulpgc.montesdeoca110.cristina.zonget.app.PetsItem;


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

        void selectUserPetsData(PetsItem item);

        void onClickAddButton();

        String getActualThemeName();
    }

    interface Model {
        List<PetsItem> fetchPetsData();
    }

    interface Router {
        void navigateToPetsDetailScreen();

        void passDataToPetsDetailScreen(PetsItem item);

        AdministratorUsersPetsListState getDataFromPreviousScreen();

        void navigateToAddScreen();

        String getActualThemeName();
    }
}
