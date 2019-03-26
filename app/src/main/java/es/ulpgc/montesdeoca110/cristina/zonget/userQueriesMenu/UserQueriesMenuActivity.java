package es.ulpgc.montesdeoca110.cristina.zonget.userQueriesMenu;

import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;
import android.support.v7.widget.Toolbar;

import es.ulpgc.montesdeoca110.cristina.zonget.R;

public class UserQueriesMenuActivity
        extends AppCompatActivity implements UserQueriesMenuContract.View {

    public static String TAG = UserQueriesMenuActivity.class.getSimpleName();

    private UserQueriesMenuContract.Presenter presenter;

    //Elementos de la vista
    private Toolbar user_queries_menu_toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_queries_menu);

        //Configuracion de la toolBar/actionBar
        user_queries_menu_toolbar = findViewById(R.id.user_queries_menu_toolbar);
        setSupportActionBar(user_queries_menu_toolbar);

        ActionBar actionBar = getSupportActionBar();
        actionBar.setTitle("Consultas");
        actionBar.setDisplayHomeAsUpEnabled(true);

        // do the setup
        UserQueriesMenuScreen.configure(this);
    }

    @Override
    protected void onResume() {
        super.onResume();

        // do some work
        //presenter.fetchData();
    }

    @Override
    public void injectPresenter(UserQueriesMenuContract.Presenter presenter) {
        this.presenter = presenter;
    }

    @Override
    public void displayData(UserQueriesMenuViewModel viewModel) {
        //Log.e(TAG, "displayData()");

        // deal with the data

    }
}
