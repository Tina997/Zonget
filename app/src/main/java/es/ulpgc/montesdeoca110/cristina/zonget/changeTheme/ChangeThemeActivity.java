package es.ulpgc.montesdeoca110.cristina.zonget.changeTheme;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;

import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;

import es.ulpgc.montesdeoca110.cristina.zonget.R;
import es.ulpgc.montesdeoca110.cristina.zonget.app.ChangeThemeItem;

public class ChangeThemeActivity extends AppCompatActivity implements ChangeThemeContract.View {

  private ChangeThemeContract.Presenter presenter;

  private ChangeThemeAdapter listAdapter;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);

    ChangeThemeScreen.configure(this);

    //Theme
    String themeName = presenter.getActualThemeName();
    if (themeName != null) {
      int themeID = getResources().getIdentifier(themeName, "style", getPackageName());
      setTheme(themeID);
    }

    setContentView(R.layout.activity_change_theme);

    //Configuracion de la toolBar/actionBar
    //Elementos de la vista
    Toolbar toolbar = findViewById(R.id.toolbar);
    setSupportActionBar(toolbar);

    ActionBar actionBar = getSupportActionBar();
    actionBar.setTitle("Temas");
    actionBar.setDisplayHomeAsUpEnabled(true);

    //Listeners
    listAdapter = new ChangeThemeAdapter(new View.OnClickListener() {
      @Override
      public void onClick(View view) {
        ChangeThemeItem item = (ChangeThemeItem) view.getTag();
        presenter.selectChangeThemeListData(item);
      }
    });

    //RecycleView
    RecyclerView recyclerView = findViewById(R.id.change_theme_list);
    recyclerView.setAdapter(listAdapter);

    GridLayoutManager layoutManager = new GridLayoutManager(this, 2);
    recyclerView.setLayoutManager(layoutManager);

  }

  @Override
  protected void onResume() {
    super.onResume();

    presenter.fetchChangeThemeListData();
  }

  @Override
  public void injectPresenter(ChangeThemeContract.Presenter presenter) {
    this.presenter = presenter;
  }

  @Override
  public void displayChangeThemeListData(final ChangeThemeViewModel viewModel) {
    runOnUiThread(new Runnable() {

      @Override
      public void run() {

        listAdapter.setItems(viewModel.themeList);
      }
    });
  }

  @Override
  public void reboot() {
    finish();
    overridePendingTransition(0, 0);
    Intent intent = getIntent();
    intent.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
    startActivity(intent);
  }

  @Override
  public void finish() {
    super.finish();
  }

  @Override
  public void onBackButtonPressed() {
    onBackPressed();
  }

  @Override
  public boolean onOptionsItemSelected(MenuItem item) {

    switch (item.getItemId()) {
      case android.R.id.home:
        presenter.backButtonPressed();
        return true;
      default:
        return super.onOptionsItemSelected(item);
    }
  }


}
