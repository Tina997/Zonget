package es.ulpgc.montesdeoca110.cristina.zonget.modifyEvent;

import java.lang.ref.WeakReference;

public class ModifyEventPresenter implements ModifyEventContract.Presenter {

    public static String TAG = ModifyEventPresenter.class.getSimpleName();

    private WeakReference<ModifyEventContract.View> view;
    private ModifyEventViewModel viewModel;
    private ModifyEventContract.Model model;
    private ModifyEventContract.Router router;

    public ModifyEventPresenter(ModifyEventState state) {
        viewModel = state;
    }

    @Override
    public void injectView(WeakReference<ModifyEventContract.View> view) {
        this.view = view;
    }

    @Override
    public void injectModel(ModifyEventContract.Model model) {
        this.model = model;
    }

    @Override
    public void injectRouter(ModifyEventContract.Router router) {
        this.router = router;
    }

    @Override
    public void fetchData() {
        // Log.e(TAG, "fetchDateListData()");

        // set passed state
        ModifyEventState state = router.getDataFromPreviousScreen();
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

    @Override
    public String getActualThemeName() {
        return router.getActualThemeName();
    }

    @Override
    public void modifyEvent(){
        router.navigateToAdministratorAgendaScreen();
    }

    @Override
    public void navigateToAdministratorAgendaScreen(){ router.navigateToAdministratorAgendaScreen();}


}
