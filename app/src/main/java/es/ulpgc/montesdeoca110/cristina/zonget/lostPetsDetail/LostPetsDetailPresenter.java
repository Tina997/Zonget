package es.ulpgc.montesdeoca110.cristina.zonget.lostPetsDetail;

import android.util.Log;

import java.lang.ref.WeakReference;

import es.ulpgc.montesdeoca110.cristina.zonget.app.LostPetItem;

public class LostPetsDetailPresenter implements LostPetsDetailContract.Presenter {

    public static String TAG = LostPetsDetailPresenter.class.getSimpleName();

    private WeakReference<LostPetsDetailContract.View> view;
    private LostPetsDetailViewModel viewModel;
    private LostPetsDetailContract.Model model;
    private LostPetsDetailContract.Router router;

    public LostPetsDetailPresenter(LostPetsDetailState state) {
        viewModel = state;
    }

    @Override
    public void injectView(WeakReference<LostPetsDetailContract.View> view) {
        this.view = view;
    }

    @Override
    public void injectModel(LostPetsDetailContract.Model model) {
        this.model = model;
    }

    @Override
    public void injectRouter(LostPetsDetailContract.Router router) {
        this.router = router;
    }

    @Override
    public void fetchLostPetDetailData() {
        // Log.e(TAG, "fetchPetForAdoptionDetailData()");

        // set passed state
        LostPetItem lostPetItem = router.getDataFromLostPetsListScreen();
        if(lostPetItem != null){
            viewModel.lostPetItem = lostPetItem;
        }
        // update the view
        view.get().displayLostPetDetailData(viewModel);

    }


}
