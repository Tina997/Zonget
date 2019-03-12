package es.ulpgc.montesdeoca110.cristina.zonget.SignIn;

import java.lang.ref.WeakReference;

interface SignInContract {

    interface View {
        void injectPresenter(Presenter presenter);

        void displayData(SignInViewModel viewModel);
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

        void passDataToNextScreen(SignInState state);

        SignInState getDataFromPreviousScreen();
    }
}
