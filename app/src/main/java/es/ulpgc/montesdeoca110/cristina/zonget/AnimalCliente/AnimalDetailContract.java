package es.ulpgc.montesdeoca110.cristina.zonget.AnimalCliente;

import java.lang.ref.WeakReference;

import es.ulpgc.montesdeoca110.cristina.zonget.App.AnimalClientesItem;

interface AnimalDetailContract {

    interface View {
        void injectPresenter(Presenter presenter);

        void displayData(AnimalDetailViewModel viewModel);
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

        void passDataToNextScreen(AnimalDetailState state);

        AnimalClientesItem getDataFromPreviousScreen();
    }
}
