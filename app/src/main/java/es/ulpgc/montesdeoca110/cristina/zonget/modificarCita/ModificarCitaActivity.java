package es.ulpgc.montesdeoca110.cristina.zonget.modificarCita;

import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import es.ulpgc.montesdeoca110.cristina.zonget.R;

public class ModificarCitaActivity
        extends AppCompatActivity implements ModificarCitaContract.View {

    public static String TAG = ModificarCitaActivity.class.getSimpleName();

    private ModificarCitaContract.Presenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_modificar_cita);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        // Show the title in the action bar
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setTitle(getString(R.string.modificarCita_activity_name));
        }

        // do the setup
        ModificarCitaScreen.configure(this);
    }

    @Override
    protected void onResume() {
        super.onResume();

        // do some work
        presenter.fetchData();
    }

    @Override
    public void injectPresenter(ModificarCitaContract.Presenter presenter) {
        this.presenter = presenter;
    }

    @Override
    public void displayData(ModificarCitaViewModel viewModel) {
        //Log.e(TAG, "displayData()");

        // deal with the data
       //((TextView) findViewById(R.id.data)).setText(viewModel.data);
    }

    public void modificarCita(View view) {
        presenter.modificarCita();
    }
}
