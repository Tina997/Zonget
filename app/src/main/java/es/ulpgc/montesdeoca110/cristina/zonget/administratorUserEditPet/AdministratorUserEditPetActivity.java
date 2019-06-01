package es.ulpgc.montesdeoca110.cristina.zonget.administratorUserEditPet;

import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;

import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.EditText;

import es.ulpgc.montesdeoca110.cristina.zonget.R;
import es.ulpgc.montesdeoca110.cristina.zonget.app.UserPetItem;

public class AdministratorUserEditPetActivity
        extends AppCompatActivity implements AdministratorUserEditPetContract.View {

    public static String TAG = AdministratorUserEditPetActivity.class.getSimpleName();

    private AdministratorUserEditPetContract.Presenter presenter;

    private EditText nameText;
    private EditText speciesText;
    private EditText breedText;
    private EditText chipNumText;
    private EditText birthdayText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        AdministratorUserEditPetScreen.configure(this);

        //Theme
        String themeName = presenter.getActualThemeName();
        if (themeName != null) {
            int themeID = getResources().getIdentifier(themeName, "style", getPackageName());
            setTheme(themeID);
        }

        setContentView(R.layout.activity_administrator_user_edit_pet);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        //Mostrar el botón atras y el data en la action bar
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true);
            actionBar.setTitle(R.string.edit_pet_tittle);
        }
        nameText = findViewById(R.id.editPetName);
        speciesText = findViewById(R.id.editPetSpecies);
        breedText = findViewById(R.id.editPetBreed);
        chipNumText = findViewById(R.id.editPetChipNum);
        birthdayText = findViewById(R.id.editPetBirth);
        // do the setup
        AdministratorUserEditPetScreen.configure(this);
    }

    @Override
    protected void onResume() {
        super.onResume();
        // do some work
        UserPetItem userPetItem = presenter.fetchPetData();
        nameText.setText(userPetItem.getName());
        speciesText.setText(userPetItem.getSpecies());
        breedText.setText(userPetItem.getBreed());
        chipNumText.setText(userPetItem.getChipNum());
        birthdayText.setText(userPetItem.getBirthday());

    }

    //Añadir botones a la tabBar
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

    //Funcionalidad botones barra tareas
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.action_accept:
                UserPetItem userPetItem = newPet();
                presenter.insertNewPet(userPetItem);
                finish();
                return true;
            default:
                int id = item.getItemId();
                if (id == android.R.id.home) {
                    presenter.onBackButtonPressed();
                    finish();
                    return true;
                }
                return super.onOptionsItemSelected(item);
        }
    }

    private UserPetItem newPet() {
        int id = presenter.fetchPetData().getId();
        UserPetItem userPetItem = new UserPetItem(id,nameText.getText().toString(),speciesText.getText().toString(),breedText.getText().toString(),
                chipNumText.getText().toString(),birthdayText.getText().toString());
        return userPetItem;
    }
}