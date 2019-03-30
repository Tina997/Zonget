package es.ulpgc.montesdeoca110.cristina.zonget.lostPets;

import java.lang.ref.WeakReference;

public class LostPetsListPresenter implements LostPetsListContract.Presenter {

    public static String TAG = LostPetsListPresenter.class.getSimpleName();

    private WeakReference<LostPetsListContract.View> view;
    private LostPetsListViewModel viewModel;
    private LostPetsListContract.Model model;
    private LostPetsListContract.Router router;

    public LostPetsListPresenter(LostPetsListState state) {
        viewModel = state;
    }

    @Override
    public void injectView(WeakReference<LostPetsListContract.View> view) {
        this.view = view;
    }

    @Override
    public void injectModel(LostPetsListContract.Model model) {
        this.model = model;
    }

    @Override
    public void injectRouter(LostPetsListContract.Router router) {
        this.router = router;
    }

    @Override
    public void fetchData() {
        // Log.e(TAG, "fetchData()");

        // set passed state
        LostPetsListState state = router.getDataFromPreviousScreen();
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
