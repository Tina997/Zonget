package es.ulpgc.montesdeoca110.cristina.zonget.lostPetsDetail;

import android.util.Log;

import java.lang.ref.WeakReference;

public class LostPetsDetailPresenter implements LostPetsDetailContract.Presenter {

    public static String TAG = LostPetsDetailPresenter.class.getSimpleName();

    private WeakReference<LostPetsDetailContract.View> view;
    private LostPetsDetailViewModel viewModel;
    private LostPetsDetailContract.Model model;
    private LostPetsDetailContract.Router router;

    public LostPetsDetailPresenter(LostPetsDetailState state) {
        viewModel = state;
    }

    @Override
    public void injectView(WeakReference<LostPetsDetailContract.View> view) {
        this.view = view;
    }

    @Override
    public void injectModel(LostPetsDetailContract.Model model) {
        this.model = model;
    }

    @Override
    public void injectRouter(LostPetsDetailContract.Router router) {
        this.router = router;
    }

    @Override
    public void fetchData() {
        // Log.e(TAG, "fetchData()");

        // set passed state
        // update the view
        view.get().displayData(viewModel);

    }


}
