package es.ulpgc.montesdeoca110.cristina.zonget.petsForAdoption;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import es.ulpgc.montesdeoca110.cristina.zonget.R;

public class PetsForAdoptionActivity
        extends AppCompatActivity implements PetsForAdoptionContract.View {

    public static String TAG = PetsForAdoptionActivity.class.getSimpleName();

    private PetsForAdoptionContract.Presenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pets_for_adoption);

        // do the setup
        PetsForAdoptionScreen.configure(this);
    }

    @Override
    protected void onResume() {
        super.onResume();

        // do some work
        presenter.fetchData();
    }

    @Override
    public void injectPresenter(PetsForAdoptionContract.Presenter presenter) {
        this.presenter = presenter;
    }

    @Override
    public void displayData(PetsForAdoptionViewModel viewModel) {
        //Log.e(TAG, "displayData()");

        // deal with the data
        ((TextView) findViewById(R.id.data)).setText(viewModel.data);
    }
}
