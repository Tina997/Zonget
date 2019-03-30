package es.ulpgc.montesdeoca110.cristina.zonget.signIn;

import java.lang.ref.WeakReference;

import es.ulpgc.montesdeoca110.cristina.zonget.app.AccountItem;
import es.ulpgc.montesdeoca110.cristina.zonget.app.SignInToMenuState;
import es.ulpgc.montesdeoca110.cristina.zonget.data.RepositoryContract;

public class SignInPresenter implements SignInContract.Presenter {

    public static String TAG = SignInPresenter.class.getSimpleName();

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
    public void fetchData() {
        // Log.e(TAG, "fetchDateListData()");

        // set passed state
        /*SignInState state = router.getDataFromPreviousScreen();
        if (state != null) {
            viewModel.data = state.data;
        }

        if (viewModel.data == null) {
            // call the model
            String data = model.fetchData();

            // set initial state
            viewModel.data = data;
        }

        // update the view
        view.get().displayData(viewModel);
        */

    }

    @Override
    public void forgetPasswordPressed() {

    }

    @Override
    public void signInButtonPressed(final String accountName, final String accountPassword) {
        model.checkAccount(accountName, accountPassword, new RepositoryContract.Accounts.CheckAccountExistCallback() {
            @Override
            public void onCheckAccountExist(boolean exist, AccountItem account) {
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
    public void askDateButtonPressed() {
        //Todo decidir nombre final
    }

}
