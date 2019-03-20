package es.ulpgc.montesdeoca110.cristina.zonget.clientPetsDetail;

import android.content.Intent;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.MenuItem;
import android.widget.TextView;

import es.ulpgc.montesdeoca110.cristina.zonget.R;
import es.ulpgc.montesdeoca110.cristina.zonget.app.PetsItem;
import es.ulpgc.montesdeoca110.cristina.zonget.clientPets.ClientPetsActivity;

public class ClientPetsDetailActivity
        extends AppCompatActivity implements ClientPetsDetailContract.View {

    public static String TAG = ClientPetsDetailActivity.class.getSimpleName();

    private ClientPetsDetailContract.Presenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_client_pets_detail);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        //Mostrar el botón atras y el titulo en la action bar
        ActionBar actionBar = getSupportActionBar();
        if(actionBar != null){
            actionBar.setDisplayHomeAsUpEnabled(true);
            actionBar.setTitle("Detalles animales");
        }

        // do the setup
        ClientPetsDetailScreen.configure(this);
    }

    @Override
    protected void onResume() {
        super.onResume();

        // do some work
        presenter.fetchPetsData();
    }

    @Override
    public void injectPresenter(ClientPetsDetailContract.Presenter presenter) {
        this.presenter = presenter;
    }

    @Override
    public void displayData(ClientPetsDetailViewModel viewModel) {
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
        int id = item.getItemId();
        if (id == android.R.id.home) {
            navigateUpTo(new Intent(this, ClientPetsActivity.class));
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
