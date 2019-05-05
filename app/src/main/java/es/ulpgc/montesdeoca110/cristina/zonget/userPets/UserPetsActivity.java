package es.ulpgc.montesdeoca110.cristina.zonget.userPets;

import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;

import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.ListView;

import es.ulpgc.montesdeoca110.cristina.zonget.R;
import es.ulpgc.montesdeoca110.cristina.zonget.app.PetsItem;

public class UserPetsActivity
        extends AppCompatActivity implements UserPetsContract.View {

  public static String TAG = UserPetsActivity.class.getSimpleName();

  private UserPetsContract.Presenter presenter;
  private ListView listView;
  private UserPetsAdapter listAdapter;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    UserPetsScreen.configure(this);

    //Theme
    String themeName = presenter.getActualThemeName();
    if (themeName != null) {
      int themeID = getResources().getIdentifier(themeName, "style", getPackageName());
      setTheme(themeID);
    }
    setContentView(R.layout.activity_user_pets);
    Toolbar toolbar = findViewById(R.id.toolbar);
    setSupportActionBar(toolbar);

    //Mostrar el botón atras y el title en la action bar
    ActionBar actionBar = getSupportActionBar();
    if (actionBar != null) {
      actionBar.setDisplayHomeAsUpEnabled(true);
      actionBar.setTitle(R.string.animal_client_tittle);
    }
    listView = findViewById(R.id.animal_list);

    // do the setup
    UserPetsScreen.configure(this);

  }

  @Override
  protected void onResume() {
    super.onResume();

    // do some work
    presenter.fetchUserPetsData();
  }

  @Override
  public void injectPresenter(UserPetsContract.Presenter presenter) {
    this.presenter = presenter;
  }

  @Override
  public void displayUserPetsData(final UserPetsViewModel viewModel) {
    //Log.e(TAG, "displayData()");
    /*listView.setAdapter(new UserPetsAdapter(this, viewModel.pets, new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            PetsItem item = (PetsItem) v.getTag();
            presenter.selectUserPetsData(item);
        }
    }));*/
    listAdapter = new UserPetsAdapter(this, viewModel.pets, new View.OnClickListener() {

      @Override
      public void onClick(View view) {
        PetsItem item = (PetsItem) view.getTag();
        presenter.selectUserPetsData(item);
      }
    });
    runOnUiThread(new Runnable() {
      @Override
      public void run() {
        listAdapter.setItems(viewModel.pets);
      }
    });
    // deal with the data
  }

  @Override
  public boolean onOptionsItemSelected(MenuItem item) {
    int id = item.getItemId();
    if (id == android.R.id.home) {
      presenter.onBackButtonPressed();
      return true;
    }
    return super.onOptionsItemSelected(item);
  }
}