package es.ulpgc.montesdeoca110.cristina.zonget.administratorUsersList;

import android.content.Intent;
import android.os.Parcelable;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.ListView;
import es.ulpgc.montesdeoca110.cristina.zonget.R;
import es.ulpgc.montesdeoca110.cristina.zonget.administratorSearchUsers.AdministratorSearchUsersActivity;
import es.ulpgc.montesdeoca110.cristina.zonget.app.AccountItem;
import es.ulpgc.montesdeoca110.cristina.zonget.app.UserItem;

public class AdministratorUsersListActivity
        extends AppCompatActivity implements AdministratorUsersListContract.View {

    public static String TAG = AdministratorUsersListActivity.class.getSimpleName();

    private AdministratorUsersListContract.Presenter presenter;
    private ListView listView;
    private static Bundle bundle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        AdministratorUsersListScreen.configure(this);

        //Theme
        String themeName = presenter.getActualThemeName();
        if (themeName != null){
            int themeID = getResources().getIdentifier(themeName,"style",getPackageName());
            setTheme(themeID);
        }
        setContentView(R.layout.activity_administrator_users_list);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        //Mostrar el botón atras y el title en la action bar
        ActionBar actionBar = getSupportActionBar();
        if(actionBar != null){
            actionBar.setDisplayHomeAsUpEnabled(true);
            actionBar.setTitle(R.string.clients_tittle);
        }

        listView = findViewById(R.id.user_list);

        // do the setup
        AdministratorUsersListScreen.configure(this);
    }

    @Override
    protected void onResume() {
        super.onResume();
        //restore ListView state
        if(bundle != null){
            Parcelable listState = bundle.getParcelable("state");
            listView.onRestoreInstanceState(listState);
        }

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
        listView.setAdapter(new AdministratorUsersListAdapter(AdministratorUsersListActivity.this, viewModel.users, new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AccountItem item = (AccountItem) v.getTag();
                presenter.selectAdminUserData(item);

            }
        }));

        // deal with the data
    }

    @Override
    public void onPause(){
        super.onPause();
        //Save ListView state
      bundle = new Bundle();
        Parcelable listState = listView.onSaveInstanceState();
        bundle.putParcelable("state", listState);
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == android.R.id.home) {
            presenter.onBackButtonPressed();
            finish();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }


}
