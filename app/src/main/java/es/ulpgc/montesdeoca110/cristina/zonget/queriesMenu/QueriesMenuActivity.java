package es.ulpgc.montesdeoca110.cristina.zonget.queriesMenu;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import es.ulpgc.montesdeoca110.cristina.zonget.R;

public class QueriesMenuActivity
        extends AppCompatActivity implements QueriesMenuContract.View {

    public static String TAG = QueriesMenuActivity.class.getSimpleName();

    private QueriesMenuContract.Presenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_queries_menu);

        // do the setup
        QueriesMenuScreen.configure(this);
    }

    @Override
    protected void onResume() {
        super.onResume();

        // do some work
        presenter.fetchData();
    }

    @Override
    public void injectPresenter(QueriesMenuContract.Presenter presenter) {
        this.presenter = presenter;
    }

    @Override
    public void displayData(QueriesMenuViewModel viewModel) {
        //Log.e(TAG, "displayData()");

        // deal with the data
        ((TextView) findViewById(R.id.data)).setText(viewModel.data);
    }
}
