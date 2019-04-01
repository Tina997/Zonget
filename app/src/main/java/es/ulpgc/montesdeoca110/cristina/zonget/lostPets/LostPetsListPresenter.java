package es.ulpgc.montesdeoca110.cristina.zonget.lostPets;

import android.util.Log;

import java.lang.ref.WeakReference;
import java.util.List;

import es.ulpgc.montesdeoca110.cristina.zonget.app.LostPetItem;
import es.ulpgc.montesdeoca110.cristina.zonget.data.RepositoryContract;

public class LostPetsListPresenter implements LostPetsListContract.Presenter {

    public static String TAG = LostPetsListPresenter.class.getSimpleName();

    private WeakReference<LostPetsListContract.View> view;
    private LostPetsListViewModel viewModel;
    private LostPetsListContract.Model model;
    private LostPetsListContract.Router router;

    public LostPetsListPresenter(LostPetsListState state) {
        viewModel = state;
    }

    @Override
    public void injectView(WeakReference<LostPetsListContract.View> view) {
        this.view = view;
    }

    @Override
    public void injectModel(LostPetsListContract.Model model) {
        this.model = model;
    }

    @Override
    public void injectRouter(LostPetsListContract.Router router) {
        this.router = router;
    }

    @Override
    public void fetchLostPetsListData() {
        // Log.e(TAG, "fetchPetsForAdoptionListData()");
        // call the model
         model.fetchLostPetsListData(new RepositoryContract.LostPets.GetLostPetsListCallback() {
            @Override
            public void setLostPetsList(List<LostPetItem> lostPets) {
                Log.e(TAG,lostPets.get(0).chipNum);
                viewModel.lostPetsItems = lostPets;
                view.get().displayLostPetsListData(viewModel);
            }
        });
        // set passed state

        // update the view

    }


}
