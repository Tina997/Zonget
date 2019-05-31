package es.ulpgc.montesdeoca110.cristina.zonget.signUp;

import java.lang.ref.WeakReference;

import es.ulpgc.montesdeoca110.cristina.zonget.app.AccountItem;
import es.ulpgc.montesdeoca110.cristina.zonget.app.statesBetweenActivities.SignUpToSignUpConfirmationState;
import es.ulpgc.montesdeoca110.cristina.zonget.data.RepositoryContract;

public interface SignUpContract {

    interface View {

        /**
         * Metodo que inicializa el presentador asociado a la vista
         * @param presenter: El presentador de la vista
         */
        void injectPresenter(Presenter presenter);

        void displaySignUpData(SignUpViewModel viewModel);

        void displayAlertMesaje(String mesaje);

        void displayInsertNewAccountMesaje(String mesaje);

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

        void updateAccountNameEditText(String accountName);

        void updateAccountDniEditText(String accountDni);

        void updateAccountEmailEditText(String accountEmail);

        void updateAccountSecondEmailEditText(String accountSecondEmail);

        void checkEmails();

        void updateAccountPasswordEditText(String accountPassword);

        void updateAccountSecondPasswordEditText(String accountSecondPassword);

        void checkPasswords();

        void fetchSignUpData();

        boolean checkAllDataIntroduced();

        void confirmedButtonPressed();

        void saveSignUpState();
    }

    interface Model {

        void checkNewAccount(String accountDni, String accountEmail, RepositoryContract.Accounts.CheckNewAccountDataExistCallback callback);

        void insertNewAccount(AccountItem account, RepositoryContract.Accounts.InsertNewAccountCallback callback);

    }

    interface Router {

        void setSignUpState(SignUpState state);

        //------------------------- Tema ---------------------

        /**
         * Metodo que devuelve el nombre del tema actual que esta siendo utilizado
         * @return string con el nombre  del tema que se esta siendo utilizado
         */
        String getActualThemeName();

        //--------------- Navegación entre pantallas -----------

        void navigateToSinInScreen();

        void navigateToSignUpConfirmationScreen();

        //------------- Paso de datos entre pantallas ----------

        void passDataSignUpConfirmationScreen(SignUpToSignUpConfirmationState state);

        //------------- Obtener datos entre pantallas ----------

    }
}
