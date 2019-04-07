package es.ulpgc.montesdeoca110.cristina.zonget.signUp;

import java.lang.ref.WeakReference;

import es.ulpgc.montesdeoca110.cristina.zonget.app.SignUpToSignUpConfirmed;
import es.ulpgc.montesdeoca110.cristina.zonget.data.RepositoryContract;

interface SignUpContract {

    interface View {

        void injectPresenter(Presenter presenter);

        void displaySignUpData(SignUpViewModel viewModel);
    }

    interface Presenter {

        void injectView(WeakReference<View> view);

        void injectModel(Model model);

        void injectRouter(Router router);

        void updateAccountNameEditText(String accountName);

        void updateAccountDniEditText(String accountDni);

        void updateAccountEmailEditText(String accountEmail);

        void updateAccountPasswordEditText(String accountPassword);

        void updateAccountSecondPasswordEditText(String accountSecondPassword);

        void checkPasswords();

        void fetchSignUpData();

        void confirmedButtonPressed();

    }

    interface Model {

        void checkAccount(String accountDni, String accountEmail, RepositoryContract.Accounts.GetCheckAccountExistCallback callback);

    }

    interface Router {

        void setSignUpState(SignUpState state);

        //--------------- Navegación entre pantallas -----------

        void navigateSignUpConfirmationScreen();

        //------------- Paso de datos entre pantallas ----------

        void passDataSignUpConfirmationScreen(SignUpToSignUpConfirmed state);

        //------------- Obtener datos entre pantallas ----------

    }
}
