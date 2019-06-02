package es.ulpgc.montesdeoca110.cristina.zonget.userFinishedQueriesList;

import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;

import java.util.ArrayList;

import es.ulpgc.montesdeoca110.cristina.zonget.R;
import es.ulpgc.montesdeoca110.cristina.zonget.app.Query;


public class UserFinishedQueriesListActivity extends AppCompatActivity implements UserFinishedQueriesListContract.View {

  private UserFinishedQueriesListContract.Presenter presenter;

  private UserFinishedQueriesListAdapter listAdapter;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);

    UserFinishedQueriesListScreen.configure(this);

    //Theme
    String themeName = presenter.getActualThemeName();
    if (themeName != null) {
      int themeID = getResources().getIdentifier(themeName, "style", getPackageName());
      setTheme(themeID);
    }

    setContentView(R.layout.activity_user_finished_queries_list);

    //Configuracion de la toolBar/actionBar
    //Elementos de la vista
    Toolbar toolbar = findViewById(R.id.toolbar);
    setSupportActionBar(toolbar);

    ActionBar actionBar = getSupportActionBar();
    actionBar.setTitle("Consultas finalizadas");
    actionBar.setDisplayHomeAsUpEnabled(true);

    listAdapter = new UserFinishedQueriesListAdapter(this,new ArrayList<Query>());

    //RecycleView
    RecyclerView recyclerView = findViewById(R.id.user_finished_queries_list_recycleView);
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

    presenter.fetchUserFinishedQueriesListData();
  }

  @Override
  public void injectPresenter(UserFinishedQueriesListContract.Presenter presenter) {
    this.presenter = presenter;
  }

  @Override
  public void displayUserFinishedQueriesListData(final UserFinishedQueriesListViewModel viewModel) {
      runOnUiThread(new Runnable() {
          @Override
          public void run() {
            listAdapter.setItems(viewModel.finishedQueriesList);
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
