package es.ulpgc.montesdeoca110.cristina.zonget.petsForAdoption;

import java.lang.ref.WeakReference;

import es.ulpgc.montesdeoca110.cristina.zonget.app.PetForAdoptionItem;
import es.ulpgc.montesdeoca110.cristina.zonget.data.RepositoryContract;

interface PetsForAdoptionContract {

    interface View {
        void injectPresenter(Presenter presenter);

        void displayData(PetsForAdoptionViewModel viewModel);
    }

    interface Presenter {
        void injectView(WeakReference<View> view);

        void injectModel(Model model);

        void injectRouter(Router router);

        void fetchPetsForAdoptionListData();

        void selectPet(PetForAdoptionItem petForAdoptionItem);

        void gotToAddPetForAdoption();

        String getActualThemeName();

        void onBackButtonPressed();
    }

    interface Model {
        void fetchPetsForAdoptionListData(RepositoryContract.PetsForAdoption.GetPetsForAdoptionListCallback callback);
    }

    interface Router {
        void navigateToNextScreen();

        void passDataToDetailScreen(PetForAdoptionItem petsForAdoptionItem);

        PetsForAdoptionState getDataFromPreviousScreen();

        void navigateToAddPetForAdoptionScreen();

        String getActualThemeName();

        void onBackButtonPressed();
    }
}
