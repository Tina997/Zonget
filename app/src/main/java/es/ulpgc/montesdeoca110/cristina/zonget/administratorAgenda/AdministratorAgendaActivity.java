package es.ulpgc.montesdeoca110.cristina.zonget.administratorAgenda;

import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;

import es.ulpgc.montesdeoca110.cristina.zonget.R;

public class AdministratorAgendaActivity
        extends AppCompatActivity implements AdministratorAgendaContract.View {

    public static String TAG = AdministratorAgendaActivity.class.getSimpleName();

    private AdministratorAgendaContract.Presenter presenter;

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
        AdministratorAgendaScreen.configure(this);
    }

    @Override
    protected void onResume() {
        super.onResume();

        // do some work
        //presenter.fetchData();
    }

    @Override
    public void injectPresenter(AdministratorAgendaContract.Presenter presenter) {
        this.presenter = presenter;
    }

    @Override
    public void displayData(AdministratorAgendaViewModel viewModel) {
        //Log.e(TAG, "displayData()");

        // deal with the data
       // ((TextView) findViewById(R.id.data)).setText(viewModel.data);
    }

    public void agregarCita(View view) {
        presenter.agregarCita();
    }
}
