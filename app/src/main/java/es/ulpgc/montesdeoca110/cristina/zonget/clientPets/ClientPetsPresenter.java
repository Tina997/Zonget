package es.ulpgc.montesdeoca110.cristina.zonget.clientPets;

import android.util.Log;

import java.lang.ref.WeakReference;

import es.ulpgc.montesdeoca110.cristina.zonget.app.PetsItem;

public class ClientPetsPresenter implements ClientPetsContract.Presenter {

    public static String TAG = ClientPetsPresenter.class.getSimpleName();

    private WeakReference<ClientPetsContract.View> view;
    private ClientPetsViewModel viewModel;
    private ClientPetsContract.Model model;
    private ClientPetsContract.Router router;

    public ClientPetsPresenter(ClientPetsState state) {
        viewModel = state;
    }

    @Override
    public void injectView(WeakReference<ClientPetsContract.View> view) {
        this.view = view;
    }

    @Override
    public void injectModel(ClientPetsContract.Model model) {
        this.model = model;
    }

    @Override
    public void injectRouter(ClientPetsContract.Router router) {
        this.router = router;
    }

    @Override
    public void fetchClientPetsData() {
        // Log.e(TAG, "fetchData()");

        // set passed state
        ClientPetsState state = router.getDataFromPreviousScreen();
        viewModel.animales = model.fetchPetsData();
        view.get().displayClientPetsData(viewModel);

    }

    @Override
    public void selectClientPetsData(PetsItem item) {
        router.passDataToPetsDetailScreen(item);
        router.navigateToPetsDetailScreen();
    }


}
