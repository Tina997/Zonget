package es.ulpgc.montesdeoca110.cristina.zonget.lostPets;

import android.content.Intent;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import es.ulpgc.montesdeoca110.cristina.zonget.R;
import es.ulpgc.montesdeoca110.cristina.zonget.app.LostPetItem;
import es.ulpgc.montesdeoca110.cristina.zonget.app.UserButtonMenuItem;
import es.ulpgc.montesdeoca110.cristina.zonget.userButtonsMenuList.UserButtonsMenuListActivity;

public class LostPetsListActivity
        extends AppCompatActivity implements LostPetsListContract.View {

    public static String TAG = LostPetsListActivity.class.getSimpleName();

    private LostPetsListContract.Presenter presenter;

    private ActionBar actionBar;

    private LostPetsListAdapter listAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lost_pets_list);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true);
            actionBar.setTitle(R.string.lost_pets_tittle);
        }
        listAdapter = new LostPetsListAdapter(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                LostPetItem petItem = (LostPetItem) v.getTag();
                presenter.selectPet(petItem);

            }
        });
        RecyclerView recyclerView = findViewById(R.id.category_list);
        recyclerView.setAdapter(listAdapter);
        // do the setup
        LostPetsListScreen.configure(this);
    }

    @Override
    protected void onResume() {
        super.onResume();

        // do some work
        presenter.fetchLostPetsListData();
    }

    @Override
    public void injectPresenter(LostPetsListContract.Presenter presenter) {
        this.presenter = presenter;
    }

    @Override
    public void displayLostPetsListData(final LostPetsListViewModel viewModel) {
        //Log.e(TAG, "displayData()");
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                listAdapter.setItems(viewModel.lostPetsItems);
            }
        });
        // deal with the data

    }
    public void goToAddLostPet(View view) {
        presenter.gotToAddLostPet();
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == android.R.id.home) {
            navigateUpTo(new Intent(this, UserButtonsMenuListActivity.class));
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

}
