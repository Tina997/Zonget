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
    public void fetchAnimalesListData() {
        // Log.e(TAG, "fetchData()");
        viewModel.animales = model.fetchAnimalesListData();
        view.get().displayAnimalesListData(viewModel);
    }

}
