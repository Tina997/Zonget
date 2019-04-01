package es.ulpgc.montesdeoca110.cristina.zonget.petsForAdoption;

import android.util.Log;

import java.lang.ref.WeakReference;

public class PetsForAdoptionPresenter implements PetsForAdoptionContract.Presenter {

    public static String TAG = PetsForAdoptionPresenter.class.getSimpleName();

    private WeakReference<PetsForAdoptionContract.View> view;
    private PetsForAdoptionViewModel viewModel;
    private PetsForAdoptionContract.Model model;
    private PetsForAdoptionContract.Router router;

    public PetsForAdoptionPresenter(PetsForAdoptionState state) {
        viewModel = state;
    }

    @Override
    public void injectView(WeakReference<PetsForAdoptionContract.View> view) {
        this.view = view;
    }

    @Override
    public void injectModel(PetsForAdoptionContract.Model model) {
        this.model = model;
    }

    @Override
    public void injectRouter(PetsForAdoptionContract.Router router) {
        this.router = router;
    }

    @Override
    public void fetchData() {
        // Log.e(TAG, "fetchData()");

        // set passed state
        PetsForAdoptionState state = router.getDataFromPreviousScreen();
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
