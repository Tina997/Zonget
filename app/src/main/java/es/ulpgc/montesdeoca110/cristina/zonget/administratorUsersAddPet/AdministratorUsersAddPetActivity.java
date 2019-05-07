package es.ulpgc.montesdeoca110.cristina.zonget.administratorUsersAddPet;

import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;

import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import es.ulpgc.montesdeoca110.cristina.zonget.R;

public class AdministratorUsersAddPetActivity
        extends AppCompatActivity implements AdministratorUsersAddPetContract.View {

  public static String TAG = AdministratorUsersAddPetActivity.class.getSimpleName();

  private AdministratorUsersAddPetContract.Presenter presenter;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    AdministratorUsersAddPetScreen.configure(this);

    //Theme
    String themeName = presenter.getActualThemeName();
    if (themeName != null) {
      int themeID = getResources().getIdentifier(themeName, "style", getPackageName());
      setTheme(themeID);
    }
    setContentView(R.layout.activity_administrator_users_add_pet);
    Toolbar toolbar = findViewById(R.id.toolbar);
    setSupportActionBar(toolbar);

    //Mostrar el botón atras y el title en la action bar
    ActionBar actionBar = getSupportActionBar();
    if (actionBar != null) {
      actionBar.setDisplayHomeAsUpEnabled(true);
      actionBar.setTitle(R.string.add_pet_tittle);
    }
    // do the setup
    AdministratorUsersAddPetScreen.configure(this);
  }

  @Override
  protected void onResume() {
    super.onResume();

    // do some work
    //presenter.fetchPetsForAdoptionListData();
  }

  @Override
  public void injectPresenter(AdministratorUsersAddPetContract.Presenter presenter) {
    this.presenter = presenter;
  }

  @Override
  public boolean onCreateOptionsMenu(Menu menu) {
    // Inflate the menu items for use in the action bar
    MenuInflater inflater = getMenuInflater();
    inflater.inflate(R.menu.administrator_appbar_buttons_add_edit_pet, menu);
    return super.onCreateOptionsMenu(menu);
  }

  @Override
  public void displayData(AdministratorUsersAddPetViewModel viewModel) {
    //Log.e(TAG, "displayData()");

    // deal with the data
  }

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
