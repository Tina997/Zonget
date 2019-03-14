package es.ulpgc.montesdeoca110.cristina.zonget.AnimalCliente;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import es.ulpgc.montesdeoca110.cristina.zonget.R;

public class AnimalDetailActivity
        extends AppCompatActivity implements AnimalDetailContract.View {

    public static String TAG = AnimalDetailActivity.class.getSimpleName();

    private AnimalDetailContract.Presenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_animal_detail);

        // do the setup
        AnimalDetailScreen.configure(this);
    }

    @Override
    protected void onResume() {
        super.onResume();

        // do some work
//        presenter.fetchData();
    }

    @Override
    public void injectPresenter(AnimalDetailContract.Presenter presenter) {
        this.presenter = presenter;
    }

    @Override
    public void displayData(AnimalDetailViewModel viewModel) {
        //Log.e(TAG, "displayData()");

        // deal with the data
    }
}
