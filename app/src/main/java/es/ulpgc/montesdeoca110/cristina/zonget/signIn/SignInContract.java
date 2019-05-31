package es.ulpgc.montesdeoca110.cristina.zonget.signIn;

import java.lang.ref.WeakReference;

import es.ulpgc.montesdeoca110.cristina.zonget.app.statesBetweenActivities.SignInToMenuState;
import es.ulpgc.montesdeoca110.cristina.zonget.app.statesBetweenActivities.SplashToSignInState;
import es.ulpgc.montesdeoca110.cristina.zonget.data.RepositoryContract;

public interface SignInContract {

    interface View {

        /**
         * Metodo que inicializa el presentador asociado a la vista
         * @param presenter: El presentador de la vista
         */
        void injectPresenter(Presenter presenter);

        void displaySignInData(SignInViewModel viewModel);

        void displayCheckAccountError();

        void finish();

    }

    interface Presenter {

        /**
         * Método que inicializa la vista asociado a ese presentador
         * @param view: La vista a iniciar
         */
        void injectView(WeakReference<View> view);

        /**
         * Metodo que inicializa el modelo asociado al presentador
         * @param model: El modelo a iniciar
         */
        void injectModel(Model model);

        /**
         * Metodo que incializa el router asociado al presentador
         * @param router: El router a iniciar
         */
        void injectRouter(Router router);

        /**
         * Metodo que devuelve el tema actual que esta siendo usado en ese momento
         * @return String con el nombre del tema que esta siendo usado
         */
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

        /**
         * Metodo que devuelve el nombre del tema actual que esta siendo utilizado
         * @return string con el nombre  del tema que se esta siendo utilizado
         */
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
