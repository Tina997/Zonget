package es.ulpgc.montesdeoca110.cristina.zonget.userAgenda;

import java.lang.ref.WeakReference;

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
    public void fetchData() {
        // Log.e(TAG, "fetchPetsForAdoptionListData()");

        // set passed state
        UserAgendaState state = router.getDataFromPreviousScreen();
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


}
