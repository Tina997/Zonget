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
        // Log.e(TAG, "fetchPetsForAdoptionListData()");

        // set passed state

        // update the view
        view.get().displayData(viewModel);

    }

    @Override
    public void insertNewPet() {
        router.navigateToNextScreen();
    }

    @Override
    public String getActualThemeName() {
        return router.getActualThemeName();
    }


}
