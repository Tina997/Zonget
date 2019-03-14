package es.ulpgc.montesdeoca110.cristina.zonget.AnimalesCliente;

import java.lang.ref.WeakReference;

interface AnimalesClienteListContract {

    interface View {
        void injectPresenter(Presenter presenter);

        void displayData(AnimalesClienteListViewModel viewModel);
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

        void passDataToNextScreen(AnimalesClienteListState state);

        AnimalesClienteListState getDataFromPreviousScreen();
    }
}
