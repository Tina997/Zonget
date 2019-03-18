package es.ulpgc.montesdeoca110.cristina.zonget.agendaAdmin;

import android.util.Log;

import java.lang.ref.WeakReference;
import java.util.List;

import es.ulpgc.montesdeoca110.cristina.zonget.App.CitaItem;

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
    public void fetchDateListData() {
        // Log.e(TAG, "fetchDateListData()");

       /* if(viewModel.dateList == null){

            //llamar al modelo
            List<CitaItem> data = model.fetchData();

            viewModel.dateList = data;
        }*/


        //mostrar datos
        view.get().displayData(viewModel);

    }

    //Navegar a las diferentes pantallas
    @Override
    public void agregarCita(){
        router.navigateToAgregarCitaScreen();
    }


}
