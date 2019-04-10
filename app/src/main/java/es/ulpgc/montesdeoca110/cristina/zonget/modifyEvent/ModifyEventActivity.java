package es.ulpgc.montesdeoca110.cristina.zonget.modifyEvent;

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
            actionBar.setTitle(getString(R.string.modifyEvent_activity_name));
            actionBar.setDisplayHomeAsUpEnabled(true);
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

    public void modifyEvent(View view) {
        presenter.modifyEvent();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu items for use in the action bar
        MenuInflater inflater = getMenuInflater();
        //TODO refactorizar nombre
        inflater.inflate(R.menu.administrator_agenda_accept_button, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.action_accept:
                //TODO datos
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
