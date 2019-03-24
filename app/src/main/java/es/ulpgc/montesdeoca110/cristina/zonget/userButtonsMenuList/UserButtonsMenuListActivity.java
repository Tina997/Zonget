package es.ulpgc.montesdeoca110.cristina.zonget.userButtonsMenuList;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import es.ulpgc.montesdeoca110.cristina.zonget.R;

public class UserButtonsMenuListActivity
        extends AppCompatActivity implements UserButtonsMenuListContract.View {

    public static String TAG = UserButtonsMenuListActivity.class.getSimpleName();

    private UserButtonsMenuListContract.Presenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_buttons_menu_list);

        // do the setup
        UserButtonsMenuListScreen.configure(this);
    }

    @Override
    protected void onResume() {
        super.onResume();

        // do some work
        presenter.fetchData();
    }

    @Override
    public void injectPresenter(UserButtonsMenuListContract.Presenter presenter) {
        this.presenter = presenter;
    }

    @Override
    public void displayData(UserButtonsMenuListViewModel viewModel) {
        //Log.e(TAG, "displayData()");

        // deal with the data
        ((TextView) findViewById(R.id.data)).setText(viewModel.data);
    }
}
