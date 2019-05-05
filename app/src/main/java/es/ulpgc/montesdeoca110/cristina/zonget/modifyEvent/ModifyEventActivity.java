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
import android.widget.DatePicker;
import android.widget.Spinner;
import android.widget.TimePicker;

import java.util.Calendar;

import es.ulpgc.montesdeoca110.cristina.zonget.R;
import es.ulpgc.montesdeoca110.cristina.zonget.administratorAgenda.AdministratorAgendaActivity;

public class ModifyEventActivity
        extends AppCompatActivity implements ModifyEventContract.View {

    public static String TAG = ModifyEventActivity.class.getSimpleName();

    private ModifyEventContract.Presenter presenter;
    Spinner spinner;
    DatePicker datePicker;
    TimePicker timePicker;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        ModifyEventScreen.configure(this);

        //Theme
        String themeName = presenter.getActualThemeName();
        if (themeName != null){
            int themeID = getResources().getIdentifier(themeName,"style",getPackageName());
            setTheme(themeID);
        }

        setContentView(R.layout.activity_modify_event);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        // Show the title in the action bar
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setTitle(getString(R.string.modifyEvent_activity_name));
            actionBar.setDisplayHomeAsUpEnabled(true);
        }

        spinner = findViewById(R.id.spinner);
        datePicker = findViewById(R.id.datePicker);
        timePicker = findViewById(R.id.timePicker);

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
        spinner.setSelection(viewModel.spinnerSelection);
        Calendar calendar = viewModel.calendar;
        datePicker.updateDate(calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH), calendar.get(Calendar.DAY_OF_MONTH));
        timePicker.setHour(calendar.get(Calendar.HOUR));
        timePicker.setMinute(calendar.get(Calendar.MINUTE));
    }

    @Override
    public void onPause(){
        //save DatePicker state
        Calendar calendar = Calendar.getInstance();
        calendar.set(datePicker.getYear(),datePicker.getMonth(),datePicker.getDayOfMonth());
        //save TimePicker state
        calendar.set(Calendar.HOUR, timePicker.getHour());
        calendar.set(Calendar.MINUTE, timePicker.getMinute());
        //save Spinner state
        int spinnerSelection = spinner.getSelectedItemPosition();
        presenter.saveState(spinnerSelection, calendar);
        super.onPause();
    }

    public void modifyEvent(View view) {
        presenter.modifyEvent();
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
