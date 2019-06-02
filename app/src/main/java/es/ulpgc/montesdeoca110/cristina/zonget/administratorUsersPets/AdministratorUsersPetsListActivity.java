package es.ulpgc.montesdeoca110.cristina.zonget.administratorUsersPets;

import android.os.Parcelable;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.GridView;

import es.ulpgc.montesdeoca110.cristina.zonget.R;
import es.ulpgc.montesdeoca110.cristina.zonget.app.UserPetItem;

public class AdministratorUsersPetsListActivity
        extends AppCompatActivity implements AdministratorUsersPetsListContract.View {

    public static String TAG = AdministratorUsersPetsListActivity.class.getSimpleName();

    private AdministratorUsersPetsListContract.Presenter presenter;

    //private ListView listView;
    private AdministratorUsersPetsListAdapter listAdapter;
    private RecyclerView recyclerView;

    private GridView administratorUsersPetsGridView;
    private static Bundle bundle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // do the setup
        AdministratorUsersPetsListScreen.configure(AdministratorUsersPetsListActivity.this);

        //Theme
        String themeName = presenter.getActualThemeName();
        if (themeName != null){
            int themeID = getResources().getIdentifier(themeName,"style",getPackageName());
            setTheme(themeID);
        }
        setContentView(R.layout.activity_administrator_users_pets_list);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        //Mostrar el botón atras y el data en la action bar
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true);
            actionBar.setTitle(R.string.animal_client_tittle);
        }
        administratorUsersPetsGridView = findViewById(R.id.action_add);
        //listView = findViewById(R.id.animal_list);
        listAdapter = new AdministratorUsersPetsListAdapter(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                UserPetItem item = (UserPetItem) v.getTag();
                presenter.selectUserPetsData(item);
                finish();
            }
        });

        recyclerView = findViewById(R.id.pets_list);
        recyclerView.setAdapter(listAdapter);


        presenter.fetchUserPetsData();
    }

    @Override
    protected void onResume() {
        super.onResume();

        //restore ListView state
        if(bundle != null){
            Parcelable listState = bundle.getParcelable("state");
            recyclerView.getLayoutManager().onRestoreInstanceState(listState);
        }

        // do some work

    }

    @Override
    public void injectPresenter(AdministratorUsersPetsListContract.Presenter presenter) {
        this.presenter = presenter;
    }

    @Override
    public void displayUserPetsData(final AdministratorUsersPetsListViewModel viewModel) {
        //Log.e(TAG, "displayData()");
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                listAdapter.setItems(viewModel.pets);
            }
        });

      /*  listView.setAdapter(new AdministratorUsersPetsListAdapter(this, viewModel.pets, new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                UserPetItem item = (UserPetItem) v.getTag();
                presenter.selectUserPetsData(item);
                finish();
            }
        }));*/
        // deal with the data
    }

    @Override
    public void onPause(){
        super.onPause();
        //Save ListView state
        bundle = new Bundle();
        Parcelable listState = recyclerView.getLayoutManager().onSaveInstanceState();
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
