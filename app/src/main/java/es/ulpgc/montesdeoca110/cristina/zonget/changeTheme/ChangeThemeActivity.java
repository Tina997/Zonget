package es.ulpgc.montesdeoca110.cristina.zonget.changeTheme;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import es.ulpc.montesdeoca110.cristina.zonget.complete.R;

public class ChangeThemeActivity extends AppCompatActivity implements ChangeThemeContract.View {

    public static String TAG = ChangeThemeActivity.class.getSimpleName();

    private ChangeThemeContract.Presenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_change_theme);

        // do the setup
        ChangeThemeScreen.configure(this);
    }

    @Override
    protected void onResume() {
        super.onResume();

        // load the data
        presenter.fetchData();
    }

    @Override
    public void displayData(ChangeThemeViewModel viewModel) {
        //Log.e(TAG, "displayData()");

        // deal with the data
        ((TextView) findViewById(R.id.data)).setText(viewModel.data);
    }

    @Override
    public void injectPresenter(ChangeThemeContract.Presenter presenter) {
        this.presenter = presenter;
    }
}
