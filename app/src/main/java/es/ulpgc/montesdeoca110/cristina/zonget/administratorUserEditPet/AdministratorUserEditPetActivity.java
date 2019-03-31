package es.ulpgc.montesdeoca110.cristina.zonget.administratorUserEditPet;

import android.content.Intent;
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
import es.ulpgc.montesdeoca110.cristina.zonget.administratorUsersPetDetail.AdministratorUserPetsDetailActivity;

public class AdministratorUserEditPetActivity
        extends AppCompatActivity implements AdministratorUserEditPetContract.View {

    public static String TAG = AdministratorUserEditPetActivity.class.getSimpleName();

    private AdministratorUserEditPetContract.Presenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_administrator_user_edit_pet);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        //Mostrar el botón atras y el title en la action bar
        ActionBar actionBar = getSupportActionBar();
        if(actionBar != null){
            actionBar.setDisplayHomeAsUpEnabled(true);
            actionBar.setTitle(R.string.edit_pet_tittle);
        }
        // do the setup
        AdministratorUserEditPetScreen.configure(this);
    }

    @Override
    protected void onResume() {
        super.onResume();

        // do some work
        presenter.fetchData();
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu items for use in the action bar
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.administrator_appbar_buttons_add_edit_pet, menu);
        return super.onCreateOptionsMenu(menu);
    }
    @Override
    public void injectPresenter(AdministratorUserEditPetContract.Presenter presenter) {
        this.presenter = presenter;
    }

    @Override
    public void displayData(AdministratorUserEditPetViewModel viewModel) {
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
                    navigateUpTo(new Intent(this, AdministratorUserPetsDetailActivity.class));
                    return true;
                }
                return super.onOptionsItemSelected(item);
        }
    }
}
