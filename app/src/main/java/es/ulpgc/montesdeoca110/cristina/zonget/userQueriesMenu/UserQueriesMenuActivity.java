package es.ulpgc.montesdeoca110.cristina.zonget.userQueriesMenu;

import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.LinearLayout;

import es.ulpgc.montesdeoca110.cristina.zonget.R;

public class UserQueriesMenuActivity
        extends AppCompatActivity implements UserQueriesMenuContract.View {

    public static String TAG = UserQueriesMenuActivity.class.getSimpleName();

    private UserQueriesMenuContract.Presenter presenter;

    //Elementos de la vista
    private Toolbar toolbar;
    private LinearLayout newQueryButton,pendingQueriesButton, finishedQueriesButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_queries_menu);

        //Configuracion de la toolBar/actionBar
        toolbar = findViewById(R.id.user_queries_menu_toolbar);
        setSupportActionBar(toolbar);

        ActionBar actionBar = getSupportActionBar();
        actionBar.setTitle("Consultas");
        actionBar.setDisplayHomeAsUpEnabled(true);

        //Búsqueda de los elementos de la vista
        newQueryButton = findViewById(R.id.user_queries_menu_new_query_linear_layout);
        pendingQueriesButton = findViewById(R.id.user_queries_menu_pending_queries_linear_layout);
        finishedQueriesButton = findViewById(R.id.user_queries_menu_finished_queries_linear_layout);

        //Listeners
        newQueryButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //TODO llamar al presentador
            }
        });

        pendingQueriesButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //TODO llamar al presentador
            }
        });

        finishedQueriesButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //TODO llamar al presentador
            }
        });


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
