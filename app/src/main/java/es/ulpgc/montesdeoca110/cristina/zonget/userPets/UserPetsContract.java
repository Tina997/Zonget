package es.ulpgc.montesdeoca110.cristina.zonget.userPets;

import java.lang.ref.WeakReference;

import es.ulpgc.montesdeoca110.cristina.zonget.app.AccountItem;
import es.ulpgc.montesdeoca110.cristina.zonget.app.UserPetItem;
import es.ulpgc.montesdeoca110.cristina.zonget.data.RepositoryContract;

public interface UserPetsContract {

    interface View {
        void injectPresenter(Presenter presenter);

        void displayUserPetsData(UserPetsViewModel viewModel);
    }

    interface Presenter {
        void injectView(WeakReference<View> view);

        void injectModel(Model model);

        void injectRouter(Router router);

        void fetchUserPetsData();

        void selectUserPetsData(UserPetItem item);

        String getActualThemeName();

        void onBackButtonPressed();

    }

    interface Model {
        void fetchPetsData(AccountItem item, RepositoryContract.Accounts.GetUserPetsListCallback callback);

       // List<PetsItem> fetchPetsData();
    }

    interface Router {
        void navigateToPetsDetailScreen();

        void passDataToPetsDetailScreen(UserPetItem item);

        UserPetsState getDataFromPreviousScreen();

        String getActualThemeName();

        void onBackButtonPressed();

        AccountItem getDataFromSignIn();
    }
}
