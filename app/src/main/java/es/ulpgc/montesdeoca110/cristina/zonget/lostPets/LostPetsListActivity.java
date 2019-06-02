package es.ulpgc.montesdeoca110.cristina.zonget.lostPets;

import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;

import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;

import es.ulpgc.montesdeoca110.cristina.zonget.R;

import es.ulpgc.montesdeoca110.cristina.zonget.app.LostPetItem;

public class LostPetsListActivity
        extends AppCompatActivity implements LostPetsListContract.View {

  public static String TAG = LostPetsListActivity.class.getSimpleName();

  private LostPetsListContract.Presenter presenter;

  private LostPetsListAdapter listAdapter;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    LostPetsListScreen.configure(this);

    //Theme
    String themeName = presenter.getActualThemeName();
    if (themeName != null) {
      int themeID = getResources().getIdentifier(themeName, "style", getPackageName());
      setTheme(themeID);
    }
    setContentView(R.layout.activity_lost_pets_list);

    Toolbar toolbar = findViewById(R.id.toolbar);
    setSupportActionBar(toolbar);

    ActionBar actionBar = getSupportActionBar();
    if (actionBar != null) {
      actionBar.setDisplayHomeAsUpEnabled(true);
      actionBar.setTitle(R.string.lost_pets_tittle);
    }
    listAdapter = new LostPetsListAdapter(new View.OnClickListener() {
      @Override
      public void onClick(View v) {
        LostPetItem petItem = (LostPetItem) v.getTag();
        presenter.selectPet(petItem);

      }
    });
    RecyclerView recyclerView = findViewById(R.id.lost_pet_list);
    recyclerView.setAdapter(listAdapter);
    int columns = getResources().getInteger(R.integer.lost_pet_grid_colums);
    GridLayoutManager layoutManager = new GridLayoutManager(this, columns);
    recyclerView.setLayoutManager(layoutManager);
    // do the setup
    LostPetsListScreen.configure(this);
  }

  @Override
  protected void onResume() {
    super.onResume();

    // do some work
    presenter.fetchLostPetsListData();
  }

  @Override
  public void injectPresenter(LostPetsListContract.Presenter presenter) {
    this.presenter = presenter;
  }

  @Override
  public void displayLostPetsListData(final LostPetsListViewModel viewModel) {
    //Log.e(TAG, "displayData()");
    runOnUiThread(new Runnable() {
      @Override
      public void run() {
        listAdapter.setItems(viewModel.lostPetsItems);
      }
    });
    // deal with the data

  }

  public void goToAddLostPet(View view) {
    presenter.gotToAddLostPet();
  }

  @Override
  public boolean onOptionsItemSelected(MenuItem item) {
    int id = item.getItemId();
    if (id == android.R.id.home) {
      presenter.onBackButtonPressed();
      finish();
      return true;
    }
    return super.onOptionsItemSelected(item);
  }

}
