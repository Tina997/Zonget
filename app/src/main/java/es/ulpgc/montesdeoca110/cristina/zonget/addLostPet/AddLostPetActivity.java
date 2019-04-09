package es.ulpgc.montesdeoca110.cristina.zonget.addLostPet;

import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.widget.TextView;

import es.ulpgc.montesdeoca110.cristina.zonget.R;

public class AddLostPetActivity
        extends AppCompatActivity implements AddLostPetContract.View {

    public static String TAG = AddLostPetActivity.class.getSimpleName();

    private AddLostPetContract.Presenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_lost_pet);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        // Show the title in the action bar
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true);
            actionBar.setTitle(getString(R.string.add_pet_tittle));
        }

        // do the setup
        AddLostPetScreen.configure(this);
    }

    @Override
    protected void onResume() {
        super.onResume();

        // do some work
//        presenter.fetchData();
    }

    @Override
    public void injectPresenter(AddLostPetContract.Presenter presenter) {
        this.presenter = presenter;
    }

    @Override
    public void displayData(AddLostPetViewModel viewModel) {
        //Log.e(TAG, "displayData()");

        // deal with the data
    }
}
