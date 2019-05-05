package es.ulpgc.montesdeoca110.cristina.zonget.administratorUsersList;

import es.ulpgc.montesdeoca110.cristina.zonget.app.UserItem;
import es.ulpgc.montesdeoca110.cristina.zonget.data.RepositoryContract;
import java.lang.ref.WeakReference;

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
