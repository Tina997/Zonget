package es.ulpgc.montesdeoca110.cristina.zonget.userPickDate;

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
import es.ulpgc.montesdeoca110.cristina.zonget.app.HourItem;

public class UserPickDateActivity
        extends AppCompatActivity implements UserPickDateContract.View {

  public static String TAG = UserPickDateActivity.class.getSimpleName();

  private UserPickDateContract.Presenter presenter;
  private ListView listView;
  private TextView selectedDate;
  private String date;
  private long calendarDate;
  private static Bundle bundle;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    UserPickDateScreen.configure(this);

    //Theme
    String themeName = presenter.getActualThemeName();
    if (themeName != null) {
      int themeID = getResources().getIdentifier(themeName, "style", getPackageName());
      setTheme(themeID);
    }
    setContentView(R.layout.activity_user_pick_date);
    Toolbar toolbar = findViewById(R.id.toolbar);
    setSupportActionBar(toolbar);

    // Show the data in the action bar
    ActionBar actionBar = getSupportActionBar();
    if (actionBar != null) {
      actionBar.setDisplayHomeAsUpEnabled(true);
      actionBar.setTitle("Cita Previa");
    }

    listView = findViewById(R.id.hours_list);
    CalendarView calendarView = findViewById(R.id.calendar);
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
    presenter.fetchData();
  }

  @Override
  public void injectPresenter(UserPickDateContract.Presenter presenter) {
    this.presenter = presenter;
  }

  @Override
  public void displayData(final UserPickDateViewModel viewModel) {
    //Log.e(TAG, "displayData()");
    listView.setAdapter(new UserPickDateAdapter(this, viewModel.hourItemList,
            new View.OnClickListener() {
          @Override
          public void onClick(View v) {
            FragmentManager fragmentManager = getSupportFragmentManager();
            HourItem pickHour = (HourItem) v.getTag();
            String hour = pickHour.hour;
            String day = (String) selectedDate.getText();
            DialogEventAcceptDate dialogo = new DialogEventAcceptDate(day, hour);
            dialogo.show(fragmentManager, "tagAlert");
          }
        }));
    //calendarView.setDate(viewModel.calendarDate, true, true);
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

  @Override
  public boolean onOptionsItemSelected(MenuItem item) {
    int id = item.getItemId();
    if (id == android.R.id.home) {
      super.onBackPressed();
      finish();
      return true;
    }
    return super.onOptionsItemSelected(item);
  }
}
