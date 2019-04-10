package es.ulpgc.montesdeoca110.cristina.zonget.signUp;

import java.lang.ref.WeakReference;

import es.ulpgc.montesdeoca110.cristina.zonget.app.AccountItem;
import es.ulpgc.montesdeoca110.cristina.zonget.app.SignUpToSignUpConfirmationState;
import es.ulpgc.montesdeoca110.cristina.zonget.data.RepositoryContract;

interface SignUpContract {

    interface View {

        void injectPresenter(Presenter presenter);

        void displaySignUpData(SignUpViewModel viewModel);

        void displayInsertNewAccountMesaje(String mesaje);
    }

    interface Presenter {

        void injectView(WeakReference<View> view);

        void injectModel(Model model);

        void injectRouter(Router router);

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

        void confirmedButtonPressed();

    }

    interface Model {

        void checkNewAccount(String accountDni, String accountEmail, RepositoryContract.Accounts.CheckNewAccountDataExistCallback callback);

        void insertNewAccount(AccountItem account, RepositoryContract.Accounts.InsertNewAccountCallback callback);

    }

    interface Router {

        void setSignUpState(SignUpState state);

        //--------------- Navegación entre pantallas -----------

        void navigateToSinInScreen();

        void navigateToSignUpConfirmationScreen();

        //------------- Paso de datos entre pantallas ----------

        void passDataSignUpConfirmationScreen(SignUpToSignUpConfirmationState state);

        //------------- Obtener datos entre pantallas ----------

    }
}
