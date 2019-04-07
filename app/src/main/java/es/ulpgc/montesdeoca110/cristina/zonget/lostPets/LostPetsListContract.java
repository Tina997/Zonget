package es.ulpgc.montesdeoca110.cristina.zonget.lostPets;

import java.lang.ref.WeakReference;

import es.ulpgc.montesdeoca110.cristina.zonget.app.LostPetItem;
import es.ulpgc.montesdeoca110.cristina.zonget.data.RepositoryContract;

interface LostPetsListContract {

    interface View {
        void injectPresenter(Presenter presenter);

        void displayLostPetsListData(LostPetsListViewModel viewModel);
    }

    interface Presenter {
        void injectView(WeakReference<View> view);

        void injectModel(Model model);

        void injectRouter(Router router);

        void fetchLostPetsListData();

        void selectPet(LostPetItem petItem);
    }

    interface Model {
        void fetchLostPetsListData(RepositoryContract.LostPets.GetLostPetsListCallback callback);
    }

    interface Router {
        void navigateToNextScreen();

        void passDataToDetailScreen(LostPetItem lostPetItem);

        LostPetsListState getDataFromPreviousScreen();
    }
}
