package es.ulpgc.montesdeoca110.cristina.zonget.addEvent;

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

public class AddEventActivity
        extends AppCompatActivity implements AddEventContract.View {

    public static String TAG = AddEventActivity.class.getSimpleName();

    private AddEventContract.Presenter presenter;
    Spinner spinner;
    DatePicker datePicker;
    TimePicker timePicker;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        AddEventScreen.configure(this);

        //Theme
        String themeName = presenter.getActualThemeName();
        if (themeName != null){
            int themeID = getResources().getIdentifier(themeName,"style",getPackageName());
            setTheme(themeID);
        }


        setContentView(R.layout.activity_add_event);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        // Show the title in the action bar
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true);
            actionBar.setTitle(getString(R.string.addEvent_activity_name));
        }

        spinner = findViewById(R.id.spinner);
        datePicker = findViewById(R.id.datePicker);
        timePicker = findViewById(R.id.timePicker);

    }


    @Override
    protected void onResume() {
        super.onResume();

        // do some work
        presenter.fetchEventData();
    }

    @Override
    public void injectPresenter(AddEventContract.Presenter presenter) {
        this.presenter = presenter;
    }

    @Override
    public void displayData(AddEventViewModel viewModel) {
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

    public void addEvent(View view) {
        presenter.addEvent();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu items for use in the action bar
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.administrator_add_event_menu, menu);
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
                    presenter.onBackButtonPressed();
                }
                return super.onOptionsItemSelected(item);
        }
    }
}
