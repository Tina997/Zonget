package es.ulpgc.montesdeoca110.cristina.zonget.signIn;

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

        void signInButtonPressed();

        void signUpButtonPressed();

        void askDateButtonPressed();
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
