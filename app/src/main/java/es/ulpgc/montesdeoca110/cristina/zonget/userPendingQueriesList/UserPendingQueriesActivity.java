package es.ulpgc.montesdeoca110.cristina.zonget.userPendingQueriesList;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import es.ulpgc.montesdeoca110.cristina.zonget.R;


public class UserPendingQueriesActivity
        extends AppCompatActivity implements UserPendingQueriesContract.View {

    public static String TAG = UserPendingQueriesActivity.class.getSimpleName();

    private UserPendingQueriesContract.Presenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_pending_queries);

        // do the setup
        UserPendingQueriesScreen.configure(this);
    }

    @Override
    protected void onResume() {
        super.onResume();

        // load the data
        presenter.fetchData();
    }

    @Override
    public void displayData(UserPendingQueriesViewModel viewModel) {
        //Log.e(TAG, "displayData()");

        // deal with the data
        ((TextView) findViewById(R.id.data)).setText(viewModel.data);
    }

    @Override
    public void injectPresenter(UserPendingQueriesContract.Presenter presenter) {
        this.presenter = presenter;
    }
}
