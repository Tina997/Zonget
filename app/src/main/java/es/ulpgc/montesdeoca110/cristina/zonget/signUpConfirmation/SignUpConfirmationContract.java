package es.ulpgc.montesdeoca110.cristina.zonget.signUpConfirmation;

import android.content.Context;

import java.lang.ref.WeakReference;

import es.ulpgc.montesdeoca110.cristina.zonget.app.statesBetweenActivities.SignUpToSignUpConfirmationState;

interface SignUpConfirmationContract {

    interface View {

        /**
         * Metodo que inicializa el presentador asociado a la vista
         * @param presenter: El presentador de la vista
         */
        void injectPresenter(Presenter presenter);

        void displaySignUpConfirmationData(SignUpConfirmationViewModel viewModel);

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

        void backButtonPressed();

        void fetchSignUpConfirmationData(Context context);

    }

    interface Model {

        void fetchSignUpConfirmationData();

        String getMessage(String accountName, String accountDni);
    }

    interface Router {

        void setSignUpConfirmationState(SignUpConfirmationState state);

        //------------------------- Tema ---------------------

        /**
         * Metodo que devuelve el nombre del tema actual que esta siendo utilizado
         * @return string con el nombre  del tema que se esta siendo utilizado
         */
        String getActualThemeName();

        //--------------- Navegación entre pantallas -----------

        void navigateToSignInScreen();

        //------------- Paso de datos entre pantallas ----------

        void passDataSignInScreen(SignUpConfirmationState state);

        //------------- Obtener datos entre pantallas ----------

        SignUpToSignUpConfirmationState getDataSignUpScreen();
    }
}
