package es.ulpgc.montesdeoca110.cristina.zonget.agendaAdmin;

import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ListView;

import es.ulpgc.montesdeoca110.cristina.zonget.R;

public class AgendaAdminActivity
        extends AppCompatActivity implements AgendaAdminContract.View {

    public static String TAG = AgendaAdminActivity.class.getSimpleName();

    private AgendaAdminContract.Presenter presenter;
    public ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_agenda_admin);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        // Show the title in the action bar
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true);
            actionBar.setTitle(getString(R.string.agenda_activity_name));
        }

        listView = findViewById(R.id.lista_citas);

        // do the setup
        AgendaAdminScreen.configure(this);

    }

    @Override
    protected void onResume() {
        super.onResume();

        // do some work
      //  presenter.fetchDateListData();
    }

    @Override
    public void injectPresenter(AgendaAdminContract.Presenter presenter) {
        this.presenter = presenter;
    }

    @Override
    public void displayData(AgendaAdminViewModel viewModel) {
        //Log.e(TAG, "displayData()");
        listView.setAdapter( new AgendaAdminListAdapter(this, viewModel.dateList, new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                //TODO añadir método para que aparezca el pop up con el detalle
            }
        } ));
    }

    public void agregarCita(View view) {
        presenter.agregarCita();
    }
}
