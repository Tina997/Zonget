package es.ulpgc.montesdeoca110.cristina.zonget.signIn;

import java.lang.ref.WeakReference;

import android.accounts.Account;
import es.ulpgc.montesdeoca110.cristina.zonget.app.AccountItem;
import es.ulpgc.montesdeoca110.cristina.zonget.app.SignInToMenuState;
import es.ulpgc.montesdeoca110.cristina.zonget.data.RepositoryContract;

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

        void pickForADateButtonPressed();
    }

    interface Model {

        void checkAccount(String accountName, String accountPassword, RepositoryContract.Accounts.GetCheckAccountExistCallback callback);

    }

    interface Router {

        //--------------- Navegación entre pantallas -----------

        void navigateToMenuScreen();

        void navigateToSignUpScreen();

        void navigateToUserPickDateScreen();

        //------------- Paso de datos entre pantallas ----------

        void passDataToMenuScreen(SignInToMenuState state);

        //------------- Obtener datos entre pantallas ----------

        SignInState getDataFromSplashScreen();

    }
}
