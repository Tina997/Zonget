package es.ulpgc.montesdeoca110.cristina.zonget.AnimalesCliente;

import java.lang.ref.WeakReference;
import java.util.List;

import es.ulpgc.montesdeoca110.cristina.zonget.App.AnimalClientesItem;

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
    }

    interface Model {
        List<AnimalClientesItem> fetchAnimalesListData();
    }

    interface Router {
        void navigateToNextScreen();

        void passDataToNextScreen(AnimalesClienteListState state);

        AnimalesClienteListState getDataFromPreviousScreen();
    }
}
