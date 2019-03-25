package es.ulpgc.montesdeoca110.cristina.zonget.userPetsDetail;

import java.lang.ref.WeakReference;

import es.ulpgc.montesdeoca110.cristina.zonget.app.PetsItem;

public class UserPetsDetailPresenter implements UserPetsDetailContract.Presenter {

    public static String TAG = UserPetsDetailPresenter.class.getSimpleName();

    private WeakReference<UserPetsDetailContract.View> view;
    private UserPetsDetailViewModel viewModel;
    private UserPetsDetailContract.Model model;
    private UserPetsDetailContract.Router router;

    public UserPetsDetailPresenter(UserPetsDetailState state) {
        viewModel = state;
    }

    @Override
    public void injectView(WeakReference<UserPetsDetailContract.View> view) {
        this.view = view;
    }

    @Override
    public void injectModel(UserPetsDetailContract.Model model) {
        this.model = model;
    }

    @Override
    public void injectRouter(UserPetsDetailContract.Router router) {
        this.router = router;
    }

    @Override
    public void fetchPetsData() {
        // Log.e(TAG, "fetchInboxData()");

        // set passed state
        PetsItem animal = router.getDataFromPreviousScreen();
        if(animal != null){
            viewModel.pet = animal;
        }

        // update the view
        view.get().displayData(viewModel);

    }


}
