package es.ulpgc.montesdeoca110.cristina.zonget.agendaAdmin;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
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

        // do the setup
        AgendaAdminScreen.configure(this);
    }

    @Override
    protected void onResume() {
        super.onResume();

        // do some work
        presenter.fetchData();
    }

    @Override
    public void injectPresenter(AgendaAdminContract.Presenter presenter) {
        this.presenter = presenter;
    }

    @Override
    public void displayData(AgendaAdminViewModel viewModel) {
        //Log.e(TAG, "displayData()");

        // deal with the data
        ((TextView) findViewById(R.id.data)).setText(viewModel.data);
    }
}
