package es.ulpgc.montesdeoca110.cristina.zonget.clientPets;

import java.lang.ref.WeakReference;

import es.ulpgc.montesdeoca110.cristina.zonget.app.AnimalClientesItem;

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
        // Log.e(TAG, "fetchDateListData()");
        viewModel.animales = model.fetchAnimalesListData();
        view.get().displayAnimalesListData(viewModel);
    }

    @Override
    public void selectAnimalListData(AnimalClientesItem item) {
        router.passDataToAnimalDetailScreen(item);
        router.navigateToAnimalDetailScreen();
    }

}
