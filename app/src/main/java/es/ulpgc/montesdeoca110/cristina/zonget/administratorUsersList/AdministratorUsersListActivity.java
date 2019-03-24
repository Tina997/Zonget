package es.ulpgc.montesdeoca110.cristina.zonget.administratorUsersList;

import android.content.Intent;
import android.support.v4.app.NavUtils;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.widget.ListView;
import es.ulpgc.montesdeoca110.cristina.zonget.R;
import es.ulpgc.montesdeoca110.cristina.zonget.administratorSearchUsers.AdministratorSearchUsersActivity;
import es.ulpgc.montesdeoca110.cristina.zonget.userPets.UserPetsActivity;

public class AdministratorUsersListActivity
        extends AppCompatActivity implements AdministratorUsersListContract.View {

    public static String TAG = AdministratorUsersListActivity.class.getSimpleName();

    private AdministratorUsersListContract.Presenter presenter;
    private ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_administrator_users_list);
        Toolbar toolbar = (Toolbar)findViewById(R.id.toolbarAdminUsers);
        setSupportActionBar(toolbar);

        //Mostrar el botón atras y el titulo en la action bar
        ActionBar actionBar = getSupportActionBar();
        if(actionBar != null){
            actionBar.setDisplayHomeAsUpEnabled(true);
            actionBar.setTitle("Clientes");
        }

        listView = findViewById(R.id.user_list);

        // do the setup
        AdministratorUsersListScreen.configure(this);
    }

    @Override
    protected void onResume() {
        super.onResume();

        // do some work
        presenter.fetchAdminUsersData();
    }

    @Override
    public void injectPresenter(AdministratorUsersListContract.Presenter presenter) {
        this.presenter = presenter;
    }

    @Override
    public void displayData(AdministratorUsersListViewModel viewModel) {
        //Log.e(TAG, "displayData()");

        // deal with the data
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == android.R.id.home) {
            navigateUpTo(new Intent(this, AdministratorSearchUsersActivity.class));
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
