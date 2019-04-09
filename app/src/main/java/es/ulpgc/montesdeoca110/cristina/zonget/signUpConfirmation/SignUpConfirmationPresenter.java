package es.ulpgc.montesdeoca110.cristina.zonget.signUpConfirmation;

import java.lang.ref.WeakReference;

import es.ulpgc.montesdeoca110.cristina.zonget.app.SignUpToSignUpConfirmationState;

public class SignUpConfirmationPresenter implements SignUpConfirmationContract.Presenter {

    private WeakReference<SignUpConfirmationContract.View> view;
    private SignUpConfirmationViewModel viewModel;
    private SignUpConfirmationContract.Model model;
    private SignUpConfirmationContract.Router router;

    public SignUpConfirmationPresenter(SignUpConfirmationState state) {
        viewModel = state;
    }

    @Override
    public void injectView(WeakReference<SignUpConfirmationContract.View> view) {
        this.view = view;
    }

    @Override
    public void injectModel(SignUpConfirmationContract.Model model) {
        this.model = model;
    }

    @Override
    public void injectRouter(SignUpConfirmationContract.Router router) {
        this.router = router;
    }

    @Override
    public void backButtonPressed() {
        router.navigateToSignInScreen();
    }

    @Override
    public void fetchSignUpConfirmationData() {

        // Obtenermos el estado de la anterior pantalla
        SignUpToSignUpConfirmationState state = router.getDataSignUpScreen();
        if (state != null) {

        }

    }


}
