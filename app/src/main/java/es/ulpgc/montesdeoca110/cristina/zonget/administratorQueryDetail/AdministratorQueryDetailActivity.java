package es.ulpgc.montesdeoca110.cristina.zonget.administratorQueryDetail;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import es.ulpgc.montesdeoca110.cristina.zonget.R;

public class AdministratorQueryDetailActivity
        extends AppCompatActivity implements AdministratorQueryDetailContract.View {

    public static String TAG = AdministratorQueryDetailActivity.class.getSimpleName();

    private AdministratorQueryDetailContract.Presenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_administrator_query_detail);

        // do the setup
        AdministratorQueryDetailScreen.configure(this);
    }

    @Override
    protected void onResume() {
        super.onResume();

        // do some work
        presenter.fetchData();
    }

    @Override
    public void injectPresenter(AdministratorQueryDetailContract.Presenter presenter) {
        this.presenter = presenter;
    }

    @Override
    public void displayData(AdministratorQueryDetailViewModel viewModel) {
        //Log.e(TAG, "displayData()");

        // deal with the data
        ((TextView) findViewById(R.id.data)).setText(viewModel.data);
    }
}
