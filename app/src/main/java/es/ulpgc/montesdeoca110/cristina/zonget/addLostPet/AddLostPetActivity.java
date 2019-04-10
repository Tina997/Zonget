package es.ulpgc.montesdeoca110.cristina.zonget.addLostPet;

import android.content.Intent;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;

import es.ulpgc.montesdeoca110.cristina.zonget.R;
import es.ulpgc.montesdeoca110.cristina.zonget.petsForAdoption.PetsForAdoptionActivity;

public class AddLostPetActivity
        extends AppCompatActivity implements AddLostPetContract.View {

    public static String TAG = AddLostPetActivity.class.getSimpleName();

    private AddLostPetContract.Presenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_lost_pet);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        // Configuracion actionBar y AppBar
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true);
            actionBar.setTitle(getString(R.string.add_pet_tittle));
        }

        // do the setup
        AddLostPetScreen.configure(this);
    }

    @Override
    protected void onResume() {
        super.onResume();

        // do some work
//        presenter.fetchData();
    }

    @Override
    public void injectPresenter(AddLostPetContract.Presenter presenter) {
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
    public void displayData(AddLostPetViewModel viewModel) {
        //Log.e(TAG, "displayData()");

        // deal with the data
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.action_accept:
                //presenter.insertNewPet();
                return true;
            default:
                int id = item.getItemId();
                if (id == android.R.id.home) {
                    //TODO matar la activity
                    navigateUpTo(new Intent(this, PetsForAdoptionActivity.class));
                    return true;
                }
                return super.onOptionsItemSelected(item);
        }
    }

    public void takePicture(View view) {
        //TODO acceder a la camara o galeria para coger la imagen
    }
}
