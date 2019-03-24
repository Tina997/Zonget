package es.ulpgc.montesdeoca110.cristina.zonget.userButtonsMenuList;

import android.util.Log;

import java.lang.ref.WeakReference;

public class UserButtonsMenuListPresenter implements UserButtonsMenuListContract.Presenter {

    public static String TAG = UserButtonsMenuListPresenter.class.getSimpleName();

    private WeakReference<UserButtonsMenuListContract.View> view;
    private UserButtonsMenuListViewModel viewModel;
    private UserButtonsMenuListContract.Model model;
    private UserButtonsMenuListContract.Router router;

    public UserButtonsMenuListPresenter(UserButtonsMenuListState state) {
        viewModel = state;
    }

    @Override
    public void injectView(WeakReference<UserButtonsMenuListContract.View> view) {
        this.view = view;
    }

    @Override
    public void injectModel(UserButtonsMenuListContract.Model model) {
        this.model = model;
    }

    @Override
    public void injectRouter(UserButtonsMenuListContract.Router router) {
        this.router = router;
    }

    @Override
    public void fetchData() {
        // Log.e(TAG, "fetchData()");

        // set passed state
        UserButtonsMenuListState state = router.getDataFromPreviousScreen();
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
