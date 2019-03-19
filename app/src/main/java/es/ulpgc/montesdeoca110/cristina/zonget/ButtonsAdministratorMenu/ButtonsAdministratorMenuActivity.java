package es.ulpgc.montesdeoca110.cristina.zonget.ButtonsAdministratorMenu;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import es.ulpgc.montesdeoca110.cristina.zonget.R;

public class ButtonsAdministratorMenuActivity extends AppCompatActivity implements ButtonsAdministratorMenuContract.View {

    public static String TAG = ButtonsAdministratorMenuActivity.class.getSimpleName();

    private ButtonsAdministratorMenuContract.Presenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_administrator_menu_list);

        // do the setup
        ButtonsAdministratorMenuScreen.configure(this);
    }

    @Override
    protected void onResume() {
        super.onResume();

        // do some work
        //presenter.fetchData();
    }

    @Override
    public void injectPresenter(ButtonsAdministratorMenuContract.Presenter presenter) {
        this.presenter = presenter;
    }

    @Override
    public void displayData(ButtonsAdministratorMenuViewModel viewModel) {
        //Log.e(TAG, "displayData()");

        // deal with the data
        //((TextView) findViewById(R.id.data)).setText(viewModel.data);
    }
}
