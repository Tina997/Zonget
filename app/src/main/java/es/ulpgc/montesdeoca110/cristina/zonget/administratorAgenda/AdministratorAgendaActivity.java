package es.ulpgc.montesdeoca110.cristina.zonget.administratorAgenda;

import android.os.Bundle;
import android.os.Parcelable;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.CalendarView;
import android.widget.ListView;
import android.widget.TextView;

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
  private static Bundle bundle;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);

    AdministratorAgendaScreen.configure(this);

    //Theme
    String themeName = presenter.getActualThemeName();
    if (themeName != null) {
      int themeID = getResources().getIdentifier(themeName, "style", getPackageName());
      setTheme(themeID);
    }

    setContentView(R.layout.activity_administrator_agenda);

    Toolbar toolbar = findViewById(R.id.toolbar);
    setSupportActionBar(toolbar);

    // Show the data in the action bar
    ActionBar actionBar = getSupportActionBar();
    if (actionBar != null) {
      actionBar.setTitle(getString(R.string.agenda_activity_name));
      actionBar.setDisplayHomeAsUpEnabled(true);
    }

    listView = findViewById(R.id.event_list);

    calendarView = findViewById(R.id.calendar);
    selectedDate = findViewById(R.id.selectedDay);

    calendarDate = calendarView.getDate();

    calendarView.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
      @Override
      public void onSelectedDayChange(CalendarView view, int year, int month, int dayOfMonth) {
        date = dayOfMonth + "/" + (month + 1) + "/" + year;
        presenter.onDateChanged(date, calendarDate);
      }
    });

  }

  @Override
  protected void onResume() {
    super.onResume();
    //restore ListView state
    if(bundle != null){
      Parcelable listState = bundle.getParcelable("state");
      listView.onRestoreInstanceState(listState);
    }

    // do some work
    presenter.fetchAdministratorAgendaData();
  }

  @Override
  public void injectPresenter(AdministratorAgendaContract.Presenter presenter) {
    this.presenter = presenter;
  }

  @Override
  public void displayData(AdministratorAgendaViewModel viewModel) {
    listView.setAdapter(new AdministratorAgendaListAdapter(this,
            viewModel.eventList, new View.OnClickListener() {
              @Override
              public void onClick(View v) {
                FragmentManager fragmentManager = getSupportFragmentManager();
                DialogEventDetail dialogo = new DialogEventDetail(AdministratorAgendaActivity.this);
                dialogo.show(fragmentManager, "tagAlert");
              }
            }));
   // calendarView.setDate(viewModel.calendarDate, true, true);
    selectedDate.setText(viewModel.date);
  }

  @Override
  public void onPause() {
    //Save ListView state
    bundle = new Bundle();
    Parcelable listState = listView.onSaveInstanceState();
    bundle.putParcelable("state", listState);
    //save calendar state
    presenter.saveState(date, calendarDate);
    super.onPause();
  }

  public void goToAddEvent(View view) {
    presenter.gotToAddEvent();
  }

  public void onModifyButtonClicked() {
    presenter.navigateToModifyEventScreen();
  }

  @Override
  public boolean onOptionsItemSelected(MenuItem item) {
    switch (item.getItemId()) {
      default:
        int id = item.getItemId();
        if (id == android.R.id.home) {
          //TODO destruir activity
          presenter.onBackButtonPressed();
          finish();
          return true;
        }
        return super.onOptionsItemSelected(item);
    }
  }
}
