package es.ulpgc.montesdeoca110.cristina.zonget.petsForAdoptionDetail;

import android.util.Log;

import java.lang.ref.WeakReference;

public class PetsForAdoptionDetailPresenter implements PetsForAdoptionDetailContract.Presenter {

    public static String TAG = PetsForAdoptionDetailPresenter.class.getSimpleName();

    private WeakReference<PetsForAdoptionDetailContract.View> view;
    private PetsForAdoptionDetailViewModel viewModel;
    private PetsForAdoptionDetailContract.Model model;
    private PetsForAdoptionDetailContract.Router router;

    public PetsForAdoptionDetailPresenter(PetsForAdoptionDetailState state) {
        viewModel = state;
    }

    @Override
    public void injectView(WeakReference<PetsForAdoptionDetailContract.View> view) {
        this.view = view;
    }

    @Override
    public void injectModel(PetsForAdoptionDetailContract.Model model) {
        this.model = model;
    }

    @Override
    public void injectRouter(PetsForAdoptionDetailContract.Router router) {
        this.router = router;
    }

    @Override
    public void fetchData() {
        // Log.e(TAG, "fetchData()");

        // set passed state
        PetsForAdoptionDetailState state = router.getDataFromPreviousScreen();
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
