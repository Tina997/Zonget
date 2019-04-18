package es.ulpgc.montesdeoca110.cristina.zonget.signIn;

import java.lang.ref.WeakReference;

import es.ulpgc.montesdeoca110.cristina.zonget.app.SignInToMenuState;
import es.ulpgc.montesdeoca110.cristina.zonget.app.SplashToSignInState;
import es.ulpgc.montesdeoca110.cristina.zonget.data.RepositoryContract;

interface SignInContract {

    interface View {

        void injectPresenter(Presenter presenter);

        void displaySignInData(SignInViewModel viewModel);

        void displayCheckAccountError();

        void finish();

    }

    interface Presenter {

        void injectView(WeakReference<View> view);

        void injectModel(Model model);

        void injectRouter(Router router);

        String getActualThemeName();

        void fetchSignInData();

        void forgetPasswordPressed();

        void signInButtonPressed(String accountName, String accountPassword);

        void signUpButtonPressed();

        void pickForADateButtonPressed();
    }

    interface Model {

        void checkAccount(String accountName, String accountPassword, RepositoryContract.Accounts.GetCheckAccountExistCallback callback);

    }

    interface Router {

        //------------------------- Tema ---------------------

        String getActualThemeName();

        //--------------- Navegación entre pantallas -----------

        void navigateToMenuScreen();

        void navigateToSignUpScreen();

        void navigateToUserPickDateScreen();

        //------------- Paso de datos entre pantallas ----------

        void passDataToMenuScreen(SignInToMenuState state);

        //------------- Obtener datos entre pantallas ----------

        SplashToSignInState getDataFromSplashScreen();

    }
}
