package es.ulpgc.montesdeoca110.cristina.zonget.clientPetsDetail;

import java.lang.ref.WeakReference;

import es.ulpgc.montesdeoca110.cristina.zonget.app.AnimalClientesItem;

public class AnimalDetailPresenter implements AnimalDetailContract.Presenter {

    public static String TAG = AnimalDetailPresenter.class.getSimpleName();

    private WeakReference<AnimalDetailContract.View> view;
    private AnimalDetailViewModel viewModel;
    private AnimalDetailContract.Model model;
    private AnimalDetailContract.Router router;

    public AnimalDetailPresenter(AnimalDetailState state) {
        viewModel = state;
    }

    @Override
    public void injectView(WeakReference<AnimalDetailContract.View> view) {
        this.view = view;
    }

    @Override
    public void injectModel(AnimalDetailContract.Model model) {
        this.model = model;
    }

    @Override
    public void injectRouter(AnimalDetailContract.Router router) {
        this.router = router;
    }

    @Override
    public void fetchData() {
        // Log.e(TAG, "fetchDateListData()");

        // set passed state
        AnimalClientesItem animal = router.getDataFromPreviousScreen();
        if(animal != null){
            viewModel.animal = animal;
        }

        // update the view
        view.get().displayData(viewModel);

    }


}
