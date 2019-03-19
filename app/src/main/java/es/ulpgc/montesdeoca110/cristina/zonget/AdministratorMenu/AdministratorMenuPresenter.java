package es.ulpgc.montesdeoca110.cristina.zonget.AdministratorMenu;

import android.util.Log;

import java.lang.ref.WeakReference;

public class AdministratorMenuPresenter implements AdministratorMenuContract.Presenter {

    public static String TAG = AdministratorMenuPresenter.class.getSimpleName();

    private WeakReference<AdministratorMenuContract.View> view;
    private AdministratorMenuViewModel viewModel;
    private AdministratorMenuContract.Model model;
    private AdministratorMenuContract.Router router;

    public AdministratorMenuPresenter(AdministratorMenuState state) {
        viewModel = state;
    }

    @Override
    public void injectView(WeakReference<AdministratorMenuContract.View> view) {
        this.view = view;
    }

    @Override
    public void injectModel(AdministratorMenuContract.Model model) {
        this.model = model;
    }

    @Override
    public void injectRouter(AdministratorMenuContract.Router router) {
        this.router = router;
    }

    @Override
    public void fetchData() {
        // Log.e(TAG, "fetchData()");

        // set passed state
        AdministratorMenuState state = router.getDataFromPreviousScreen();
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
