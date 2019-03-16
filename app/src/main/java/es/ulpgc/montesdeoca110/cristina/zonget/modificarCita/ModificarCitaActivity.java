package es.ulpgc.montesdeoca110.cristina.zonget.modificarCita;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
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
        ((TextView) findViewById(R.id.data)).setText(viewModel.data);
    }
}
