package es.ulpgc.montesdeoca110.cristina.zonget.lostPets;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import es.ulpgc.montesdeoca110.cristina.zonget.R;

public class LostPetsListActivity
        extends AppCompatActivity implements LostPetsListContract.View {

    public static String TAG = LostPetsListActivity.class.getSimpleName();

    private LostPetsListContract.Presenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lost_pets_list);

        // do the setup
        LostPetsListScreen.configure(this);
    }

    @Override
    protected void onResume() {
        super.onResume();

        // do some work
        presenter.fetchData();
    }

    @Override
    public void injectPresenter(LostPetsListContract.Presenter presenter) {
        this.presenter = presenter;
    }

    @Override
    public void displayData(LostPetsListViewModel viewModel) {
        //Log.e(TAG, "displayData()");

        // deal with the data

    }
}
