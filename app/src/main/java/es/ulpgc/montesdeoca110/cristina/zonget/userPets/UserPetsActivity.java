package es.ulpgc.montesdeoca110.cristina.zonget.userPets;

import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.ListView;

import es.ulpgc.montesdeoca110.cristina.zonget.R;
import es.ulpgc.montesdeoca110.cristina.zonget.app.UserPetItem;

public class UserPetsActivity
        extends AppCompatActivity implements UserPetsContract.View {

    public static String TAG = UserPetsActivity.class.getSimpleName();

    private UserPetsContract.Presenter presenter;
    //private ListView listView;
    private RecyclerView recyclerView;
    private UserPetsAdapter listAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        UserPetsScreen.configure(this);

        //Theme
        String themeName = presenter.getActualThemeName();
        if (themeName != null){
            int themeID = getResources().getIdentifier(themeName,"style",getPackageName());
            setTheme(themeID);
        }
        setContentView(R.layout.activity_user_pets);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        //Mostrar el botón atras y el data en la action bar
        ActionBar actionBar = getSupportActionBar();
        if(actionBar != null){
            actionBar.setDisplayHomeAsUpEnabled(true);
            actionBar.setTitle(R.string.animal_client_tittle);
        }
        listAdapter = new UserPetsAdapter(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                UserPetItem item = (UserPetItem) v.getTag();
                presenter.selectUserPetsData(item);
            }
        });

        recyclerView = findViewById(R.id.pets_list);
        recyclerView.setAdapter(listAdapter);
        //listView = findViewById(R.id.pets_list);

        // do the setup
        UserPetsScreen.configure(this);
        presenter.fetchUserPetsData();
    }

    @Override
    protected void onResume() {
        super.onResume();

        // do some work

    }

    @Override
    public void injectPresenter(UserPetsContract.Presenter presenter) {
        this.presenter = presenter;
    }

    @Override
    public void displayUserPetsData(final UserPetsViewModel viewModel) {
        //Log.e(TAG, "displayData()");
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                listAdapter.setItems(viewModel.pets);
            }
        });
        /*listView.setAdapter(new UserPetsAdapter(this, viewModel.pets, new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                UserPetItem item = (UserPetItem) v.getTag();
                presenter.selectUserPetsData(item);
            }
        }));*/
       // deal with the data
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