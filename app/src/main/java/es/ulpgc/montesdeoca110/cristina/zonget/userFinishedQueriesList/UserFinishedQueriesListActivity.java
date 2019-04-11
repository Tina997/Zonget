package es.ulpgc.montesdeoca110.cristina.zonget.userFinishedQueriesList;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import es.ulpgc.montesdeoca110.cristina.zonget.R;


public class UserFinishedQueriesListActivity
        extends AppCompatActivity implements UserFinishedQueriesListContract.View {

    public static String TAG = UserFinishedQueriesListActivity.class.getSimpleName();

    private UserFinishedQueriesListContract.Presenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_finished_queries_list);

        // do the setup
        UserFinishedQueriesListScreen.configure(this);
    }

    @Override
    protected void onResume() {
        super.onResume();

        // load the data
        presenter.fetchData();
    }

    @Override
    public void displayData(UserFinishedQueriesListViewModel viewModel) {
        //Log.e(TAG, "displayData()");

        // deal with the data
        ((TextView) findViewById(R.id.data)).setText(viewModel.data);
    }

    @Override
    public void injectPresenter(UserFinishedQueriesListContract.Presenter presenter) {
        this.presenter = presenter;
    }
}
