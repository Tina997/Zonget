package es.ulpgc.montesdeoca110.cristina.zonget.administratorAgenda;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.view.LayoutInflater;
import android.view.View;
import java.lang.ref.WeakReference;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import es.ulpgc.montesdeoca110.cristina.zonget.R;
import es.ulpgc.montesdeoca110.cristina.zonget.app.AppMediator;
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
    public void fetchAdministratorAgendaData() {

        AdministratorAgendaState state;
        state = router.getDataFromPreviousScreen();

        if(state != null){
            viewModel.date = state.selectedDate;
            viewModel.calendarDate = state.calendarDate;
        }

        if(viewModel.eventList == null){
            //llamar al modelo
            List<EventItem> data = model.fetchData();
            viewModel.eventList = data;
        }

        if(viewModel.calendarDate == 0 || viewModel.date == null){
            //Llamar al modelo
            long time = model.fetchDateData();
            viewModel.calendarDate = time;
            String currentDate = new SimpleDateFormat("dd/MM/yyyy").format(new Date(time));
            viewModel.date = currentDate;
        }

        view.get().displayData(viewModel);

    }

    @Override
    public void onDateChanged(String date, long calendarDate){
        viewModel.date = date;
        viewModel.calendarDate = calendarDate;
        view.get().displayData(viewModel);
    }

    @Override
    public void saveState(String selectedDate, long calendarDate){
        AdministratorAgendaState state = new AdministratorAgendaState();
        state.setSelectedDate(selectedDate);
        state.setCalendarDate(calendarDate);
        router.passDataToNextScreen(state);
    }

    @Override
    public String getActualThemeName() {
        return router.getActualThemeName();
    }

    @Override
    public void onBackButtonPressed() {
        router.onBackButtonPressed();
    }


    //Navegar a las diferentes pantallas
    @Override
    public void gotToAddEvent(){
        router.navigateToAddEventScreen();
    }

    @Override
    public void navigateToModifyEventScreen(){router.navigateToModifyEventScreen();}


}
