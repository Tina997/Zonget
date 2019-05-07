package es.ulpgc.montesdeoca110.cristina.zonget.administratorInbox;

import android.os.Bundle;
import android.os.Parcelable;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;

import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;

import android.view.MenuItem;
import android.view.View;

import es.ulpgc.montesdeoca110.cristina.zonget.R;

public class AdministratorInboxActivity
        extends AppCompatActivity implements AdministratorInboxContract.View {

  public static String TAG = AdministratorInboxActivity.class.getSimpleName();

  private AdministratorInboxContract.Presenter presenter;
  private AdministratorInboxListAdapter listAdapter;
  private RecyclerView recyclerView;
  private static Bundle bundle;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);

    AdministratorInboxScreen.configure(this);

    //Theme
    String themeName = presenter.getActualThemeName();
    if (themeName != null) {
      int themeID = getResources().getIdentifier(themeName, "style", getPackageName());
      setTheme(themeID);
    }


    setContentView(R.layout.activity_administrator_inbox);

    Toolbar toolbar = findViewById(R.id.toolbar);
    setSupportActionBar(toolbar);

    // Show the title in the action bar
    ActionBar actionBar = getSupportActionBar();
    if (actionBar != null) {
      actionBar.setTitle(getString(R.string.administrator_inbox_activity_name));
      actionBar.setDisplayHomeAsUpEnabled(true);
    }

    listAdapter = new AdministratorInboxListAdapter(new View.OnClickListener() {
      @Override
      public void onClick(View v) {

        presenter.goToAdministratorQueryDetailScreen();
      }
    });

    recyclerView = findViewById(R.id.inbox_list);
    recyclerView.setAdapter(listAdapter);


  }

  @Override
  protected void onResume() {
    super.onResume();
    //restore RecyclerView state
    if(bundle != null){
      Parcelable listState = bundle.getParcelable("state");
      recyclerView.getLayoutManager().onRestoreInstanceState(listState);
    }

    // do some work
    presenter.fetchInboxData();
  }

  @Override
  public void injectPresenter(AdministratorInboxContract.Presenter presenter) {
    this.presenter = presenter;
  }

  @Override
  public void displayData(AdministratorInboxViewModel viewModel) {
    listAdapter.setItems(viewModel.inboxList);
  }

  @Override
  public void onPause(){
    super.onPause();
    //Save RecyclerView state
    bundle = new Bundle();
    Parcelable listState =
            recyclerView.getLayoutManager().onSaveInstanceState();
    bundle.putParcelable("state", listState);
  }

  @Override
  public boolean onOptionsItemSelected(MenuItem item) {
    switch (item.getItemId()) {
      default:
        int id = item.getItemId();
        if (id == android.R.id.home) {
          presenter.onBackButtonPressed();
          finish();
        }
        return super.onOptionsItemSelected(item);
    }
  }
}
