package es.ulpgc.montesdeoca110.cristina.zonget.administratorAgenda;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.support.v4.app.FragmentActivity;
import android.view.View;
import java.lang.ref.WeakReference;
import java.util.List;
import es.ulpgc.montesdeoca110.cristina.zonget.R;
import es.ulpgc.montesdeoca110.cristina.zonget.app.EventItem;

public class AdministratorAgendaPresenter extends FragmentActivity implements AdministratorAgendaContract.Presenter {

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

    //TODO añadir a strings los nombres
    public void createEventDetailsDialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Detalles");
        View dialogView = this.getLayoutInflater().inflate(R.layout.administrator_agenda_event_details_dialog, null);
        builder.setView(dialogView);
        builder.setNeutralButton("Modificar", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                //TODO método del router para cambiar de pantalla
            }
        });
        builder.setNeutralButton("Eliminar", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                //TODO mostrar diálogo de confirmación
            }
        });
         builder.show();
    }

    //Navegar a las diferentes pantallas
    @Override
    public void gotToAddEvent(){
        router.navigateToAddEventScreen();
    }


}
