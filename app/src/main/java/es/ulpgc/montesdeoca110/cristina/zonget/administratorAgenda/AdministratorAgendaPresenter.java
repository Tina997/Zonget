package es.ulpgc.montesdeoca110.cristina.zonget.administratorAgenda;

import java.lang.ref.WeakReference;
import java.util.List;

import es.ulpgc.montesdeoca110.cristina.zonget.app.CitaItem;

public class AdministratorAgendaPresenter implements AdministratorAgendaContract.Presenter {

    public static String TAG = AdministratorAgendaPresenter.class.getSimpleName();

    private WeakReference<AdministratorAgendaContract.View> view;
    private AdministratorAgendaViewModel viewModel;
    private AdministratorAgendaContract.Model model;
    private AdministratorAgendaContract.Router router;

    public AdministratorAgendaPresenter(AdministratorAdministratorAgendaState state) {
        viewModel = state;
    }

    @Override
    public void injectView(WeakReference<AdministratorAgendaContract.View> view) {
        this.view = view;
    }

    @Override
    public void injectModel(AdministratorAgendaContract.Model model) {
        this.model = model;
    }

    @Override
    public void injectRouter(AdministratorAgendaContract.Router router) {
        this.router = router;
    }

    @Override
    public void fetchDateListData() {
        // Log.e(TAG, "fetchDateListData()");

        if(viewModel.dateList == null){

            //llamar al modelo
            List<CitaItem> data = model.fetchData();

            viewModel.dateList = data;
        }


        //mostrar datos
        view.get().displayData(viewModel);

    }

    //Navegar a las diferentes pantallas
    @Override
    public void agregarCita(){
        router.navigateToAgregarCitaScreen();
    }


}
