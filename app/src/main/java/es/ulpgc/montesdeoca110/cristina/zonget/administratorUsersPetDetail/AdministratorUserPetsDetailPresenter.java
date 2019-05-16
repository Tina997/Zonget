package es.ulpgc.montesdeoca110.cristina.zonget.administratorUsersPetDetail;



import java.lang.ref.WeakReference;

import es.ulpgc.montesdeoca110.cristina.zonget.R;

import es.ulpgc.montesdeoca110.cristina.zonget.app.PetsItem;
import es.ulpgc.montesdeoca110.cristina.zonget.app.UserPetItem;
import es.ulpgc.montesdeoca110.cristina.zonget.data.RepositoryContract;
import es.ulpgc.montesdeoca110.cristina.zonget.data.RepositoryContract.Accounts;

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
        // Log.e(TAG, "fetchPetsForAdoptionListData()");

        // set passed state
        UserPetItem animal = router.getDataFromPreviousScreen();
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
        model.deletePet(viewModel.pet, new RepositoryContract.Accounts.DeleteUserPetCallback(){

        });
        router.navigateToPetListScreen();
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
