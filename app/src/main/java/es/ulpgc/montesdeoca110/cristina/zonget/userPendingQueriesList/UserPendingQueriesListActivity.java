package es.ulpgc.montesdeoca110.cristina.zonget.userPendingQueriesList;

import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.widget.ExpandableListAdapter;
import android.widget.ExpandableListView;

import es.ulpgc.montesdeoca110.cristina.zonget.R;


public class UserPendingQueriesListActivity extends AppCompatActivity
        implements UserPendingQueriesListContract.View {

  private UserPendingQueriesListContract.Presenter presenter;

  //Elementos de la vista
  private Toolbar toolbar;
  private ExpandableListView pendingQueriesList;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_user_pending_queries_list);

    //Configuracion de la toolBar/actionBar
    toolbar = findViewById(R.id.toolbar);
    setSupportActionBar(toolbar);

    ActionBar actionBar = getSupportActionBar();
    actionBar.setTitle("Consultas pendientes");
    actionBar.setDisplayHomeAsUpEnabled(true);

    //Búsqueda de los elementos de la vista
    pendingQueriesList = findViewById(R.id.user_pending_queries_list);

    UserPendingQueriesListAdapter adapter = new UserPendingQueriesListAdapter();
    pendingQueriesList.setAdapter((ExpandableListAdapter) adapter);


    // do the setup
    UserPendingQueriesListScreen.configure(this);
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
  public void displayUserPendingQueriesListData(UserPendingQueriesListViewModel viewModel) {

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
