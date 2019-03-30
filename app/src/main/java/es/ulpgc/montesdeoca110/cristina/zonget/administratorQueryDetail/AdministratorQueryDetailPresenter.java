package es.ulpgc.montesdeoca110.cristina.zonget.administratorQueryDetail;

import android.util.Log;

import java.lang.ref.WeakReference;

public class AdministratorQueryDetailPresenter implements AdministratorQueryDetailContract.Presenter {

    public static String TAG = AdministratorQueryDetailPresenter.class.getSimpleName();

    private WeakReference<AdministratorQueryDetailContract.View> view;
    private AdministratorQueryDetailViewModel viewModel;
    private AdministratorQueryDetailContract.Model model;
    private AdministratorQueryDetailContract.Router router;

    public AdministratorQueryDetailPresenter(AdministratorQueryDetailState state) {
        viewModel = state;
    }

    @Override
    public void injectView(WeakReference<AdministratorQueryDetailContract.View> view) {
        this.view = view;
    }

    @Override
    public void injectModel(AdministratorQueryDetailContract.Model model) {
        this.model = model;
    }

    @Override
    public void injectRouter(AdministratorQueryDetailContract.Router router) {
        this.router = router;
    }

    @Override
    public void fetchData() {
        // Log.e(TAG, "fetchData()");

        // set passed state
        AdministratorQueryDetailState state = router.getDataFromPreviousScreen();
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

    @Override
    public void navigateToAdministratorQueryAnswerScreen(){
        router.navigateToAdministratorQueryAnswerScreen();
    }


}
