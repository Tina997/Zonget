package es.ulpgc.montesdeoca110.cristina.zonget.editPetForAdoption;

import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;

import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;

import es.ulpgc.montesdeoca110.cristina.zonget.R;
import es.ulpgc.montesdeoca110.cristina.zonget.petsForAdoptionDetail.PetsForAdoptionDetailActivity;

public class EditPetForAdoptionActivity
        extends AppCompatActivity implements EditPetForAdoptionContract.View {

  public static String TAG = EditPetForAdoptionActivity.class.getSimpleName();

  private EditPetForAdoptionContract.Presenter presenter;

  private ActionBar actionBar;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);

    EditPetForAdoptionScreen.configure(this);
    //Theme
    String themeName = presenter.getActualThemeName();
    if (themeName != null) {
      int themeID = getResources().getIdentifier(themeName, "style", getPackageName());
      setTheme(themeID);
    }

    setContentView(R.layout.activity_edit_pet_for_adoption);

    Toolbar toolbar = findViewById(R.id.toolbar);
    setSupportActionBar(toolbar);

    actionBar = getSupportActionBar();
    if (actionBar != null) {
      actionBar.setDisplayHomeAsUpEnabled(true);
      actionBar.setTitle(R.string.edit_pet_tittle);
    }


  }

  @Override
  protected void onResume() {
    super.onResume();

    // do some work
    presenter.fetchData();
  }

  @Override
  public void injectPresenter(EditPetForAdoptionContract.Presenter presenter) {
    this.presenter = presenter;
  }

  @Override
  public void displayData(EditPetForAdoptionViewModel viewModel) {
  }

  public void takePicture(View view) {
  }

  @Override
  public boolean onCreateOptionsMenu(Menu menu) {
    // Inflate the menu items for use in the action bar
    MenuInflater inflater = getMenuInflater();
    inflater.inflate(R.menu.edit_pet_for_adoption_menu, menu);
    return super.onCreateOptionsMenu(menu);
  }

  @Override
  public boolean onOptionsItemSelected(MenuItem item) {
    switch (item.getItemId()) {
      case R.id.action_accept:
        presenter.onAcceptButtonClicked();
        finish();
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
