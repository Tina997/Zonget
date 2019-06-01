package es.ulpgc.montesdeoca110.cristina.zonget.userPendingQueriesList;

import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.ExpandableListAdapter;
import android.widget.ExpandableListView;
import android.widget.Toast;

import java.util.ArrayList;

import es.ulpgc.montesdeoca110.cristina.zonget.R;
import es.ulpgc.montesdeoca110.cristina.zonget.app.Query;


public class UserPendingQueriesListActivity extends AppCompatActivity implements UserPendingQueriesListContract.View {

  private UserPendingQueriesListContract.Presenter presenter;

  //Elementos de la vista
  private Toolbar toolbar;

  private UserPendingQueriesListAdapter listAdapter;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);

    UserPendingQueriesListScreen.configure(this);

    //Theme
    String themeName = presenter.getActualThemeName();
    if (themeName != null) {
      int themeID = getResources().getIdentifier(themeName, "style", getPackageName());
      setTheme(themeID);
    }

    setContentView(R.layout.activity_user_pending_queries_list);

    //Configuracion de la toolBar/actionBar
    toolbar = findViewById(R.id.toolbar);
    setSupportActionBar(toolbar);

    ActionBar actionBar = getSupportActionBar();
    actionBar.setTitle("Consultas pendientes");
    actionBar.setDisplayHomeAsUpEnabled(true);

    listAdapter = new UserPendingQueriesListAdapter(this,new ArrayList<Query>());

    //RecycleView
    RecyclerView recyclerView = findViewById(R.id.user_pending_queries_list_recycleView);
    recyclerView.setAdapter(listAdapter);

    recyclerView.setLayoutManager(new LinearLayoutManager(this));

  }

  @Override
  protected void onSaveInstanceState(Bundle outState) {
    super.onSaveInstanceState(outState);
    listAdapter.onSaveInstanceState(outState);
  }

  @Override
  protected void onRestoreInstanceState(Bundle savedInstanceState) {
    super.onRestoreInstanceState(savedInstanceState);
    listAdapter.onRestoreInstanceState(savedInstanceState);
  }

  @Override
  protected void onResume() {
    super.onResume();

    // load the data
    presenter.fetchUserPendingQueriesListData();
  }

  @Override
  public void injectPresenter(UserPendingQueriesListContract.Presenter presenter) {
    this.presenter = presenter;
  }

  @Override
  public void displayUserPendingQueriesListData(final UserPendingQueriesListViewModel viewModel) {
    runOnUiThread(new Runnable() {

      @Override
      public void run() {
        listAdapter.setItems(viewModel.pendingQueriesList);
      }
    });
  }

  @Override
  public boolean onOptionsItemSelected(MenuItem item) {
    // Handle presses on the action bar items
    switch (item.getItemId()) {
      case android.R.id.home:
        presenter.backButtonPressed();
        finish();
        return true;
      default:
        return super.onOptionsItemSelected(item);
    }
  }

}
