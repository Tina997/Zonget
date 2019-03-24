package es.ulpgc.montesdeoca110.cristina.zonget.administratorInbox;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import es.ulpgc.montesdeoca110.cristina.zonget.R;

public class AdministratorInboxActivity
        extends AppCompatActivity implements AdministratorInboxContract.View {

    public static String TAG = AdministratorInboxActivity.class.getSimpleName();

    private AdministratorInboxContract.Presenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_administrator_inbox);

        // do the setup
        AdministratorInboxScreen.configure(this);
    }

    @Override
    protected void onResume() {
        super.onResume();

        // do some work
        presenter.fetchData();
    }

    @Override
    public void injectPresenter(AdministratorInboxContract.Presenter presenter) {
        this.presenter = presenter;
    }

    @Override
    public void displayData(AdministratorInboxViewModel viewModel) {
        //Log.e(TAG, "displayData()");

        // deal with the data
        ((TextView) findViewById(R.id.data)).setText(viewModel.data);
    }
}
