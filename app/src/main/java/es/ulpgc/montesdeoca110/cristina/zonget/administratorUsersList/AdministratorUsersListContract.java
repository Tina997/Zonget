package es.ulpgc.montesdeoca110.cristina.zonget.administratorUsersList;

import java.lang.ref.WeakReference;
import java.util.List;

import es.ulpgc.montesdeoca110.cristina.zonget.app.PetsItem;
import es.ulpgc.montesdeoca110.cristina.zonget.app.UserItem;
import es.ulpgc.montesdeoca110.cristina.zonget.data.RepositoryContract;

interface AdministratorUsersListContract {

    interface View {
        void injectPresenter(Presenter presenter);

        void displayData(AdministratorUsersListViewModel viewModel);
    }

    interface Presenter {
        void injectView(WeakReference<View> view);

        void injectModel(Model model);

        void injectRouter(Router router);

        void fetchAdminUsersData();

        void selectAdminUserData(UserItem userItem);

        String getActualThemeName();

        void onBackButtonPressed();
    }

    interface Model {
        void fetchUsersData(RepositoryContract.Users.GetUsersListCallback callback);
    }

    interface Router {

        AdministratorUsersListState getDataFromPreviousScreen();

        void passDataToUserDetailScreen(UserItem item);

        void navigateToUserDetailScreen();

        String getActualThemeName();

        void onBackButtonPressed();
    }
}
