package es.ulpgc.montesdeoca110.cristina.zonget.SignIn;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import es.ulpgc.montesdeoca110.cristina.zonget.R;

public class SignInActivity extends AppCompatActivity implements SignInContract.View {

    public static String TAG = SignInActivity.class.getSimpleName();

    private SignInContract.Presenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in);

        // do the setup
        SignInScreen.configure(this);
    }

    @Override
    protected void onResume() {
        super.onResume();

        // do some work
        presenter.fetchData();
    }

    @Override
    public void injectPresenter(SignInContract.Presenter presenter) {
        this.presenter = presenter;
    }

    @Override
    public void displayData(SignInViewModel viewModel) {
        //Log.e(TAG, "displayData()");

        // deal with the data
        ((TextView) findViewById(R.id.data)).setText(viewModel.data);
    }
}
