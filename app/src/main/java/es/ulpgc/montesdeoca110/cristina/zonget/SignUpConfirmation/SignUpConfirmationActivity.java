package es.ulpgc.montesdeoca110.cristina.zonget.SignUpConfirmation;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import es.ulpgc.montesdeoca110.cristina.zonget.R;

public class SignUpConfirmationActivity
        extends AppCompatActivity implements SignUpConfirmationContract.View {

    public static String TAG = SignUpConfirmationActivity.class.getSimpleName();

    private SignUpConfirmationContract.Presenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up_confirmation);

        // do the setup
        SignUpConfirmationScreen.configure(this);
    }

    @Override
    protected void onResume() {
        super.onResume();

        // do some work
        presenter.fetchData();
    }

    @Override
    public void injectPresenter(SignUpConfirmationContract.Presenter presenter) {
        this.presenter = presenter;
    }

    @Override
    public void displayData(SignUpConfirmationViewModel viewModel) {
        //Log.e(TAG, "displayData()");

        // deal with the data
        ((TextView) findViewById(R.id.data)).setText(viewModel.data);
    }
}
