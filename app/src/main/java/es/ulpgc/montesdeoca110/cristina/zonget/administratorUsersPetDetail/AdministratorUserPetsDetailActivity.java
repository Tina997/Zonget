package es.ulpgc.montesdeoca110.cristina.zonget.administratorUsersPetDetail;

import android.content.Intent;
import android.support.v4.app.NavUtils;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.TextView;

import es.ulpgc.montesdeoca110.cristina.zonget.R;
import es.ulpgc.montesdeoca110.cristina.zonget.administratorUsersPets.AdministratorUsersPetsListActivity;
import es.ulpgc.montesdeoca110.cristina.zonget.app.PetsItem;
import es.ulpgc.montesdeoca110.cristina.zonget.userPets.UserPetsActivity;

public class AdministratorUserPetsDetailActivity
        extends AppCompatActivity implements AdministratorUserPetsDetailContract.View {

    public static String TAG = AdministratorUserPetsDetailActivity.class.getSimpleName();

    private AdministratorUserPetsDetailContract.Presenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_administrator_user_pets_detail);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        //Mostrar el botón atras y el title en la action bar
        ActionBar actionBar = getSupportActionBar();
        if(actionBar != null){
            actionBar.setDisplayHomeAsUpEnabled(true);
            actionBar.setTitle("Detalles animal");
        }
        // do the setup
        AdministratorUserPetsDetailScreen.configure(this);
    }

    @Override
    protected void onResume() {
        super.onResume();

        // do some work
        presenter.fetchData();
    }

    @Override
    public void injectPresenter(AdministratorUserPetsDetailContract.Presenter presenter) {
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
    public void displayData(AdministratorUserPetsDetailViewModel viewModel) {
        //Log.e(TAG, "displayData()");

        // deal with the data
        PetsItem petClientItem = viewModel.pet;
        if(petClientItem != null){
            ((TextView)findViewById(R.id.birthdayAnimalClient)).setText(petClientItem.birthday);
            ((TextView)findViewById(R.id.nameAnimalClient)).setText(petClientItem.name);
            ((TextView)findViewById(R.id.speciesAnimalClient)).setText(petClientItem.species);
            ((TextView)findViewById(R.id.breedAnimalClient)).setText(petClientItem.breed);
            ((TextView)findViewById(R.id.numberAnimalClient)).setText(petClientItem.chipNum);
        }
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.action_delete:
                return true;
            case R.id.action_edit:
                return true;
            default:
                int id = item.getItemId();
                if (id == android.R.id.home) {
                    navigateUpTo(new Intent(this, AdministratorUsersPetsListActivity.class));
                    return true;
                }
                return super.onOptionsItemSelected(item);
        }
    }
}
