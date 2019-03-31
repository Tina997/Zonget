package es.ulpgc.montesdeoca110.cristina.zonget.administratorAgenda;

import android.support.v4.app.FragmentManager;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ListView;

import es.ulpgc.montesdeoca110.cristina.zonget.R;

public class AdministratorAgendaActivity
        extends AppCompatActivity implements AdministratorAgendaContract.View {

    public static String TAG = AdministratorAgendaActivity.class.getSimpleName();

    private AdministratorAgendaContract.Presenter presenter;
    private ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_administrator_agenda);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        // Show the title in the action bar
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setTitle(getString(R.string.agenda_activity_name));
        }

       listView = findViewById(R.id.event_list);

        // do the setup
        AdministratorAgendaScreen.configure(this);
    }

    @Override
    protected void onResume() {
        super.onResume();

        // do some work
        presenter.fetchDateListData();
    }

    @Override
    public void injectPresenter(AdministratorAgendaContract.Presenter presenter) {
        this.presenter = presenter;
    }

    @Override
    public void displayData(AdministratorAgendaViewModel viewModel) {
        listView.setAdapter(new AdministratorAgendaListAdapter(this, viewModel.eventList, new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentManager fragmentManager = getSupportFragmentManager();
                DialogEventDetail dialogo = new DialogEventDetail();
                dialogo.show(fragmentManager, "tagAlert");
            }
        }));
    }

    public void goToAddEvent(View view) {
        presenter.gotToAddEvent();
    }
}
