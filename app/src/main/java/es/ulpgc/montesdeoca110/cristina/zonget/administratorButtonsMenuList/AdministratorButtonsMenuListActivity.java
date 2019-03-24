package es.ulpgc.montesdeoca110.cristina.zonget.administratorButtonsMenuList;

import android.support.v4.app.NavUtils;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.GridView;

import es.ulpgc.montesdeoca110.cristina.zonget.app.AdministratorButtonMenuItem;
import es.ulpgc.montesdeoca110.cristina.zonget.R;

public class AdministratorButtonsMenuListActivity extends AppCompatActivity implements AdministratorButtonsMenuListContract.View {

    public static String TAG = AdministratorButtonsMenuListActivity.class.getSimpleName();

    private AdministratorButtonsMenuListContract.Presenter presenter;

    //Elementos de la vista
    private Toolbar administrator_menu_toolbar;
    private GridView administrator_buttons_grid_view;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_administrator_buttons_menu_list);

        //Configuracion de la toolBar/actionBar
        administrator_menu_toolbar = findViewById(R.id.administrator_menu_toolbar);
        setSupportActionBar(administrator_menu_toolbar);

        //TODO añadir botón cerrar sesión

        ActionBar actionBar = getSupportActionBar();
        actionBar.setTitle("Menú");

        administrator_buttons_grid_view = findViewById(R.id.administrator_buttons_menu_list);

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
    public void displayAdministratorButtonsMenuListData(AdministratorButtonsMenuListViewModel viewModel) {

        // deal with the data
        administrator_buttons_grid_view.setAdapter(new AdministratorButtonsMenuListAdapter(
                this,viewModel.administrator_buttons,
                new View.OnClickListener() {

                    @Override
                    public void onClick(View view) {
                        AdministratorButtonMenuItem item = (AdministratorButtonMenuItem) view.getTag();
                        presenter.selectAdministratorButtonsMenuListData(item);
                    }
                })
        );
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle presses on the action bar items
        switch (item.getItemId()) {
            case R.id.action_sign_out:
                return true;
            case R.id.action_settings:
                return true;
            default:
                int id = item.getItemId();
                if (id == android.R.id.home) {
                    NavUtils.navigateUpFromSameTask(this);
                    return true;
                }
                return super.onOptionsItemSelected(item);
        }
    }

}
