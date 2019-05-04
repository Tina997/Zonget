package es.ulpgc.montesdeoca110.cristina.zonget.userAgenda;

import java.lang.ref.WeakReference;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import es.ulpgc.montesdeoca110.cristina.zonget.app.EventItem;

public class UserAgendaPresenter implements UserAgendaContract.Presenter {

    public static String TAG = UserAgendaPresenter.class.getSimpleName();

    private WeakReference<UserAgendaContract.View> view;
    private UserAgendaViewModel viewModel;
    private UserAgendaContract.Model model;
    private UserAgendaContract.Router router;

    public UserAgendaPresenter(UserAgendaState state) {
        viewModel = state;
    }

    @Override
    public void injectView(WeakReference<UserAgendaContract.View> view) {
        this.view = view;
    }

    @Override
    public void injectModel(UserAgendaContract.Model model) {
        this.model = model;
    }

    @Override
    public void injectRouter(UserAgendaContract.Router router) {
        this.router = router;
    }

    @Override
    public void fetchEventListData() {

        UserAgendaState state;
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


        //mostrar datos
        view.get().displayData(viewModel);;

    }

    @Override
    public void onDateChanged(String date, long calendarDate){
        viewModel.date = date;
        viewModel.calendarDate = calendarDate;
        view.get().displayData(viewModel);
    }

    @Override
    public void saveState(String selectedDate, long calendarDate){
        UserAgendaState state = new UserAgendaState();
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


}
