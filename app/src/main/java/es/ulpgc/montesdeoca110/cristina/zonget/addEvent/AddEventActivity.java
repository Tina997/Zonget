package es.ulpgc.montesdeoca110.cristina.zonget.addEvent;

import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;

import es.ulpgc.montesdeoca110.cristina.zonget.R;

public class AddEventActivity
        extends AppCompatActivity implements AddEventContract.View {

    public static String TAG = AddEventActivity.class.getSimpleName();

    private AddEventContract.Presenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_event);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        // Show the title in the action bar
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true);
            actionBar.setTitle(getString(R.string.addEvent_activity_name));
        }

        // do the setup
        AddEventScreen.configure(this);
    }

    @Override
    protected void onResume() {
        super.onResume();

        // do some work
        //presenter.fetchInboxData();
    }

    @Override
    public void injectPresenter(AddEventContract.Presenter presenter) {
        this.presenter = presenter;
    }

    @Override
    public void displayData(AddEventViewModel viewModel) {
        //Log.e(TAG, "displayData()");

        // deal with the data
        //((TextView) findViewById(R.id.data)).setText(viewModel.data);
    }

    public void addEvent(View view) {
        presenter.addEvent();
    }
}
