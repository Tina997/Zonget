package es.ulpgc.montesdeoca110.cristina.zonget.administratorSearchUsers;

import android.support.v4.app.NavUtils;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import es.ulpgc.montesdeoca110.cristina.zonget.R;

public class AdministratorSearchUsersActivity
        extends AppCompatActivity implements AdministratorSearchUsersContract.View {

    public static String TAG = AdministratorSearchUsersActivity.class.getSimpleName();

    private AdministratorSearchUsersContract.Presenter presenter;
    private Button searchButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_administrator_search_users);
        Toolbar toolbar = (Toolbar)findViewById(R.id.toolbarAnimalesCliente);
        setSupportActionBar(toolbar);

        //Mostrar el botón atras y el titulo en la action bar
        ActionBar actionBar = getSupportActionBar();
        if(actionBar != null){
            actionBar.setDisplayHomeAsUpEnabled(true);
            actionBar.setTitle("Clientes");
        }
        searchButton = findViewById(R.id.buttonUserSearch);
        searchButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                presenter.searchButtonClicked();
            }
        });
        // do the setup
        AdministratorSearchUsersScreen.configure(this);
    }

    @Override
    protected void onResume() {
        super.onResume();

        // do some work
        //presenter.fetchData();
    }

    @Override
    public void injectPresenter(AdministratorSearchUsersContract.Presenter presenter) {
        this.presenter = presenter;
    }

    @Override
    public void displayData(AdministratorSearchUsersViewModel viewModel) {
        //Log.e(TAG, "displayData()");

        // deal with the data

    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == android.R.id.home) {
            NavUtils.navigateUpFromSameTask(this);
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
