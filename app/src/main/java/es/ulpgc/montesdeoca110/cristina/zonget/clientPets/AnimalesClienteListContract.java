package es.ulpgc.montesdeoca110.cristina.zonget.clientPets;

import java.lang.ref.WeakReference;
import java.util.List;

import es.ulpgc.montesdeoca110.cristina.zonget.app.AnimalClientesItem;

interface AnimalesClienteListContract {

    interface View {
        void injectPresenter(Presenter presenter);

        void displayAnimalesListData(AnimalesClienteListViewModel viewModel);
    }

    interface Presenter {
        void injectView(WeakReference<View> view);

        void injectModel(Model model);

        void injectRouter(Router router);

        void fetchAnimalesListData();

        void selectAnimalListData(AnimalClientesItem item);
    }

    interface Model {
        List<AnimalClientesItem> fetchAnimalesListData();
    }

    interface Router {
        void navigateToAnimalDetailScreen();

        void passDataToAnimalDetailScreen(AnimalClientesItem state);

        AnimalesClienteListState getDataFromPreviousScreen();
    }
}
