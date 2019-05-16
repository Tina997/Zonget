package es.ulpgc.montesdeoca110.cristina.zonget.administratorUsersPets;

import android.content.Intent;
import android.os.Parcelable;
import android.support.v4.app.NavUtils;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.GridView;
import android.widget.ListView;
import android.widget.TextView;

import es.ulpgc.montesdeoca110.cristina.zonget.R;
import es.ulpgc.montesdeoca110.cristina.zonget.administratorSearchUsers.AdministratorSearchUsersActivity;
import es.ulpgc.montesdeoca110.cristina.zonget.administratorUsersAddPet.AdministratorUsersAddPetActivity;
import es.ulpgc.montesdeoca110.cristina.zonget.administratorUsersAddPet.AdministratorUsersAddPetScreen;
import es.ulpgc.montesdeoca110.cristina.zonget.administratorUsersList.AdministratorUsersListActivity;
import es.ulpgc.montesdeoca110.cristina.zonget.app.PetsItem;
import es.ulpgc.montesdeoca110.cristina.zonget.app.UserPetItem;
import es.ulpgc.montesdeoca110.cristina.zonget.userPets.UserPetsAdapter;

public class AdministratorUsersPetsListActivity
        extends AppCompatActivity implements AdministratorUsersPetsListContract.View {

    public static String TAG = AdministratorUsersPetsListActivity.class.getSimpleName();

    private AdministratorUsersPetsListContract.Presenter presenter;

    private ListView listView;

    private GridView administratorUsersPetsGridView;
    private static Bundle bundle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        AdministratorUsersPetsListScreen.configure(this);

        //Theme
        String themeName = presenter.getActualThemeName();
        if (themeName != null){
            int themeID = getResources().getIdentifier(themeName,"style",getPackageName());
            setTheme(themeID);
        }
        setContentView(R.layout.activity_administrator_users_pets_list);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        //Mostrar el botón atras y el title en la action bar
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true);
            actionBar.setTitle(R.string.animal_client_tittle);
        }
        administratorUsersPetsGridView = findViewById(R.id.action_add);
        listView = findViewById(R.id.animal_list);

        // do the setup
        AdministratorUsersPetsListScreen.configure(this);
        presenter.fetchUserPetsData();
    }

    @Override
    protected void onResume() {
        super.onResume();

        //restore ListView state
        if(bundle != null){
            Parcelable listState = bundle.getParcelable("state");
            listView.onRestoreInstanceState(listState);
        }

        // do some work

    }

    @Override
    public void injectPresenter(AdministratorUsersPetsListContract.Presenter presenter) {
        this.presenter = presenter;
    }

    @Override
    public void displayUserPetsData(AdministratorUsersPetsListViewModel viewModel) {
        //Log.e(TAG, "displayData()");
        listView.setAdapter(new UserPetsAdapter(this, viewModel.pets, new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                UserPetItem item = (UserPetItem) v.getTag();
                presenter.selectUserPetsData(item);
            }
        }));
        // deal with the data
    }

    @Override
    public void onPause(){
        super.onPause();

        //Save ListView state
        bundle = new Bundle();
        Parcelable listState = listView.onSaveInstanceState();
        bundle.putParcelable("state", listState);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu items for use in the action bar
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.administrator_appbar_buttons_users_pets_list, menu);
        return super.onCreateOptionsMenu(menu);
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.action_add:
                presenter.onClickAddButton();
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
}
