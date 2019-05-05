package es.ulpgc.montesdeoca110.cristina.zonget.userPetsDetail;

import android.content.Intent;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.widget.TextView;

import es.ulpgc.montesdeoca110.cristina.zonget.R;
import es.ulpgc.montesdeoca110.cristina.zonget.app.PetsItem;
import es.ulpgc.montesdeoca110.cristina.zonget.app.UserPetItem;
import es.ulpgc.montesdeoca110.cristina.zonget.userPets.UserPetsActivity;

public class UserPetsDetailActivity
        extends AppCompatActivity implements UserPetsDetailContract.View {

    public static String TAG = UserPetsDetailActivity.class.getSimpleName();

    private UserPetsDetailContract.Presenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        UserPetsDetailScreen.configure(this);

        //Theme
        String themeName = presenter.getActualThemeName();
        if (themeName != null){
            int themeID = getResources().getIdentifier(themeName,"style",getPackageName());
            setTheme(themeID);
        }
        setContentView(R.layout.activity_user_pets_detail);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        //Mostrar el botón atras y el title en la action bar
        ActionBar actionBar = getSupportActionBar();
        if(actionBar != null){
            actionBar.setDisplayHomeAsUpEnabled(true);
            actionBar.setTitle(R.string.animal_detail_tittle);
        }

        // do the setup
        UserPetsDetailScreen.configure(this);
    }

    @Override
    protected void onResume() {
        super.onResume();

        // do some work
        presenter.fetchPetsData();
    }

    @Override
    public void injectPresenter(UserPetsDetailContract.Presenter presenter) {
        this.presenter = presenter;
    }

    @Override
    public void displayData(UserPetsDetailViewModel viewModel) {
        //Log.e(TAG, "displayData()");

        // deal with the data
        UserPetItem petClientItem = viewModel.pet;
        if(petClientItem != null){
            ((TextView)findViewById(R.id.birthdayAnimalClient)).setText(petClientItem.getBirthday());
            ((TextView)findViewById(R.id.nameAnimalClient)).setText(petClientItem.getName());
            ((TextView)findViewById(R.id.speciesAnimalClient)).setText(petClientItem.getSpecies());
            ((TextView)findViewById(R.id.breedAnimalClient)).setText(petClientItem.getBreed());
            ((TextView)findViewById(R.id.numberAnimalClient)).setText(petClientItem.getChipNum());
        }
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == android.R.id.home) {
            presenter.onBackButtonClicked();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
