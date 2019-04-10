package es.ulpgc.montesdeoca110.cristina.zonget.addPetForAdoption;

import java.lang.ref.WeakReference;

interface AddPetForAdoptionContract {

    interface View {
        void injectPresenter(Presenter presenter);

        void displayData(AddPetForAdoptionViewModel viewModel);
    }

    interface Presenter {
        void injectView(WeakReference<View> view);

        void injectModel(Model model);

        void injectRouter(Router router);

        void fetchData();
    }

    interface Model {
        String fetchData();
    }

    interface Router {
        void navigateToNextScreen();

        void passDataToNextScreen(AddPetForAdoptionState state);

        AddPetForAdoptionState getDataFromPreviousScreen();
    }
}
