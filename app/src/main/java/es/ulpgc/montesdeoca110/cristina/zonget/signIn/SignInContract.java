package es.ulpgc.montesdeoca110.cristina.zonget.signIn;

import java.lang.ref.WeakReference;

import es.ulpgc.montesdeoca110.cristina.zonget.app.AccountItem;
import es.ulpgc.montesdeoca110.cristina.zonget.app.SignInToMenuState;

interface SignInContract {

    interface View {
        void injectPresenter(Presenter presenter);

        void displayData(SignInViewModel viewModel);

        void displayCheckAccountError();
    }

    interface Presenter {
        void injectView(WeakReference<View> view);

        void injectModel(Model model);

        void injectRouter(Router router);

        void fetchData();

        void forgetPasswordPressed();

        void signInButtonPressed(String accountName, String accountPassword);

        void signUpButtonPressed();

        void askDateButtonPressed();
    }

    interface Model {
        String fetchData();

        boolean checkAccount(String accountName, String accountPassword);

        AccountItem getAccountInfo(String accountName, String accountPassword);
    }

    interface Router {

        //--------------- Navegación entre pantallas -----------

        void navigateToMenuScreen();

        void navigateToSignUpScreen();

        void navigateToPickDateScreen();

        //------------- Paso de datos entre pantallas ----------

        void passDataToMenuScreen(SignInToMenuState state);

        SignInState getDataFromPreviousScreen();

    }
}
