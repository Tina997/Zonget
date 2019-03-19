package es.ulpgc.montesdeoca110.cristina.zonget.AdministratorMenu;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import es.ulpgc.montesdeoca110.cristina.zonget.R;

public class AdministratorMenuActivity extends AppCompatActivity implements AdministratorMenuContract.View {

    public static String TAG = AdministratorMenuActivity.class.getSimpleName();

    private AdministratorMenuContract.Presenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_administrator_menu);

        // do the setup
        AdministratorMenuScreen.configure(this);
    }

    @Override
    protected void onResume() {
        super.onResume();

        // do some work
        //presenter.fetchData();
    }

    @Override
    public void injectPresenter(AdministratorMenuContract.Presenter presenter) {
        this.presenter = presenter;
    }

    @Override
    public void displayData(AdministratorMenuViewModel viewModel) {
        //Log.e(TAG, "displayData()");

        // deal with the data
        //((TextView) findViewById(R.id.data)).setText(viewModel.data);
    }
}
