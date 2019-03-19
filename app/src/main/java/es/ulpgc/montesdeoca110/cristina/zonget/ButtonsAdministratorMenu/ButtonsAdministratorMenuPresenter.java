package es.ulpgc.montesdeoca110.cristina.zonget.ButtonsAdministratorMenu;

import java.lang.ref.WeakReference;

public class ButtonsAdministratorMenuPresenter implements ButtonsAdministratorMenuContract.Presenter {

    public static String TAG = ButtonsAdministratorMenuPresenter.class.getSimpleName();

    private WeakReference<ButtonsAdministratorMenuContract.View> view;
    private ButtonsAdministratorMenuViewModel viewModel;
    private ButtonsAdministratorMenuContract.Model model;
    private ButtonsAdministratorMenuContract.Router router;

    public ButtonsAdministratorMenuPresenter(ButtonsAdministratorMenuState state) {
        viewModel = state;
    }

    @Override
    public void injectView(WeakReference<ButtonsAdministratorMenuContract.View> view) {
        this.view = view;
    }

    @Override
    public void injectModel(ButtonsAdministratorMenuContract.Model model) {
        this.model = model;
    }

    @Override
    public void injectRouter(ButtonsAdministratorMenuContract.Router router) {
        this.router = router;
    }

    @Override
    public void fetchData() {
        // Log.e(TAG, "fetchData()");

        // set passed state
        ButtonsAdministratorMenuState state = router.getDataFromPreviousScreen();
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
