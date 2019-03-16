package es.ulpgc.montesdeoca110.cristina.zonget.agregarCita;

import android.util.Log;

import java.lang.ref.WeakReference;

public class AgregarCitaPresenter implements AgregarCitaContract.Presenter {

    public static String TAG = AgregarCitaPresenter.class.getSimpleName();

    private WeakReference<AgregarCitaContract.View> view;
    private AgregarCitaViewModel viewModel;
    private AgregarCitaContract.Model model;
    private AgregarCitaContract.Router router;

    public AgregarCitaPresenter(AgregarCitaState state) {
        viewModel = state;
    }

    @Override
    public void injectView(WeakReference<AgregarCitaContract.View> view) {
        this.view = view;
    }

    @Override
    public void injectModel(AgregarCitaContract.Model model) {
        this.model = model;
    }

    @Override
    public void injectRouter(AgregarCitaContract.Router router) {
        this.router = router;
    }

    @Override
    public void fetchData() {
        // Log.e(TAG, "fetchData()");

        // set passed state
        AgregarCitaState state = router.getDataFromPreviousScreen();
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
    public void aceptarCita(){
        router.navigateToAgendaAdminScreen();
    }


}
