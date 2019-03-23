package es.ulpgc.montesdeoca110.cristina.zonget.administratorAgenda;

import android.app.AlertDialog;

import java.lang.ref.WeakReference;
import java.util.List;

import es.ulpgc.montesdeoca110.cristina.zonget.app.EventItem;

public class AdministratorAgendaPresenter implements AdministratorAgendaContract.Presenter {

    public static String TAG = AdministratorAgendaPresenter.class.getSimpleName();

    private WeakReference<AdministratorAgendaContract.View> view;
    private AdministratorAgendaViewModel viewModel;
    private AdministratorAgendaContract.Model model;
    private AdministratorAgendaContract.Router router;

    public AdministratorAgendaPresenter(AdministratorAgendaState state) {
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

        if(viewModel.eventList == null){

            //llamar al modelo
            List<EventItem> data = model.fetchData();

            viewModel.eventList = data;
        }


        //mostrar datos
        view.get().displayData(viewModel);

    }

    @Override
    public void showEventDetails(){

    }

    //Navegar a las diferentes pantallas
    @Override
    public void gotToAddEvent(){
        router.navigateToAddEventScreen();
    }


}
