package es.ulpgc.montesdeoca110.cristina.zonget.administratorUsersPetDetail;



import java.lang.ref.WeakReference;

import es.ulpgc.montesdeoca110.cristina.zonget.R;

import es.ulpgc.montesdeoca110.cristina.zonget.app.PetsItem;

public class AdministratorUserPetsDetailPresenter implements AdministratorUserPetsDetailContract.Presenter {

    public static String TAG = AdministratorUserPetsDetailPresenter.class.getSimpleName();

    private WeakReference<AdministratorUserPetsDetailContract.View> view;
    private AdministratorUserPetsDetailViewModel viewModel;
    private AdministratorUserPetsDetailContract.Model model;
    private AdministratorUserPetsDetailContract.Router router;

    public AdministratorUserPetsDetailPresenter(AdministratorUserPetsDetailState state) {
        viewModel = state;
    }

    @Override
    public void injectView(WeakReference<AdministratorUserPetsDetailContract.View> view) {
        this.view = view;
    }

    @Override
    public void injectModel(AdministratorUserPetsDetailContract.Model model) {
        this.model = model;
    }

    @Override
    public void injectRouter(AdministratorUserPetsDetailContract.Router router) {
        this.router = router;
    }

    @Override
    public void fetchData() {
        // Log.e(TAG, "fetchData()");

        // set passed state
        PetsItem animal = router.getDataFromPreviousScreen();
        if(animal != null){
            viewModel.pet = animal;
        }

        // update the view
        view.get().displayData(viewModel);

    }

    @Override
    public void onEditButtonClicked() {
        router.navigateToEditScreen();
    }

    @Override
    public void onDeleteButtonClicked() {
        router.navigateToPetListScreen();
    }


}
