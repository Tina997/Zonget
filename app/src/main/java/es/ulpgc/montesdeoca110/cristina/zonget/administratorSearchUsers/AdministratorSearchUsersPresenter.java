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
        // Log.e(TAG, "fetchInboxData()");

        // set passed state
        AdministratorSearchUsersState state = router.getDataFromPreviousScreen();

        // update the view
        view.get().displayData(viewModel);

    }

    @Override
    public void searchButtonClicked(String nameOrDni) {
        AdministratorSearchUsersState state;
        if(nameOrDni!=null){
            state = new AdministratorSearchUsersState();
        }else {
            state = new AdministratorSearchUsersState();
        }
        router.passDataToNextScreen(state);
        router.navigateToNextScreen();
    }

    @Override
    public String getActualThemeName() {
        return router.getActualThemeName();
    }

    @Override
    public void onBackButtonPressed() {
        router.onBackButtonPressed();
    }


}
