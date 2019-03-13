package es.ulpgc.montesdeoca110.cristina.zonget.Animal;

import android.util.Log;

import java.lang.ref.WeakReference;

public class AnimalDetailPresenter implements AnimalDetailContract.Presenter {

    public static String TAG = AnimalDetailPresenter.class.getSimpleName();

    private WeakReference<AnimalDetailContract.View> view;
    private AnimalDetailViewModel viewModel;
    private AnimalDetailContract.Model model;
    private AnimalDetailContract.Router router;

    public AnimalDetailPresenter(AnimalDetailState state) {
        viewModel = state;
    }

    @Override
    public void injectView(WeakReference<AnimalDetailContract.View> view) {
        this.view = view;
    }

    @Override
    public void injectModel(AnimalDetailContract.Model model) {
        this.model = model;
    }

    @Override
    public void injectRouter(AnimalDetailContract.Router router) {
        this.router = router;
    }

    @Override
    public void fetchData() {
        // Log.e(TAG, "fetchData()");

        // set passed state
        AnimalDetailState state = router.getDataFromPreviousScreen();
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
