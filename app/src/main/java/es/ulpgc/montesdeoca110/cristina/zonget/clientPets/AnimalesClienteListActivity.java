package es.ulpgc.montesdeoca110.cristina.zonget.clientPets;

import android.support.v4.app.NavUtils;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.ListView;

import es.ulpgc.montesdeoca110.cristina.zonget.app.AnimalClientesItem;
import es.ulpgc.montesdeoca110.cristina.zonget.R;

public class AnimalesClienteListActivity
        extends AppCompatActivity implements AnimalesClienteListContract.View {

    public static String TAG = AnimalesClienteListActivity.class.getSimpleName();

    private AnimalesClienteListContract.Presenter presenter;

    private ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_animales_cliente_list);
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
        AnimalesClienteListScreen.configure(this);

        //do some work
        presenter.fetchAnimalesListData();
    }

    @Override
    protected void onResume() {
        super.onResume();

        // do some work
//        presenter.fetchDateListData();
    }

    @Override
    public void injectPresenter(AnimalesClienteListContract.Presenter presenter) {
        this.presenter = presenter;
    }

    @Override
    public void displayAnimalesListData(AnimalesClienteListViewModel viewModel) {
        //Log.e(TAG, "displayData()");
    listView.setAdapter(new AnimalesClienteListAdapter(this, viewModel.animales, new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            AnimalClientesItem item = (AnimalClientesItem) v.getTag();
            presenter.selectAnimalListData(item);
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
