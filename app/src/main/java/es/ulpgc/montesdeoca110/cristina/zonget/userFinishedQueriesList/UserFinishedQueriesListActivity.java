package es.ulpgc.montesdeoca110.cristina.zonget.userFinishedQueriesList;

import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;

import android.support.v7.widget.Toolbar;
import android.view.MenuItem;

import es.ulpgc.montesdeoca110.cristina.zonget.R;


public class UserFinishedQueriesListActivity extends AppCompatActivity
        implements UserFinishedQueriesListContract.View {

  private UserFinishedQueriesListContract.Presenter presenter;

  //Elementos de la vista
  private Toolbar toolbar;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_user_finished_queries_list);

    //Configuracion de la toolBar/actionBar
    toolbar = findViewById(R.id.toolbar);
    setSupportActionBar(toolbar);

    ActionBar actionBar = getSupportActionBar();
    actionBar.setTitle("Consultas finalizadas");
    actionBar.setDisplayHomeAsUpEnabled(true);

    //Búsqueda de los elementos de la vista


    // do the setup
    UserFinishedQueriesListScreen.configure(this);
  }

  @Override
  protected void onResume() {
    super.onResume();

    // load the data
    presenter.fetchUserFinishedQueriesListData();
  }

  @Override
  public void injectPresenter(UserFinishedQueriesListContract.Presenter presenter) {
    this.presenter = presenter;
  }

  @Override
  public void displayUserFinishedQueriesListData(UserFinishedQueriesListViewModel viewModel) {

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
