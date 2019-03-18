package es.ulpgc.montesdeoca110.cristina.zonget.SignUpConfirmation;

import android.util.Log;

import java.lang.ref.WeakReference;

public class SignUpConfirmationPresenter implements SignUpConfirmationContract.Presenter {

    public static String TAG = SignUpConfirmationPresenter.class.getSimpleName();

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
    public void fetchData() {
        // Log.e(TAG, "fetchDateListData()");

        // set passed state
        SignUpConfirmationState state = router.getDataFromPreviousScreen();
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

    }


}
