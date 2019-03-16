package es.ulpgc.montesdeoca110.cristina.zonget.agendaAdmin;

import android.util.Log;

import java.lang.ref.WeakReference;

public class AgendaAdminPresenter implements AgendaAdminContract.Presenter {

    public static String TAG = AgendaAdminPresenter.class.getSimpleName();

    private WeakReference<AgendaAdminContract.View> view;
    private AgendaAdminViewModel viewModel;
    private AgendaAdminContract.Model model;
    private AgendaAdminContract.Router router;

    public AgendaAdminPresenter(AgendaAdminState state) {
        viewModel = state;
    }

    @Override
    public void injectView(WeakReference<AgendaAdminContract.View> view) {
        this.view = view;
    }

    @Override
    public void injectModel(AgendaAdminContract.Model model) {
        this.model = model;
    }

    @Override
    public void injectRouter(AgendaAdminContract.Router router) {
        this.router = router;
    }

    @Override
    public void fetchData() {
        // Log.e(TAG, "fetchData()");

        // set passed state
        AgendaAdminState state = router.getDataFromPreviousScreen();
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

    //Navegar a las diferentes pantallas
    @Override
    public void agregarCita(){
        router.navigateToAgregarCitaScreen();
    }


}
