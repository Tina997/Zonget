package es.ulpgc.montesdeoca110.cristina.zonget.changeTheme;

import java.lang.ref.WeakReference;

public class ChangeThemePresenter implements ChangeThemeContract.Presenter {

    private WeakReference<ChangeThemeContract.View> view;
    private ChangeThemeViewModel viewModel;
    private ChangeThemeContract.Model model;
    private ChangeThemeContract.Router router;

    public ChangeThemePresenter(ChangeThemeState state) {
        viewModel = state;
    }

    @Override
    public void fetchChangeThemeData() {
        // Log.e(TAG, "fetchData()");

        // use passed state if is necessary
        ChangeThemeState state = router.getDataFromPreviousScreen();
        if (state != null) {

            // update view and model state
            viewModel.data = state.data;

            // update the view
            view.get().displayChangeThemeData(viewModel);

            return;
        }

        // call the model  
        String data = model.fetchChangeThemeData();

        // set view state
        viewModel.data = data;

        // update the view
        view.get().displayChangeThemeData(viewModel);

    }

    @Override
    public void injectView(WeakReference<ChangeThemeContract.View> view) {
        this.view = view;
    }

    @Override
    public void injectModel(ChangeThemeContract.Model model) {
        this.model = model;
    }

    @Override
    public void injectRouter(ChangeThemeContract.Router router) {
        this.router = router;
    }
}
