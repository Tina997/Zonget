package es.ulpgc.montesdeoca110.cristina.zonget.modifyEvent;

import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;

import es.ulpgc.montesdeoca110.cristina.zonget.R;

public class ModifyEventActivity
        extends AppCompatActivity implements ModifyEventContract.View {

    public static String TAG = ModifyEventActivity.class.getSimpleName();

    private ModifyEventContract.Presenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_modify_event);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        // Show the title in the action bar
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setTitle(getString(R.string.modificarCita_activity_name));
        }

        // do the setup
        ModifyEventScreen.configure(this);
    }

    @Override
    protected void onResume() {
        super.onResume();

        // do some work
        presenter.fetchData();
    }

    @Override
    public void injectPresenter(ModifyEventContract.Presenter presenter) {
        this.presenter = presenter;
    }

    @Override
    public void displayData(ModifyEventViewModel viewModel) {
        //Log.e(TAG, "displayData()");

        // deal with the data
       //((TextView) findViewById(R.id.data)).setText(viewModel.data);
    }

    public void modificarCita(View view) {
        presenter.modificarCita();
    }
}
