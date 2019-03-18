package es.ulpgc.montesdeoca110.cristina.zonget.modificarCita;

import android.util.Log;

import java.lang.ref.WeakReference;

public class ModificarCitaPresenter implements ModificarCitaContract.Presenter {

    public static String TAG = ModificarCitaPresenter.class.getSimpleName();

    private WeakReference<ModificarCitaContract.View> view;
    private ModificarCitaViewModel viewModel;
    private ModificarCitaContract.Model model;
    private ModificarCitaContract.Router router;

    public ModificarCitaPresenter(ModificarCitaState state) {
        viewModel = state;
    }

    @Override
    public void injectView(WeakReference<ModificarCitaContract.View> view) {
        this.view = view;
    }

    @Override
    public void injectModel(ModificarCitaContract.Model model) {
        this.model = model;
    }

    @Override
    public void injectRouter(ModificarCitaContract.Router router) {
        this.router = router;
    }

    @Override
    public void fetchData() {
        // Log.e(TAG, "fetchDateListData()");

        // set passed state
        ModificarCitaState state = router.getDataFromPreviousScreen();
        if (state != null) {
            viewModel.data = state.data;
        }

        if (viewModel.data == null) {
            // call the model
            String data = model.fetchData();

            // set initial state
            viewModel.data = data;
        }

        // update the view
        view.get().displayData(viewModel);

    }

    @Override
    public void modificarCita(){
        router.navigateToAgendaAdminScreen();
    }


}
