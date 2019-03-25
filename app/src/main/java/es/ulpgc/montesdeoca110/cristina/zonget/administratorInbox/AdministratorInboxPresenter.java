package es.ulpgc.montesdeoca110.cristina.zonget.administratorInbox;

import android.util.Log;

import java.lang.ref.WeakReference;
import java.util.List;

import es.ulpgc.montesdeoca110.cristina.zonget.app.QueryItem;

public class AdministratorInboxPresenter implements AdministratorInboxContract.Presenter {

    public static String TAG = AdministratorInboxPresenter.class.getSimpleName();

    private WeakReference<AdministratorInboxContract.View> view;
    private AdministratorInboxViewModel viewModel;
    private AdministratorInboxContract.Model model;
    private AdministratorInboxContract.Router router;

    public AdministratorInboxPresenter(AdministratorInboxState state) {
        viewModel = state;
    }

    @Override
    public void injectView(WeakReference<AdministratorInboxContract.View> view) {
        this.view = view;
    }

    @Override
    public void injectModel(AdministratorInboxContract.Model model) {
        this.model = model;
    }

    @Override
    public void injectRouter(AdministratorInboxContract.Router router) {
        this.router = router;
    }

    @Override
    public void fetchInboxData() {

        if(viewModel.inboxList == null){

            //llamar al modelo
            List<QueryItem> data = model.fetchData();

            viewModel.inboxList = data;
        }
        // update the view
        view.get().displayData(viewModel);

    }


}
