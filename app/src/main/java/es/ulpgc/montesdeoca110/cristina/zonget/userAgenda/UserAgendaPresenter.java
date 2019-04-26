package es.ulpgc.montesdeoca110.cristina.zonget.userAgenda;

import java.lang.ref.WeakReference;
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
        if(viewModel.eventList == null){

            //llamar al modelo
            List<EventItem> data = model.fetchData();

            viewModel.eventList = data;
        }


        //mostrar datos
        view.get().displayData(viewModel);;

    }

    @Override
    public String getActualThemeName() {
        return router.getActualThemeName();
    }


}
