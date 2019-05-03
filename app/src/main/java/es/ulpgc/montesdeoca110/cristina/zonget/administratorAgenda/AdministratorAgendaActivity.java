package es.ulpgc.montesdeoca110.cristina.zonget.administratorAgenda;

import android.support.v4.app.FragmentManager;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.CalendarView;
import android.widget.ListView;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.Date;

import es.ulpgc.montesdeoca110.cristina.zonget.R;

public class AdministratorAgendaActivity
        extends AppCompatActivity implements AdministratorAgendaContract.View {

    public static String TAG = AdministratorAgendaActivity.class.getSimpleName();

    private AdministratorAgendaContract.Presenter presenter;
    private ListView listView;
    private TextView selectedDate;
    private CalendarView calendarView;
    private String date;
    private long calendarDate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        AdministratorAgendaScreen.configure(this);

        //Theme
        String themeName = presenter.getActualThemeName();
        if (themeName != null){
            int themeID = getResources().getIdentifier(themeName,"style",getPackageName());
            setTheme(themeID);
        }

        setContentView(R.layout.activity_administrator_agenda);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        // Show the title in the action bar
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setTitle(getString(R.string.agenda_activity_name));
            actionBar.setDisplayHomeAsUpEnabled(true);
        }

       listView = findViewById(R.id.event_list);

        calendarView = findViewById(R.id.calendar);
        selectedDate = findViewById(R.id.selectedDay);

        calendarDate = calendarView.getDate();

       SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
       date = sdf.format(new Date(calendarView.getDate()));

        calendarView.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
            @Override
            public void onSelectedDayChange(CalendarView view, int year, int month, int dayOfMonth) {
                date = dayOfMonth + "/" + (month+1) + "/" + year;
                presenter.onDateChanged(date);
            }
        });

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
                DialogEventDetail dialogo = new DialogEventDetail(AdministratorAgendaActivity.this);
                dialogo.show(fragmentManager, "tagAlert");
            }
        }));
        //calendarView.setDate(viewModel.calendarDate, true, true);
        selectedDate.setText(viewModel.date);
    }

    //Prueba
    @Override
    public void onPause(){
        presenter.saveState(date, calendarDate);
        super.onPause();
    }

    public void goToAddEvent(View view) {
        presenter.gotToAddEvent();
    }

    public void onModifyButtonClicked(){ presenter.navigateToModifyEventScreen();}

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
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
