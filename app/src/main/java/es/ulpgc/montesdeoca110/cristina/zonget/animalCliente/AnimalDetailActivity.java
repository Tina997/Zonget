package es.ulpgc.montesdeoca110.cristina.zonget.animalCliente;

import android.content.Intent;
import android.support.v7.app.ActionBar;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.widget.TextView;

import es.ulpgc.montesdeoca110.cristina.zonget.animalesCliente.AnimalesClienteListActivity;
import es.ulpgc.montesdeoca110.cristina.zonget.app.AnimalClientesItem;
import es.ulpgc.montesdeoca110.cristina.zonget.R;

public class AnimalDetailActivity
        extends AppCompatActivity implements AnimalDetailContract.View {

    public static String TAG = AnimalDetailActivity.class.getSimpleName();

    private AnimalDetailContract.Presenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_animal_detail);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        //Mostrar el botón atras y el titulo en la action bar
        ActionBar actionBar = getSupportActionBar();
        if(actionBar != null){
            actionBar.setDisplayHomeAsUpEnabled(true);
            actionBar.setTitle("Detalles animales");
        }

        // do the setup
        AnimalDetailScreen.configure(this);

        presenter.fetchData();
    }

    @Override
    protected void onResume() {
        super.onResume();

        // do some work
//        presenter.fetchDateListData();
    }

    @Override
    public void injectPresenter(AnimalDetailContract.Presenter presenter) {
        this.presenter = presenter;
    }

    @Override
    public void displayData(AnimalDetailViewModel viewModel) {
        //Log.e(TAG, "displayData()");

        // deal with the data
        AnimalClientesItem animalClientesItem = viewModel.animal;
        if(animalClientesItem != null){
            ((TextView)findViewById(R.id.fechaNacAnimalCliente)).setText(animalClientesItem.fechaNac);
            ((TextView)findViewById(R.id.nombreAnimal)).setText(animalClientesItem.nombre);
            ((TextView)findViewById(R.id.especieAnimalCliente)).setText(animalClientesItem.especie);
            ((TextView)findViewById(R.id.razaAnimalCliente)).setText(animalClientesItem.raza);
            ((TextView)findViewById(R.id.numeroAnimalCliente)).setText(animalClientesItem.numChip);
        }

    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == android.R.id.home) {
            navigateUpTo(new Intent(this, AnimalesClienteListActivity.class));
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
