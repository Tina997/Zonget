package es.ulpgc.montesdeoca110.cristina.zonget.userPickDate;

import android.support.v4.app.FragmentManager;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.ListView;
import android.widget.TextView;

import es.ulpgc.montesdeoca110.cristina.zonget.R;
import es.ulpgc.montesdeoca110.cristina.zonget.administratorAgenda.DialogEventDetail;

public class UserPickDateActivity
        extends AppCompatActivity implements UserPickDateContract.View {

    public static String TAG = UserPickDateActivity.class.getSimpleName();

    private UserPickDateContract.Presenter presenter;
    private ListView listView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_pick_date);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        // Show the title in the action bar
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setTitle("Cita Previa");
        }

        listView = findViewById(R.id.hours_list);
        // do the setup
        UserPickDateScreen.configure(this);
    }

    @Override
    protected void onResume() {
        super.onResume();

        // do some work
        presenter.fetchData();
    }

    @Override
    public void injectPresenter(UserPickDateContract.Presenter presenter) {
        this.presenter = presenter;
    }

    @Override
    public void displayData(UserPickDateViewModel viewModel) {
        //Log.e(TAG, "displayData()");
        listView.setAdapter(new UserPickDateAdapter(this, viewModel.hourItemList, new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentManager fragmentManager = getSupportFragmentManager();
                DialogEventAcceptDate dialogo = new DialogEventAcceptDate();
                dialogo.show(fragmentManager, "tagAlert");
            }
        }));
        // deal with the data
    }
}
