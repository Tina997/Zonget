package es.ulpgc.montesdeoca110.cristina.zonget.userNewQuery;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import es.ulpgc.montesdeoca110.cristina.zonget.R;

public class UserNewQueryActivity
        extends AppCompatActivity implements UserNewQueryContract.View {

    public static String TAG = UserNewQueryActivity.class.getSimpleName();

    private UserNewQueryContract.Presenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_new_query);

        // do the setup
        UserNewQueryScreen.configure(this);
    }

    @Override
    protected void onResume() {
        super.onResume();

        // do some work
        presenter.fetchData();
    }

    @Override
    public void injectPresenter(UserNewQueryContract.Presenter presenter) {
        this.presenter = presenter;
    }

    @Override
    public void displayData(UserNewQueryViewModel viewModel) {
        //Log.e(TAG, "displayData()");

        // deal with the data

    }
}
