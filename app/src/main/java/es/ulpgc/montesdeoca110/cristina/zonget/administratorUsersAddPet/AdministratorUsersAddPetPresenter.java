package es.ulpgc.montesdeoca110.cristina.zonget.administratorUsersAddPet;

import android.util.Log;

import java.lang.ref.WeakReference;

public class AdministratorUsersAddPetPresenter implements AdministratorUsersAddPetContract.Presenter {

    public static String TAG = AdministratorUsersAddPetPresenter.class.getSimpleName();

    private WeakReference<AdministratorUsersAddPetContract.View> view;
    private AdministratorUsersAddPetViewModel viewModel;
    private AdministratorUsersAddPetContract.Model model;
    private AdministratorUsersAddPetContract.Router router;

    public AdministratorUsersAddPetPresenter(AdministratorUsersAddPetState state) {
        viewModel = state;
    }

    @Override
    public void injectView(WeakReference<AdministratorUsersAddPetContract.View> view) {
        this.view = view;
    }

    @Override
    public void injectModel(AdministratorUsersAddPetContract.Model model) {
        this.model = model;
    }

    @Override
    public void injectRouter(AdministratorUsersAddPetContract.Router router) {
        this.router = router;
    }

    @Override
    public void fetchData() {
        // Log.e(TAG, "fetchData()");

        // set passed state
        AdministratorUsersAddPetState state = router.getDataFromPreviousScreen();
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
