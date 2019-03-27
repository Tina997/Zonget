package es.ulpgc.montesdeoca110.cristina.zonget.administratorSearchUsers;

import android.annotation.SuppressLint;
import android.support.v4.app.NavUtils;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import es.ulpgc.montesdeoca110.cristina.zonget.R;

public class AdministratorSearchUsersActivity
        extends AppCompatActivity implements AdministratorSearchUsersContract.View {

    public static String TAG = AdministratorSearchUsersActivity.class.getSimpleName();

    private AdministratorSearchUsersContract.Presenter presenter;
    Button searchButton;
    EditText dataSearched;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_administrator_search_users);
        Toolbar toolbar = (Toolbar)findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        //Mostrar el botón atras y el title en la action bar
        ActionBar actionBar = getSupportActionBar();
        if(actionBar != null){
            actionBar.setDisplayHomeAsUpEnabled(true);
            actionBar.setTitle("Clientes");
        }
        dataSearched = findViewById(R.id.user_name_edit_text);

        searchButton = (Button) findViewById(R.id.buttonUserSearch);
        searchButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                presenter.searchButtonClicked(dataSearched.getText().toString());
            }
        });
        // do the setup
        AdministratorSearchUsersScreen.configure(this);
    }

    @Override
    protected void onResume() {
        super.onResume();

        // do some work
        //presenter.fetchInboxData();
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
