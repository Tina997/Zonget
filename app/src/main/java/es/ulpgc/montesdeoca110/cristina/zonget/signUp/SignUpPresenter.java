package es.ulpgc.montesdeoca110.cristina.zonget.signUp;

import android.view.View;

import java.lang.ref.WeakReference;

import es.ulpgc.montesdeoca110.cristina.zonget.R;

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
    public void updateAccountPasswordEditText(String accountPassword) {
        viewModel.accountPassword = accountPassword;
    }

    @Override
    public void updateAccountSecondPasswordEditText(String accountSecondPassword) {
        viewModel.accountSecondPassword = accountSecondPassword;
    }

    @Override
    public void checkPasswords() {
        if(viewModel.accountPassword.equals(viewModel.accountSecondPassword)){
            viewModel.correctPasswordsImageView = R.drawable.ic_correct;
        }else{
            viewModel.correctPasswordsImageView = R.drawable.ic_incorrect;
        }
        viewModel.correctPasswordsImageViewVisibility = View.VISIBLE;
        view.get().displaySignUpData(viewModel);

    }

    @Override
    public void fetchSignUpData() {

        SignUpState state = router.getSignUpState();
        if (state != null) {
            viewModel.accountName = state.accountName;
            viewModel.accountDni = state.accountDni;
            viewModel.accountEmail = state.accountEmail;
            viewModel.accountPassword = state.accountPassword;
            viewModel.accountSecondPassword = state.accountSecondPassword;

            viewModel.correctPasswordsImageView = state.correctPasswordsImageView;
            viewModel.correctPasswordsImageViewVisibility = state.correctPasswordsImageViewVisibility;
        } else {
            // Inital state
            viewModel.accountName = "";
            viewModel.accountDni = "";
            viewModel.accountEmail = "";
            viewModel.accountPassword = "";
            viewModel.accountSecondPassword = "";

            viewModel.correctPasswordsImageView = R.drawable.ic_incorrect;
            viewModel.correctPasswordsImageViewVisibility = View.INVISIBLE;

        }
        view.get().displaySignUpData(viewModel);
    }

    @Override
    public void saveSignUpState() {

    }

    @Override
    public void confirmedButtonPressed() {

    }

}
