package es.ulpgc.montesdeoca110.cristina.zonget.userAgenda;

import android.content.Intent;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.webkit.WebView;
import android.widget.CalendarView;
import android.widget.ListView;
import android.widget.TextView;


import java.text.SimpleDateFormat;
import java.util.Date;

import es.ulpgc.montesdeoca110.cristina.zonget.R;
import es.ulpgc.montesdeoca110.cristina.zonget.userButtonsMenuList.UserButtonsMenuListActivity;

public class UserAgendaActivity
        extends AppCompatActivity implements UserAgendaContract.View {

    public static String TAG = UserAgendaActivity.class.getSimpleName();

    private UserAgendaContract.Presenter presenter;
    private ListView listView;
    private TextView selectedDate;
    private CalendarView calendarView;
    private String date;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        UserAgendaScreen.configure(this);

        //Theme
        String themeName = presenter.getActualThemeName();
        if (themeName != null){
            int themeID = getResources().getIdentifier(themeName,"style",getPackageName());
            setTheme(themeID);
        }

        setContentView(R.layout.activity_user_agenda);

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

        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        date = sdf.format(new Date(calendarView.getDate()));

        calendarView.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
            @Override
            public void onSelectedDayChange(CalendarView view, int year, int month, int dayOfMonth) {
                date = dayOfMonth + "/" + (month+1) + "/" + year;
                //TODO parece falso Rick
                selectedDate.setText(date);
            }
        });

        selectedDate.setText(date);

    }

    @Override
    protected void onResume() {
        super.onResume();

        // do some work
        presenter.fetchEventListData();
    }

    @Override
    public void injectPresenter(UserAgendaContract.Presenter presenter) {
        this.presenter = presenter;
    }

    @Override
    public void displayData(UserAgendaViewModel viewModel) {
        listView.setAdapter(new UserAgendaListAdapter(this, viewModel.eventList, new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentManager fragmentManager = getSupportFragmentManager();
                DialogUserEventDetail dialogo = new DialogUserEventDetail();
                dialogo.show(fragmentManager, "tagAlert");
            }
        }));
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            default:
                int id = item.getItemId();
                if (id == android.R.id.home) {
                    //TODO destruir activity
                    navigateUpTo(new Intent(this, UserButtonsMenuListActivity.class));
                    return true;
                }
                return super.onOptionsItemSelected(item);
        }
    }
}
