package es.ulpgc.montesdeoca110.cristina.zonget.administratorButtonsMenuList;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;

import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import es.ulpgc.montesdeoca110.cristina.zonget.R;
import es.ulpgc.montesdeoca110.cristina.zonget.app.AdministratorButtonMenuItem;

import java.lang.reflect.Method;

public class AdministratorButtonsMenuListActivity
        extends AppCompatActivity implements AdministratorButtonsMenuListContract.View {

  private AdministratorButtonsMenuListContract.Presenter presenter;

  //Elementos de la vista
  private Toolbar toolbar;

  private AdministratorButtonsMenuListAdapter listAdapter;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);

    AdministratorButtonsMenuListScreen.configure(this);

    //Theme
    String themeName = presenter.getActualThemeName();
    if (themeName != null) {
      int themeID = getResources().getIdentifier(themeName, "style", getPackageName());
      setTheme(themeID);
    }

    setContentView(R.layout.activity_administrator_buttons_menu_list);

    //Configuracion de la toolBar/actionBar
    toolbar = findViewById(R.id.toolbar);
    setSupportActionBar(toolbar);

    ActionBar actionBar = getSupportActionBar();
    actionBar.setTitle("Menú");


    //Listeners
    listAdapter = new AdministratorButtonsMenuListAdapter(new View.OnClickListener() {
      @Override
      public void onClick(View view) {
        AdministratorButtonMenuItem item = (AdministratorButtonMenuItem) view.getTag();
        presenter.selectAdministratorButtonsMenuListData(item);
      }
    });

    //RecycleView
    RecyclerView recyclerView = findViewById(R.id.administrator_buttons_menu_list);
    recyclerView.setAdapter(listAdapter);

    int columns = getResources().getInteger(R.integer.administrator_grid_colums);
    GridLayoutManager layoutManager = new GridLayoutManager(this, columns);
    recyclerView.setLayoutManager(layoutManager);


  }

  @Override
  protected void onResume() {
    super.onResume();
    presenter.checkThemeChanged();
    presenter.fetchAdministratorButtonsMenuListData();

  }

  @Override
  public void finish() {
    super.finish();
  }

  @Override
  public void reboot() {
    finish();
    Intent intent = getIntent();
    intent.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
    startActivity(intent);
  }

  @Override
  public void injectPresenter(AdministratorButtonsMenuListContract.Presenter presenter) {
    this.presenter = presenter;
  }

  @Override
  public boolean onCreateOptionsMenu(Menu menu) {
    MenuInflater inflater = getMenuInflater();
    inflater.inflate(R.menu.administrator_appbar_buttons_menu, menu);
    return super.onCreateOptionsMenu(menu);
  }

  @Override
  public void displayAdministratorButtonsMenuListData(final AdministratorButtonsMenuListViewModel viewModel) {
    runOnUiThread(new Runnable() {

      @Override
      public void run() {

        listAdapter.setItems(viewModel.administratorButtons);
      }
    });
  }

  private int getThemeId() {
    try {
      Class<?> wrapper = Context.class;
      Method method = wrapper.getMethod("getThemeResId");
      method.setAccessible(true);
      return (Integer) method.invoke(this);
    } catch (Exception e) {
      e.printStackTrace();
    }
    return 0;
  }

  @Override
  public boolean onOptionsItemSelected(MenuItem item) {

    switch (item.getItemId()) {
      case R.id.action_sign_out:
        presenter.signOutButtonPressed();
        return true;
      case R.id.action_settings:
        return true;
      case R.id.action_change_theme:
        presenter.changeThemeButtonPressed();
        return true;
      default:
        return super.onOptionsItemSelected(item);
    }
  }
}
