package es.ulpgc.montesdeoca110.cristina.zonget.petsForAdoptionDetail;

import android.util.Log;

import java.lang.ref.WeakReference;

import es.ulpgc.montesdeoca110.cristina.zonget.app.PetForAdoptionItem;

public class PetsForAdoptionDetailPresenter implements PetsForAdoptionDetailContract.Presenter {

    public static String TAG = PetsForAdoptionDetailPresenter.class.getSimpleName();

    private WeakReference<PetsForAdoptionDetailContract.View> view;
    private PetsForAdoptionDetailViewModel viewModel;
    private PetsForAdoptionDetailContract.Model model;
    private PetsForAdoptionDetailContract.Router router;

    public PetsForAdoptionDetailPresenter(PetsForAdoptionDetailState state) {
        viewModel = state;
    }

    @Override
    public void injectView(WeakReference<PetsForAdoptionDetailContract.View> view) {
        this.view = view;
    }

    @Override
    public void injectModel(PetsForAdoptionDetailContract.Model model) {
        this.model = model;
    }

    @Override
    public void injectRouter(PetsForAdoptionDetailContract.Router router) {
        this.router = router;
    }

    @Override
    public void fetchPetForAdoptionDetailData() {

        PetForAdoptionItem petForAdoptionItem = router.getDataFromPreviousScreen();
        if(petForAdoptionItem != null){
            viewModel.petForAdoptionItem = petForAdoptionItem;
        }
        // update the view
        view.get().displayData(viewModel);

    }


}
