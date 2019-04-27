package es.ulpgc.montesdeoca110.cristina.zonget.addEvent;

import java.lang.ref.WeakReference;

public class AddEventPresenter implements AddEventContract.Presenter {

    public static String TAG = AddEventPresenter.class.getSimpleName();

    private WeakReference<AddEventContract.View> view;
    private AddEventViewModel viewModel;
    private AddEventContract.Model model;
    private AddEventContract.Router router;

    public AddEventPresenter(AddEventState state) {
        viewModel = state;
    }

    @Override
    public void injectView(WeakReference<AddEventContract.View> view) {
        this.view = view;
    }

    @Override
    public void injectModel(AddEventContract.Model model) {
        this.model = model;
    }

    @Override
    public void injectRouter(AddEventContract.Router router) {
        this.router = router;
    }

    @Override
    public void fetchData() {
        // Log.e(TAG, "fetchDateListData()");

        // set passed state
        AddEventState state = router.getDataFromPreviousScreen();
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
    public void onBackButtonPressed() {
        router.onBackButtonPressed();
    }

    @Override
    public void addEvent(){
        router.navigateToAdministratorAgendaScreen();
    }

    @Override
    public void navigateToAdministratorAgendaScreen(){ router.navigateToAdministratorAgendaScreen();}


}
