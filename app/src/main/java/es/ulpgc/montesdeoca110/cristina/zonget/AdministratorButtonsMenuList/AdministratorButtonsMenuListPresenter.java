package es.ulpgc.montesdeoca110.cristina.zonget.AdministratorButtonsMenuList;

import java.lang.ref.WeakReference;

public class AdministratorButtonsMenuListPresenter implements AdministratorMenuButtonsListContract.Presenter {

    public static String TAG = AdministratorButtonsMenuListPresenter.class.getSimpleName();

    private WeakReference<AdministratorMenuButtonsListContract.View> view;
    private AdministratorButtonsMenuListViewModel viewModel;
    private AdministratorMenuButtonsListContract.Model model;
    private AdministratorMenuButtonsListContract.Router router;

    public AdministratorButtonsMenuListPresenter(AdministratorButtonsMenuListState state) {
        viewModel = state;
    }

    @Override
    public void injectView(WeakReference<AdministratorMenuButtonsListContract.View> view) {
        this.view = view;
    }

    @Override
    public void injectModel(AdministratorMenuButtonsListContract.Model model) {
        this.model = model;
    }

    @Override
    public void injectRouter(AdministratorMenuButtonsListContract.Router router) {
        this.router = router;
    }

    @Override
    public void fetchData() {
        // Log.e(TAG, "fetchData()");

        // set passed state
        AdministratorButtonsMenuListState state = router.getDataFromPreviousScreen();
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
