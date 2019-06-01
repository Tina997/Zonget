package es.ulpgc.montesdeoca110.cristina.zonget.administratorQueryDetail;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.TextView;

import es.ulpgc.montesdeoca110.cristina.zonget.R;
import es.ulpgc.montesdeoca110.cristina.zonget.administratorInbox.AdministratorInboxActivity;

public class AdministratorQueryDetailActivity
        extends AppCompatActivity implements AdministratorQueryDetailContract.View {

  public static String TAG = AdministratorQueryDetailActivity.class.getSimpleName();

  private AdministratorQueryDetailContract.Presenter presenter;
  TextView queryTitle;
  TextView queryDescription;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);

    AdministratorQueryDetailScreen.configure(this);

    //Theme
    String themeName = presenter.getActualThemeName();
    if (themeName != null) {
      int themeID = getResources().getIdentifier(themeName, "style", getPackageName());
      setTheme(themeID);
    }

    setContentView(R.layout.activity_administrator_query_detail);

    Toolbar toolbar = findViewById(R.id.toolbar);
    setSupportActionBar(toolbar);

    // Show the data in the action bar
    ActionBar actionBar = getSupportActionBar();
    if (actionBar != null) {
      actionBar.setDisplayHomeAsUpEnabled(true);
      actionBar.setTitle(getString(R.string.administrator_query_detail_activity_name));
    }

    queryTitle = findViewById(R.id.queryTitle);
    queryDescription = findViewById(R.id.queryDescription);


  }

  @Override
  protected void onResume() {
    super.onResume();

    // do some work
    presenter.fetchData();
  }

  @Override
  public void injectPresenter(AdministratorQueryDetailContract.Presenter presenter) {
    this.presenter = presenter;
  }

  @Override
  public boolean onCreateOptionsMenu(Menu menu) {
    // Inflate the menu items for use in the action bar
    MenuInflater inflater = getMenuInflater();
    inflater.inflate(R.menu.administrator_query_detail_menu, menu);
    return super.onCreateOptionsMenu(menu);
  }

  @Override
  public boolean onOptionsItemSelected(MenuItem item) {
    switch (item.getItemId()) {
      case R.id.action_reply:
        presenter.navigateToAdministratorQueryAnswerScreen();
        return true;
      default:
        int id = item.getItemId();
        if (id == android.R.id.home) {
          navigateUpTo(new Intent(this, AdministratorInboxActivity.class));
          return true;
        }
        return super.onOptionsItemSelected(item);
    }
  }

  @Override
  public void displayData(AdministratorQueryDetailViewModel viewModel) {
    queryTitle.setText(viewModel.queryItem.title);
    queryDescription.setText(viewModel.queryItem.content);
  }
}
