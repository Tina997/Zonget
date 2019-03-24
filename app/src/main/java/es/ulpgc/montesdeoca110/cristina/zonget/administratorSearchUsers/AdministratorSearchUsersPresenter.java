package es.ulpgc.montesdeoca110.cristina.zonget.administratorSearchUsers;

import java.lang.ref.WeakReference;

public class AdministratorSearchUsersPresenter implements AdministratorSearchUsersContract.Presenter {

    public static String TAG = AdministratorSearchUsersPresenter.class.getSimpleName();

    private WeakReference<AdministratorSearchUsersContract.View> view;
    private AdministratorSearchUsersViewModel viewModel;
    private AdministratorSearchUsersContract.Model model;
    private AdministratorSearchUsersContract.Router router;

    public AdministratorSearchUsersPresenter(AdministratorSearchUsersState state) {
        viewModel = state;
    }

    @Override
    public void injectView(WeakReference<AdministratorSearchUsersContract.View> view) {
        this.view = view;
    }

    @Override
    public void injectModel(AdministratorSearchUsersContract.Model model) {
        this.model = model;
    }

    @Override
    public void injectRouter(AdministratorSearchUsersContract.Router router) {
        this.router = router;
    }

    @Override
    public void fetchData() {
        // Log.e(TAG, "fetchData()");

        // set passed state
        AdministratorSearchUsersState state = router.getDataFromPreviousScreen();
        /*if (state != null) {
            viewModel.data = state.data;
        }

        if (viewModel.data == null) {
            // call the model
            String data = model.fetchData();

            // set initial state
            viewModel.data = data;
        }*/

        // update the view
        view.get().displayData(viewModel);

    }

    @Override
    public void searchButtonClicked(String nameOrDni) {
        AdministratorSearchUsersState state;
        if(nameOrDni!=null){
            state = new AdministratorSearchUsersState(nameOrDni);
        }else {
            state = new AdministratorSearchUsersState(viewModel.dataSearched);
        }
        router.passDataToNextScreen(state);
        router.navigateToNextScreen();
    }


}
