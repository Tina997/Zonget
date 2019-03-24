package es.ulpgc.montesdeoca110.cristina.zonget.administratorButtonsMenuList;

import java.lang.ref.WeakReference;

import es.ulpgc.montesdeoca110.cristina.zonget.app.AdministratorButtonMenuItem;

public class AdministratorButtonsMenuListPresenter implements AdministratorButtonsMenuListContract.Presenter {

    private WeakReference<AdministratorButtonsMenuListContract.View> view;
    private AdministratorButtonsMenuListViewModel viewModel;
    private AdministratorButtonsMenuListContract.Model model;
    private AdministratorButtonsMenuListContract.Router router;

    public AdministratorButtonsMenuListPresenter(AdministratorButtonsMenuListState state) {
        viewModel = state;
    }

    @Override
    public void injectView(WeakReference<AdministratorButtonsMenuListContract.View> view) {
        this.view = view;
    }

    @Override
    public void injectModel(AdministratorButtonsMenuListContract.Model model) {
        this.model = model;
    }

    @Override
    public void injectRouter(AdministratorButtonsMenuListContract.Router router) {
        this.router = router;
    }

    @Override
    public void fetchAdministratorButtonsMenuListData() {

        //Llamamos al modelo para que nos de la información
        viewModel.administrator_buttons = model.fetchAdministratorButtonsMenuListData();

        // Actualizamos la vista
        view.get().displayAdministratorButtonsMenuListData(viewModel);

    }

    @Override
    public void selectAdministratorButtonsMenuListData(AdministratorButtonMenuItem item) {
        //router.passDataToProductListScreen(item);
        //router.navigateToProductListScreen();
    }


}
