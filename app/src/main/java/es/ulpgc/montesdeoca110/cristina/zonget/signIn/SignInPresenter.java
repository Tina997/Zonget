package es.ulpgc.montesdeoca110.cristina.zonget.signIn;

import java.lang.ref.WeakReference;

import es.ulpgc.montesdeoca110.cristina.zonget.app.SignInToMenuState;

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
    public void signInButtonPressed(String accountName, String accountPassword) {
        if(model.checkAccount(accountName, accountPassword)){
            String[] accountInfo = model.getAccountInfo();
            SignInToMenuState state = new SignInToMenuState(accountInfo[0], accountInfo[1]);
            router.passDataToMenuScreen(state);
            router.navigateToMenuScreen();
        } else {
            view.get().displayCheckAccountError();
        }
    }

    @Override
    public void signUpButtonPressed() {
        router.navigateToSignUpScreen();
    }

    @Override
    public void askDateButtonPressed() {

    }


}
