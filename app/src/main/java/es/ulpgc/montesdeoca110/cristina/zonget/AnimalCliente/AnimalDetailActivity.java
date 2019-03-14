package es.ulpgc.montesdeoca110.cristina.zonget.AnimalCliente;

import android.drm.DrmStore;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;

import es.ulpgc.montesdeoca110.cristina.zonget.R;

public class AnimalDetailActivity
        extends AppCompatActivity implements AnimalDetailContract.View {

    public static String TAG = AnimalDetailActivity.class.getSimpleName();

    private AnimalDetailContract.Presenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_animal_detail);
        Toolbar toolbar = findViewById(R.id.appbarAnimalCliente);
        setSupportActionBar(toolbar);

        //Mostrar el botón atras y el titulo en la action bar
        ActionBar actionBar = getSupportActionBar();
        if(actionBar != null){
            actionBar.setDisplayHomeAsUpEnabled(true);
            actionBar.setTitle("Detalles animales");
        }

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
