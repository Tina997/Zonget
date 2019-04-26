package es.ulpgc.montesdeoca110.cristina.zonget.userPets;

import java.lang.ref.WeakReference;

import es.ulpgc.montesdeoca110.cristina.zonget.app.PetsItem;

public class UserPetsPresenter implements UserPetsContract.Presenter {

    public static String TAG = UserPetsPresenter.class.getSimpleName();

    private WeakReference<UserPetsContract.View> view;
    private UserPetsViewModel viewModel;
    private UserPetsContract.Model model;
    private UserPetsContract.Router router;

    public UserPetsPresenter(UserPetsState state) {
        viewModel = state;
    }

    @Override
    public void injectView(WeakReference<UserPetsContract.View> view) {
        this.view = view;
    }

    @Override
    public void injectModel(UserPetsContract.Model model) {
        this.model = model;
    }

    @Override
    public void injectRouter(UserPetsContract.Router router) {
        this.router = router;
    }

    @Override
    public void fetchUserPetsData() {
        // Log.e(TAG, "fetchInboxData()");

        // set passed state
        UserPetsState state = router.getDataFromPreviousScreen();
        viewModel.animales = model.fetchPetsData();
        view.get().displayUserPetsData(viewModel);

    }

    @Override
    public void selectUserPetsData(PetsItem item) {
        router.passDataToPetsDetailScreen(item);
        router.navigateToPetsDetailScreen();
    }

    @Override
    public String getActualThemeName() {
        return router.getActualThemeName();
    }


}
