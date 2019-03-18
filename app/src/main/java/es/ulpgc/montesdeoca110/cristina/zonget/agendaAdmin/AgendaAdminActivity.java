package es.ulpgc.montesdeoca110.cristina.zonget.agendaAdmin;

import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import es.ulpgc.montesdeoca110.cristina.zonget.R;

public class AgendaAdminActivity
        extends AppCompatActivity implements AgendaAdminContract.View {

    public static String TAG = AgendaAdminActivity.class.getSimpleName();

    private AgendaAdminContract.Presenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_agenda_admin);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        // Show the title in the action bar
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setTitle(getString(R.string.agenda_activity_name));
        }

        // do the setup
        AgendaAdminScreen.configure(this);
    }

    @Override
    protected void onResume() {
        super.onResume();

        // do some work
        //presenter.fetchData();
    }

    @Override
    public void injectPresenter(AgendaAdminContract.Presenter presenter) {
        this.presenter = presenter;
    }

    @Override
    public void displayData(AgendaAdminViewModel viewModel) {
        //Log.e(TAG, "displayData()");

        // deal with the data
       // ((TextView) findViewById(R.id.data)).setText(viewModel.data);
    }

    public void agregarCita(View view) {
        presenter.agregarCita();
    }
}
