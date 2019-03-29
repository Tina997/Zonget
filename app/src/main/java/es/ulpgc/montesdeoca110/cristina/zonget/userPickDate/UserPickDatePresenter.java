package es.ulpgc.montesdeoca110.cristina.zonget.userPickDate;

import android.util.Log;

import java.lang.ref.WeakReference;
import java.util.List;

import es.ulpgc.montesdeoca110.cristina.zonget.app.EventItem;
import es.ulpgc.montesdeoca110.cristina.zonget.app.HourItem;

public class UserPickDatePresenter implements UserPickDateContract.Presenter {

    public static String TAG = UserPickDatePresenter.class.getSimpleName();

    private WeakReference<UserPickDateContract.View> view;
    private UserPickDateViewModel viewModel;
    private UserPickDateContract.Model model;
    private UserPickDateContract.Router router;

    public UserPickDatePresenter(UserPickDateState state) {
        viewModel = state;
    }

    @Override
    public void injectView(WeakReference<UserPickDateContract.View> view) {
        this.view = view;
    }

    @Override
    public void injectModel(UserPickDateContract.Model model) {
        this.model = model;
    }

    @Override
    public void injectRouter(UserPickDateContract.Router router) {
        this.router = router;
    }

    @Override
    public void fetchData() {
        // Log.e(TAG, "fetchData()");

        if(viewModel.hourItemList == null){

            //llamar al modelo
            List<HourItem> data = model.fetchData();

            viewModel.hourItemList = data;
        }
        // update the view
        view.get().displayData(viewModel);

    }


}
