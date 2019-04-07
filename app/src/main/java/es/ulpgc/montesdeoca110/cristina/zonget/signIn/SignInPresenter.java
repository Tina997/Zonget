package es.ulpgc.montesdeoca110.cristina.zonget.signIn;

import java.lang.ref.WeakReference;

import es.ulpgc.montesdeoca110.cristina.zonget.app.AccountItem;
import es.ulpgc.montesdeoca110.cristina.zonget.app.SignInToMenuState;
import es.ulpgc.montesdeoca110.cristina.zonget.app.SplashToSignInState;
import es.ulpgc.montesdeoca110.cristina.zonget.data.RepositoryContract;

public class SignInPresenter implements SignInContract.Presenter {

    private WeakReference<SignInContract.View> view;
    private SignInViewModel viewModel;
    private SignInContract.Model model;
    private SignInContract.Router router;

    public SignInPresenter(SignInState state) {
        viewModel = state;
    }

    @Override
    public void injectView(WeakReference<SignInContract.View> view) {
        this.view = view;
    }

    @Override
    public void injectModel(SignInContract.Model model) {
        this.model = model;
    }

    @Override
    public void injectRouter(SignInContract.Router router) {
        this.router = router;
    }

    @Override
    public void updateAccountNameEditText(String accountName) {
        viewModel.accountName = accountName;
    }

    @Override
    public void updateAccountPasswordEditText(String accountPassword) {
        viewModel.accountPassword = accountPassword;
    }

    @Override
    public void fetchSignInData() {

        SplashToSignInState state = router.getDataFromSplashScreen();
        if (state != null) {}
    }

    @Override
    public void saveSignInState() {
        SignInState state = new SignInState();
        state.accountName =  viewModel.accountName;
        state.accountPassword = viewModel.accountPassword;

        router.setSignInState(state);
    }

    @Override
    public void forgetPasswordPressed() {
        //TODO Implementar esta opción junto con su activity correspondiente
    }

    @Override
    public void signInButtonPressed(final String accountName, final String accountPassword) {
        model.checkAccount(accountName, accountPassword, new RepositoryContract.Accounts.GetCheckAccountExistCallback() {
            @Override
            public void setCheckAccountExist(boolean exist, AccountItem account) {
                if(exist){
                    SignInToMenuState state = new SignInToMenuState(account);
                    router.passDataToMenuScreen(state);
                    router.navigateToMenuScreen();
                } else{
                    view.get().displayCheckAccountError();
                }
            }
        });
    }


    @Override
    public void signUpButtonPressed() {
        router.navigateToSignUpScreen();
    }

    @Override
    public void pickForADateButtonPressed() {

    }

}
