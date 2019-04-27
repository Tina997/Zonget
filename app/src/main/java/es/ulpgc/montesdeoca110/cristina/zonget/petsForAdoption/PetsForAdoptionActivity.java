package es.ulpgc.montesdeoca110.cristina.zonget.petsForAdoption;

import android.content.Intent;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;

import es.ulpgc.montesdeoca110.cristina.zonget.R;
import es.ulpgc.montesdeoca110.cristina.zonget.app.PetForAdoptionItem;
import es.ulpgc.montesdeoca110.cristina.zonget.userButtonsMenuList.UserButtonsMenuListActivity;

public class PetsForAdoptionActivity
        extends AppCompatActivity implements PetsForAdoptionContract.View {

    public static String TAG = PetsForAdoptionActivity.class.getSimpleName();

    private PetsForAdoptionContract.Presenter presenter;

    private ActionBar actionBar;

    private PetsForAdoptionListAdapter listAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        PetsForAdoptionScreen.configure(this);

        //Theme
        String themeName = presenter.getActualThemeName();
        if (themeName != null){
            int themeID = getResources().getIdentifier(themeName,"style",getPackageName());
            setTheme(themeID);
        }

        setContentView(R.layout.activity_pets_for_adoption);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true);
            actionBar.setTitle(R.string.pets_for_adoption_activity_name);
        }

        listAdapter = new PetsForAdoptionListAdapter(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                PetForAdoptionItem petForAdoptionItem = (PetForAdoptionItem) v.getTag();
                presenter.selectPet(petForAdoptionItem);
            }
        });

        RecyclerView recyclerView = findViewById(R.id.pets_for_adoption_list);
        recyclerView.setAdapter(listAdapter);

    }

    @Override
    protected void onResume() {
        super.onResume();

        // do some work
        presenter.fetchPetsForAdoptionListData();
    }

    @Override
    public void injectPresenter(PetsForAdoptionContract.Presenter presenter) {
        this.presenter = presenter;
    }

    @Override
    public void displayData(final PetsForAdoptionViewModel viewModel) {
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                listAdapter.setItems(viewModel.petForAdoptionItems);
            }
        });
    }

    public void goToAddLostPet(View view) {
        presenter.gotToAddLostPet();
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == android.R.id.home) {
            presenter.onBackButtonPressed();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
