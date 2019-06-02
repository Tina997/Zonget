package es.ulpgc.montesdeoca110.cristina.zonget.addPetForAdoption;

import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

import es.ulpgc.montesdeoca110.cristina.zonget.R;

public class AddPetForAdoptionActivity
        extends AppCompatActivity implements AddPetForAdoptionContract.View {

  public static String TAG = AddPetForAdoptionActivity.class.getSimpleName();

  private AddPetForAdoptionContract.Presenter presenter;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);

    AddPetForAdoptionScreen.configure(this);

    //Theme
    String themeName = presenter.getActualThemeName();
    if (themeName != null) {
      int themeID = getResources().getIdentifier(themeName, "style", getPackageName());
      setTheme(themeID);
    }


    setContentView(R.layout.activity_add_pet_for_adoption);

    Toolbar toolbar = findViewById(R.id.toolbar);
    setSupportActionBar(toolbar);

    ActionBar actionBar = getSupportActionBar();
    if (actionBar != null) {
      actionBar.setDisplayHomeAsUpEnabled(true);
      actionBar.setTitle(R.string.add_pet_tittle);
    }

  }

  @Override
  protected void onResume() {
    super.onResume();

    // do some work
    presenter.fetchData();
  }

  @Override
  public void injectPresenter(AddPetForAdoptionContract.Presenter presenter) {
    this.presenter = presenter;
  }


  @Override
  public boolean onCreateOptionsMenu(Menu menu) {
    // Inflate the menu items for use in the action bar
    MenuInflater inflater = getMenuInflater();
    inflater.inflate(R.menu.add_pet_for_adoption_menu, menu);
    return super.onCreateOptionsMenu(menu);
  }

  @Override
  public boolean onOptionsItemSelected(MenuItem item) {
    switch (item.getItemId()) {
      case R.id.action_accept:
        presenter.onAcceptButtonClicked();
        return true;
      default:
        int id = item.getItemId();
        if (id == android.R.id.home) {
          //TODO destruir activity
          presenter.onBackButtonPressed();
          finish();
          return true;
        }
        return super.onOptionsItemSelected(item);
    }
  }
}
