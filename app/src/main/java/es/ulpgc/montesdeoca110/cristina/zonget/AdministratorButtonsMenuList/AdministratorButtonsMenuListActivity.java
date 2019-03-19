package es.ulpgc.montesdeoca110.cristina.zonget.AdministratorButtonsMenuList;

import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.widget.GridView;

import es.ulpgc.montesdeoca110.cristina.zonget.R;

public class AdministratorButtonsMenuListActivity extends AppCompatActivity implements AdministratorMenuButtonsListContract.View {

    public static String TAG = AdministratorButtonsMenuListActivity.class.getSimpleName();

    private AdministratorMenuButtonsListContract.Presenter presenter;

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
        //presenter.fetchData();
    }

    @Override
    public void injectPresenter(AdministratorMenuButtonsListContract.Presenter presenter) {
        this.presenter = presenter;
    }

    @Override
    public void displayData(AdministratorButtonsMenuListViewModel viewModel) {
        //Log.e(TAG, "displayData()");

        // deal with the data
        //((TextView) findViewById(R.id.data)).setText(viewModel.data);
    }
}
