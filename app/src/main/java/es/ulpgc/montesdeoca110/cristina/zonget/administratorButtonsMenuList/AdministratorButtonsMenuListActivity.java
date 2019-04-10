package es.ulpgc.montesdeoca110.cristina.zonget.administratorButtonsMenuList;

import android.content.pm.ActivityInfo;
import android.content.res.Configuration;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import es.ulpgc.montesdeoca110.cristina.zonget.app.AdministratorButtonMenuItem;
import es.ulpgc.montesdeoca110.cristina.zonget.R;

public class AdministratorButtonsMenuListActivity extends AppCompatActivity implements AdministratorButtonsMenuListContract.View {

    private AdministratorButtonsMenuListContract.Presenter presenter;

    //Elementos de la vista
    private Toolbar toolbar;

    private AdministratorButtonsMenuListAdapter listAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_administrator_buttons_menu_list);

        //Configuracion de la toolBar/actionBar
        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        ActionBar actionBar = getSupportActionBar();
        actionBar.setTitle("Menú");

        //Listeners
        listAdapter = new AdministratorButtonsMenuListAdapter(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AdministratorButtonMenuItem item = (AdministratorButtonMenuItem) view.getTag();
                presenter.selectAdministratorButtonsMenuListData(item);
            }
        });

        //RecycleView
        RecyclerView recyclerView = findViewById(R.id.administrator_buttons_menu_list);
        recyclerView.setAdapter(listAdapter);

        int columns = getResources().getInteger(R.integer.administrator_grid_colums);
        GridLayoutManager layoutManager = new GridLayoutManager(this, columns);
        recyclerView.setLayoutManager(layoutManager);

        // do the setup
        AdministratorButtonsMenuListScreen.configure(this);
    }

    @Override
    protected void onResume() {
        super.onResume();

        // do some work
        presenter.fetchAdministratorButtonsMenuListData();
    }

    @Override
    public void injectPresenter(AdministratorButtonsMenuListContract.Presenter presenter) {
        this.presenter = presenter;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu items for use in the action bar
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.administrator_appbar_buttons_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public void displayAdministratorButtonsMenuListData(final AdministratorButtonsMenuListViewModel viewModel) {

        runOnUiThread(new Runnable() {

            @Override
            public void run() {

                // deal with the data
                listAdapter.setItems(viewModel.administratorButtons);
            }
        });
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle presses on the action bar items
        switch (item.getItemId()) {
            case R.id.action_sign_out:
                presenter.signOutButtonPressed();
                return true;
            case R.id.action_settings:
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}
