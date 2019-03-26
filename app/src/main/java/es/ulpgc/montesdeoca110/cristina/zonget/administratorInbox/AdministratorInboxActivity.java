package es.ulpgc.montesdeoca110.cristina.zonget.administratorInbox;

import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ListView;

import es.ulpgc.montesdeoca110.cristina.zonget.R;

public class AdministratorInboxActivity
        extends AppCompatActivity implements AdministratorInboxContract.View {

    public static String TAG = AdministratorInboxActivity.class.getSimpleName();

    private AdministratorInboxContract.Presenter presenter;
    private ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_administrator_inbox);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        // Show the title in the action bar
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setTitle(getString(R.string.administrator_inbox_activity_name));
        }

        listView = findViewById(R.id.inbox_list);

        // do the setup
        AdministratorInboxScreen.configure(this);
    }

    @Override
    protected void onResume() {
        super.onResume();

        // do some work
        presenter.fetchInboxData();
    }

    @Override
    public void injectPresenter(AdministratorInboxContract.Presenter presenter) {
        this.presenter = presenter;
    }

    @Override
    public void displayData(AdministratorInboxViewModel viewModel) {
        listView.setAdapter(new AdministratorInboxListAdapter(this, viewModel.inboxList, new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //TODO cambiar de pantalla y mostrar detalle
            }
        }));;

    }
}
