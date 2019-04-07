package es.ulpgc.montesdeoca110.cristina.zonget.lostPetsDetail;

import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.widget.TextView;

import es.ulpgc.montesdeoca110.cristina.zonget.R;

public class LostPetsDetailActivity
        extends AppCompatActivity implements LostPetsDetailContract.View {

    public static String TAG = LostPetsDetailActivity.class.getSimpleName();

    private LostPetsDetailContract.Presenter presenter;
    private ActionBar actionBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lost_pets_detail);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true);
            actionBar.setTitle(R.string.lost_pets_tittle);
        }

        // do the setup
        LostPetsDetailScreen.configure(this);
    }

    @Override
    protected void onResume() {
        super.onResume();

        // do some work
        presenter.fetchData();
    }

    @Override
    public void injectPresenter(LostPetsDetailContract.Presenter presenter) {
        this.presenter = presenter;
    }

    @Override
    public void displayData(LostPetsDetailViewModel viewModel) {
        //Log.e(TAG, "displayData()");

        // deal with the data
    }
}
