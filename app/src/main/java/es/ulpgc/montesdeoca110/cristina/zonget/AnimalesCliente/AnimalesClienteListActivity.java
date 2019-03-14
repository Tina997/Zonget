package es.ulpgc.montesdeoca110.cristina.zonget.AnimalesCliente;

import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.widget.TextView;

import es.ulpgc.montesdeoca110.cristina.zonget.R;

public class AnimalesClienteListActivity
        extends AppCompatActivity implements AnimalesClienteListContract.View {

    public static String TAG = AnimalesClienteListActivity.class.getSimpleName();

    private AnimalesClienteListContract.Presenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_animales_cliente_list);
        Toolbar toolbar = (Toolbar)findViewById(R.id.toolbarAnimalesCliente);
        /*setSupportActionBar(toolbar);

        //Mostrar el botón atras y el titulo en la action bar
        ActionBar actionBar = getSupportActionBar();
        if(actionBar != null){
            actionBar.setDisplayHomeAsUpEnabled(true);
            actionBar.setTitle("Animales de Cliente");
        }
        // do the setup
        AnimalesClienteListScreen.configure(this);*/
    }

    @Override
    protected void onResume() {
        super.onResume();

        // do some work
//        presenter.fetchData();
    }

    @Override
    public void injectPresenter(AnimalesClienteListContract.Presenter presenter) {
        this.presenter = presenter;
    }

    @Override
    public void displayData(AnimalesClienteListViewModel viewModel) {
        //Log.e(TAG, "displayData()");

        // deal with the data
    }
}
