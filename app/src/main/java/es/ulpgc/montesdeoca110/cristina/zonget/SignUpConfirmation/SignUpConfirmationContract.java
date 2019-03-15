package es.ulpgc.montesdeoca110.cristina.zonget.SignUpConfirmation;

import java.lang.ref.WeakReference;

interface SignUpConfirmationContract {

    interface View {
        void injectPresenter(Presenter presenter);

        void displayData(SignUpConfirmationViewModel viewModel);
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

        void passDataToNextScreen(SignUpConfirmationState state);

        SignUpConfirmationState getDataFromPreviousScreen();
    }
}
