package es.ulpgc.montesdeoca110.cristina.zonget.administratorUsersList;

import java.lang.ref.WeakReference;

import es.ulpgc.montesdeoca110.cristina.zonget.app.AccountItem;
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

        void selectAdminUserData(AccountItem userItem);

        String getActualThemeName();

        void onBackButtonPressed();
    }

    interface Model {
        void fetchUsersData(RepositoryContract.Accounts callback);
    }

    interface Router {

        AdministratorUsersListState getDataFromPreviousScreen();

        void passDataToUserDetailScreen(AccountItem item);

        void navigateToUserDetailScreen();

        String getActualThemeName();

        void onBackButtonPressed();
    }
}
