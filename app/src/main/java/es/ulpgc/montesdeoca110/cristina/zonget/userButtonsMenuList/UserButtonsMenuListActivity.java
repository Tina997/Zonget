package es.ulpgc.montesdeoca110.cristina.zonget.userButtonsMenuList;

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

import es.ulpgc.montesdeoca110.cristina.zonget.R;
import es.ulpgc.montesdeoca110.cristina.zonget.app.UserButtonMenuItem;

public class UserButtonsMenuListActivity extends AppCompatActivity implements UserButtonsMenuListContract.View {

    public static String TAG = UserButtonsMenuListActivity.class.getSimpleName();

    private UserButtonsMenuListContract.Presenter presenter;

    //Elementos de la vista
    private Toolbar user_menu_toolbar;
    private GridView user_buttons_grid_view;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_buttons_menu_list);

        //Configuracion de la toolBar/actionBar
        user_menu_toolbar = findViewById(R.id.user_menu_toolbar);
        setSupportActionBar(user_menu_toolbar);

        ActionBar actionBar = getSupportActionBar();
        actionBar.setTitle("Menú");

        user_buttons_grid_view = findViewById(R.id.user_buttons_menu_list);

        // do the setup
        UserButtonsMenuListScreen.configure(this);
    }

    @Override
    protected void onResume() {
        super.onResume();

        // do some work
        presenter.fetchUserButtonsMenuListData();
    }

    @Override
    public void injectPresenter(UserButtonsMenuListContract.Presenter presenter) {
        this.presenter = presenter;
    }

    @Override
    public void displayUserButtonsMenuListData(UserButtonsMenuListViewModel viewModel) {

        // deal with the data
        user_buttons_grid_view.setAdapter(new UserButtonsMenuListAdapter(
                this,viewModel.user_buttons,
                new View.OnClickListener() {

                    @Override
                    public void onClick(View view) {
                        UserButtonMenuItem item = (UserButtonMenuItem) view.getTag();
                        presenter.selectUserButtonsMenuListData(item);
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
