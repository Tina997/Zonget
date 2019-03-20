package es.ulpgc.montesdeoca110.cristina.zonget.signUpConfirmation;

import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;

import es.ulpgc.montesdeoca110.cristina.zonget.R;

public class SignUpConfirmationActivity extends AppCompatActivity implements SignUpConfirmationContract.View {

    public static String TAG = SignUpConfirmationActivity.class.getSimpleName();

    private SignUpConfirmationContract.Presenter presenter;

    //Elementos de la vista
    private Toolbar sign_up_confirmation_toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up_confirmation);



        //Configuracion de la toolBar/actionBar
        sign_up_confirmation_toolbar = findViewById(R.id.sign_up_confirmation_toolbar);
        setSupportActionBar(sign_up_confirmation_toolbar);

        ActionBar actionBar = getSupportActionBar();
        actionBar.setTitle("Registro");
        actionBar.setDisplayHomeAsUpEnabled(true);

        // do the setup
        SignUpConfirmationScreen.configure(this);
    }

    @Override
    protected void onResume() {
        super.onResume();

        // do some work
        //presenter.fetchDateListData();
    }

    @Override
    public void injectPresenter(SignUpConfirmationContract.Presenter presenter) {
        this.presenter = presenter;
    }

    @Override
    public void displayData(SignUpConfirmationViewModel viewModel) {
        //Log.e(TAG, "displayData()");

        // deal with the data

    }
}
