package es.ulpgc.montesdeoca110.cristina.zonget.signUp;

import android.view.View;

import java.lang.ref.WeakReference;

import es.ulpgc.montesdeoca110.cristina.zonget.R;
import es.ulpgc.montesdeoca110.cristina.zonget.app.AccountItem;
import es.ulpgc.montesdeoca110.cristina.zonget.app.SignUpToSignUpConfirmationState;
import es.ulpgc.montesdeoca110.cristina.zonget.data.RepositoryContract;

public class SignUpPresenter implements SignUpContract.Presenter {

    private WeakReference<SignUpContract.View> view;
    private SignUpViewModel viewModel;
    private SignUpContract.Model model;
    private SignUpContract.Router router;

    public SignUpPresenter(SignUpState state) {
        viewModel = state;
    }

    @Override
    public void injectView(WeakReference<SignUpContract.View> view) {
        this.view = view;
    }

    @Override
    public void injectModel(SignUpContract.Model model) {
        this.model = model;
    }

    @Override
    public void injectRouter(SignUpContract.Router router) {
        this.router = router;
    }

    @Override
    public void backButtonPressed() {
        router.navigateToSinInScreen();
    }

    @Override
    public void updateAccountNameEditText(String accountName) {
        viewModel.accountName = accountName;
    }

    @Override
    public void updateAccountDniEditText(String accountDni) {
        viewModel.accountDni = accountDni;
    }

    @Override
    public void updateAccountEmailEditText(String accountEmail) {
        viewModel.accountEmail = accountEmail;
    }

    @Override
    public void updateAccountSecondEmailEditText(String accountSecondEmail) {
        viewModel.accountSecondEmail = accountSecondEmail;
    }

    @Override
    public void checkEmails() {

        if(viewModel.accountEmail == "" && viewModel.accountSecondEmail == "" ){
            viewModel.correctPasswordsImageViewVisibility = View.INVISIBLE;
        }

        if (viewModel.accountEmail.equals(viewModel.accountSecondEmail)) {
            viewModel.correctEmailsImageView = R.drawable.ic_correct;
        } else {
            viewModel.correctEmailsImageView = R.drawable.ic_incorrect;
        }
        viewModel.correctEmailsImageViewVisibility = View.VISIBLE;
        view.get().displaySignUpData(viewModel);

    }

    @Override
    public void updateAccountPasswordEditText(String accountPassword) {
        viewModel.accountPassword = accountPassword;
    }

    @Override
    public void updateAccountSecondPasswordEditText(String accountSecondPassword) {
        viewModel.accountSecondPassword = accountSecondPassword;
    }

    @Override
    public void checkPasswords() {

        if(viewModel.accountPassword == "" && viewModel.accountSecondPassword == "" ){
            viewModel.correctPasswordsImageViewVisibility = View.INVISIBLE;
        }

        if (viewModel.accountPassword.equals(viewModel.accountSecondPassword)) {
            viewModel.correctPasswordsImageView = R.drawable.ic_correct;
        } else {
            viewModel.correctPasswordsImageView = R.drawable.ic_incorrect;
        }
        viewModel.correctPasswordsImageViewVisibility = View.VISIBLE;
        view.get().displaySignUpData(viewModel);

    }

    @Override
    public void fetchSignUpData() {
        //Todo mejorar, hay un error cuando ya se han introducido datos

        //Inicial state
        viewModel.correctEmailsImageViewVisibility = View.INVISIBLE;
        viewModel.correctPasswordsImageViewVisibility = View.INVISIBLE;

        view.get().displaySignUpData(viewModel);
    }

    @Override
    public void confirmedButtonPressed() {

        model.checkNewAccount(viewModel.accountDni, viewModel.accountEmail, new RepositoryContract.Accounts.CheckNewAccountDataExistCallback() {
            @Override
            public void setNewAccountExistCallBack(boolean exist, int id) {
                if (!exist) {
                    AccountItem account = new AccountItem(id, "user", viewModel.accountName, viewModel.accountDni, viewModel.accountEmail, viewModel.accountPassword);
                    model.insertNewAccount(account, new RepositoryContract.Accounts.InsertNewAccountCallback() {
                        @Override
                        public void onNewAccountInserted() {

                            SignUpToSignUpConfirmationState state = new SignUpToSignUpConfirmationState();
                            state.accountName = viewModel.accountName;
                            state.accountDni = viewModel.accountDni;
                            state.accountEmail = viewModel.accountEmail;

                            router.passDataSignUpConfirmationScreen(state);
                            router.navigateToSignUpConfirmationScreen();

                        }
                    });
                } else {
                    //Todo no se ve
                    view.get().displayInsertNewAccountMesaje("El email y DNI introducidos ya están asociados a una cuenta");
                }
            }
        });

    }

    @Override
    public void saveSignUpState() {
        SignUpState state = new SignUpState();
        state.accountName = viewModel.accountName;
        state.accountDni = viewModel.accountDni;
        state.accountEmail = viewModel.accountEmail;
        state.accountSecondEmail = viewModel.accountSecondEmail;
        state.accountSecondPassword = viewModel.accountSecondPassword;
        state.accountSecondPassword = viewModel.accountSecondPassword;

        state.correctEmailsImageView = viewModel.correctEmailsImageView;
        state.correctEmailsImageViewVisibility = viewModel.correctEmailsImageViewVisibility;
        state.correctPasswordsImageView = viewModel.correctPasswordsImageView;
        state.correctPasswordsImageViewVisibility = viewModel.correctPasswordsImageViewVisibility;

        router.setSignUpState(state);
    }

    @Override
    public boolean checkAllDataIntroduced() {
        if (viewModel.accountName == "" || viewModel.accountDni == "" ||viewModel.accountEmail == "" || viewModel.accountSecondEmail == "" || viewModel.accountPassword == "" || viewModel.accountSecondPassword == "" ) {
            return false;
        }
        return true;
    }

}
