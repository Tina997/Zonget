package es.ulpgc.montesdeoca110.cristina.zonget.clientPetsDetail;

import android.util.Log;

import java.lang.ref.WeakReference;

import es.ulpgc.montesdeoca110.cristina.zonget.app.PetsItem;

public class ClientPetsDetailPresenter implements ClientPetsDetailContract.Presenter {

    public static String TAG = ClientPetsDetailPresenter.class.getSimpleName();

    private WeakReference<ClientPetsDetailContract.View> view;
    private ClientPetsDetailViewModel viewModel;
    private ClientPetsDetailContract.Model model;
    private ClientPetsDetailContract.Router router;

    public ClientPetsDetailPresenter(ClientPetsDetailState state) {
        viewModel = state;
    }

    @Override
    public void injectView(WeakReference<ClientPetsDetailContract.View> view) {
        this.view = view;
    }

    @Override
    public void injectModel(ClientPetsDetailContract.Model model) {
        this.model = model;
    }

    @Override
    public void injectRouter(ClientPetsDetailContract.Router router) {
        this.router = router;
    }

    @Override
    public void fetchPetsData() {
        // Log.e(TAG, "fetchData()");

        // set passed state
        PetsItem animal = router.getDataFromPreviousScreen();
        if(animal != null){
            viewModel.pet = animal;
        }

        // update the view
        view.get().displayData(viewModel);

    }


}
