package es.ulpgc.montesdeoca110.cristina.zonget.queriesMenu;

import android.util.Log;

import java.lang.ref.WeakReference;

public class QueriesMenuPresenter implements QueriesMenuContract.Presenter {

    public static String TAG = QueriesMenuPresenter.class.getSimpleName();

    private WeakReference<QueriesMenuContract.View> view;
    private QueriesMenuViewModel viewModel;
    private QueriesMenuContract.Model model;
    private QueriesMenuContract.Router router;

    public QueriesMenuPresenter(QueriesMenuState state) {
        viewModel = state;
    }

    @Override
    public void injectView(WeakReference<QueriesMenuContract.View> view) {
        this.view = view;
    }

    @Override
    public void injectModel(QueriesMenuContract.Model model) {
        this.model = model;
    }

    @Override
    public void injectRouter(QueriesMenuContract.Router router) {
        this.router = router;
    }

    @Override
    public void fetchData() {
        // Log.e(TAG, "fetchInboxData()");

        // set passed state
        QueriesMenuState state = router.getDataFromPreviousScreen();
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
