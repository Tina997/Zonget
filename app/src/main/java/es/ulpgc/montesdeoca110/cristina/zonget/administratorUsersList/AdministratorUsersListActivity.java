package es.ulpgc.montesdeoca110.cristina.zonget.administratorUsersList;

import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.ListView;
import android.widget.TextView;

import es.ulpgc.montesdeoca110.cristina.zonget.R;

public class AdministratorUsersListActivity
        extends AppCompatActivity implements AdministratorUsersListContract.View {

    public static String TAG = AdministratorUsersListActivity.class.getSimpleName();

    private AdministratorUsersListContract.Presenter presenter;
    private ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_administrator_users_list);
        Toolbar toolbar = (Toolbar)findViewById(R.id.toolbarAnimalesCliente);
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
        presenter.fetchData();
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
}
