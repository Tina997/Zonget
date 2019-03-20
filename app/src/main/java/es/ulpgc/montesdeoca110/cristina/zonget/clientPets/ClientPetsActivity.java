package es.ulpgc.montesdeoca110.cristina.zonget.clientPets;

import android.support.v4.app.NavUtils;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.ListView;
import android.widget.TextView;

import es.ulpgc.montesdeoca110.cristina.zonget.R;
import es.ulpgc.montesdeoca110.cristina.zonget.app.PetsItem;

public class ClientPetsActivity
        extends AppCompatActivity implements ClientPetsContract.View {

    public static String TAG = ClientPetsActivity.class.getSimpleName();

    private ClientPetsContract.Presenter presenter;
    private ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_client_pets);
        Toolbar toolbar = (Toolbar)findViewById(R.id.toolbarAnimalesCliente);
        setSupportActionBar(toolbar);

        //Mostrar el botón atras y el titulo en la action bar
        ActionBar actionBar = getSupportActionBar();
        if(actionBar != null){
            actionBar.setDisplayHomeAsUpEnabled(true);
            actionBar.setTitle("Animales de Cliente");
        }

        listView = findViewById(R.id.animal_list);

        // do the setup
        ClientPetsScreen.configure(this);

    }

    @Override
    protected void onResume() {
        super.onResume();

        // do some work
        presenter.fetchClientPetsData();
    }

    @Override
    public void injectPresenter(ClientPetsContract.Presenter presenter) {
        this.presenter = presenter;
    }

    @Override
    public void displayClientPetsData(ClientPetsViewModel viewModel) {
        //Log.e(TAG, "displayData()");
        listView.setAdapter(new ClientPetsAdapter(this, viewModel.animales, new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                PetsItem item = (PetsItem) v.getTag();
                presenter.selectClientPetsData(item);
            }
        }));
        // deal with the data
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == android.R.id.home) {
            NavUtils.navigateUpFromSameTask(this);
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}