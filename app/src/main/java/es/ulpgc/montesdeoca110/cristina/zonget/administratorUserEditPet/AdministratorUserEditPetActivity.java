package es.ulpgc.montesdeoca110.cristina.zonget.administratorUserEditPet;

import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;

import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

import es.ulpgc.montesdeoca110.cristina.zonget.R;

public class AdministratorUserEditPetActivity
        extends AppCompatActivity implements AdministratorUserEditPetContract.View {

  public static String TAG = AdministratorUserEditPetActivity.class.getSimpleName();

  private AdministratorUserEditPetContract.Presenter presenter;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    AdministratorUserEditPetScreen.configure(this);

    //Theme
    String themeName = presenter.getActualThemeName();
    if (themeName != null) {
      int themeID = getResources().getIdentifier(themeName, "style", getPackageName());
      setTheme(themeID);
    }

    setContentView(R.layout.activity_administrator_user_edit_pet);
    Toolbar toolbar = findViewById(R.id.toolbar);
    setSupportActionBar(toolbar);

    //Mostrar el botón atras y el title en la action bar
    ActionBar actionBar = getSupportActionBar();
    if (actionBar != null) {
      actionBar.setDisplayHomeAsUpEnabled(true);
      actionBar.setTitle(R.string.edit_pet_tittle);
    }
    // do the setup
    AdministratorUserEditPetScreen.configure(this);
  }

  @Override
  protected void onResume() {
    super.onResume();

    // do some work
    presenter.fetchData();
  }

  //Añadir botones a la tabBar
  @Override
  public boolean onCreateOptionsMenu(Menu menu) {
    // Inflate the menu items for use in the action bar
    MenuInflater inflater = getMenuInflater();
    inflater.inflate(R.menu.administrator_appbar_buttons_add_edit_pet, menu);
    return super.onCreateOptionsMenu(menu);
  }

  @Override
  public void injectPresenter(AdministratorUserEditPetContract.Presenter presenter) {
    this.presenter = presenter;
  }

  //TODO metodo a limpiar
  @Override
  public void displayData(AdministratorUserEditPetViewModel viewModel) {
    //Log.e(TAG, "displayData()");

    // deal with the data
  }

  //Funcionalidad botones barra tareas
  @Override
  public boolean onOptionsItemSelected(MenuItem item) {
    switch (item.getItemId()) {
      case R.id.action_accept:
        presenter.insertNewPet();
        return true;
      default:
        int id = item.getItemId();
        if (id == android.R.id.home) {
          presenter.onBackButtonPressed();
          finish();
          return true;
        }
        return super.onOptionsItemSelected(item);
    }
  }
}
