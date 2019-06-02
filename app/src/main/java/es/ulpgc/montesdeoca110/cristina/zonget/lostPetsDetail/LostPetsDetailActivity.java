package es.ulpgc.montesdeoca110.cristina.zonget.lostPetsDetail;

import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;

import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.RequestBuilder;
import com.bumptech.glide.RequestManager;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.request.RequestOptions;

import es.ulpgc.montesdeoca110.cristina.zonget.R;

import es.ulpgc.montesdeoca110.cristina.zonget.app.LostPetItem;

public class LostPetsDetailActivity
        extends AppCompatActivity implements LostPetsDetailContract.View {

  public static String TAG = LostPetsDetailActivity.class.getSimpleName();

  private LostPetsDetailContract.Presenter presenter;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    LostPetsDetailScreen.configure(this);

    //Theme
    String themeName = presenter.getActualThemeName();
    if (themeName != null) {
      int themeID = getResources().getIdentifier(themeName, "style", getPackageName());
      setTheme(themeID);
    }
    setContentView(R.layout.activity_lost_pets_detail);
    Toolbar toolbar = findViewById(R.id.toolbar);
    setSupportActionBar(toolbar);

    ActionBar actionBar = getSupportActionBar();
    if (actionBar != null) {
      actionBar.setDisplayHomeAsUpEnabled(true);
      actionBar.setTitle(R.string.animal_detail_tittle);
    }

    // do the setup
    LostPetsDetailScreen.configure(this);
  }

  @Override
  protected void onResume() {
    super.onResume();

    // do some work
    presenter.fetchLostPetDetailData();
  }

  @Override
  public void injectPresenter(LostPetsDetailContract.Presenter presenter) {
    this.presenter = presenter;
  }

  @Override
  public boolean onCreateOptionsMenu(Menu menu) {
    // Inflate the menu items for use in the action bar
    MenuInflater inflater = getMenuInflater();
    inflater.inflate(R.menu.administrator_appbar_buttons_user_pet_detail, menu);
    return super.onCreateOptionsMenu(menu);
  }

  @Override
  public void displayLostPetDetailData(LostPetsDetailViewModel viewModel) {
    //Log.e(TAG, "displayData()");
    LostPetItem lostPetItem = viewModel.lostPetItem;
    // deal with the data
    loadImageFromURL((ImageView) findViewById(R.id.lost_pet_image), lostPetItem.picture);
    ((TextView) findViewById(R.id.lost_pet_name)).setText(lostPetItem.name);
    ((TextView) findViewById(R.id.lost_pet_date)).setText(lostPetItem.date);
    ((TextView) findViewById(R.id.lost_pet_breed)).setText(lostPetItem.breed);
    ((TextView) findViewById(R.id.lost_pet_chipNum)).setText(lostPetItem.chipNum);
    ((TextView) findViewById(R.id.lost_pet_details)).setText(lostPetItem.details);
    ((TextView) findViewById(R.id.lost_pet_phone)).setText(lostPetItem.phoneNum);

  }

  @Override
  public void onDeleteButtonClicked() {
    presenter.deletePet();
  }

  private void loadImageFromURL(ImageView imageView, String imageUrl) {
    RequestManager reqManager = Glide.with(imageView.getContext());
    RequestBuilder reqBuilder = reqManager.load(imageUrl);
    RequestOptions reqOptions = new RequestOptions();
    reqOptions.diskCacheStrategy(DiskCacheStrategy.ALL);
    reqBuilder.apply(reqOptions);
    reqBuilder.into(imageView);
  }

  @Override
  public boolean onOptionsItemSelected(MenuItem item) {
    switch (item.getItemId()) {
      case R.id.action_delete:
        FragmentManager fragmentManager = getSupportFragmentManager();
        DialogDelete dialogo = new DialogDelete(this);
        dialogo.show(fragmentManager, "tagAlerta");
        return true;
      case R.id.action_edit:
        presenter.onEditButtonClicked();
        return true;
      default:
        int id = item.getItemId();
        if (id == android.R.id.home) {
          presenter.onBackButtonClicked();
          finish();
          return true;
        }
        return super.onOptionsItemSelected(item);
    }
  }
}
