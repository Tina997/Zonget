package es.ulpgc.montesdeoca110.cristina.zonget.AnimalesCliente;

import android.util.Log;

import java.lang.ref.WeakReference;

public class AnimalesClienteListPresenter implements AnimalesClienteListContract.Presenter {

    public static String TAG = AnimalesClienteListPresenter.class.getSimpleName();

    private WeakReference<AnimalesClienteListContract.View> view;
    private AnimalesClienteListViewModel viewModel;
    private AnimalesClienteListContract.Model model;
    private AnimalesClienteListContract.Router router;

    public AnimalesClienteListPresenter(AnimalesClienteListState state) {
        viewModel = state;
    }

    @Override
    public void injectView(WeakReference<AnimalesClienteListContract.View> view) {
        this.view = view;
    }

    @Override
    public void injectModel(AnimalesClienteListContract.Model model) {
        this.model = model;
    }

    @Override
    public void injectRouter(AnimalesClienteListContract.Router router) {
        this.router = router;
    }

    @Override
    public void fetchData() {
        // Log.e(TAG, "fetchData()");

        // set passed state
        AnimalesClienteListState state = router.getDataFromPreviousScreen();
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
