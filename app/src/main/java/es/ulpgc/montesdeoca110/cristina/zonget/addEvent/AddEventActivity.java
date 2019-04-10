package es.ulpgc.montesdeoca110.cristina.zonget.addEvent;

import android.content.Intent;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;

import es.ulpgc.montesdeoca110.cristina.zonget.R;
import es.ulpgc.montesdeoca110.cristina.zonget.administratorAgenda.AdministratorAgendaActivity;

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

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu items for use in the action bar
        MenuInflater inflater = getMenuInflater();
        //TODO refactorizar nombre
        inflater.inflate(R.menu.administrator_agenda_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.action_accept:
                presenter.navigateToAdministratorAgendaScreen();
            default:
                int id = item.getItemId();
                if (id == android.R.id.home) {
                    //TODO destruir activity
                    navigateUpTo(new Intent(this, AdministratorAgendaActivity.class));
                    return true;
                }
                return super.onOptionsItemSelected(item);
        }
    }
}
