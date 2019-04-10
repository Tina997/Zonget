package es.ulpgc.montesdeoca110.cristina.zonget.signUpConfirmation;

import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.ProgressBar;

import es.ulpgc.montesdeoca110.cristina.zonget.R;

public class SignUpConfirmationActivity extends AppCompatActivity implements SignUpConfirmationContract.View {

    private SignUpConfirmationContract.Presenter presenter;

    //Elementos de la vista
    private Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up_confirmation);

        //Configuracion de la toolBar/actionBar
        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

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
        presenter.fetchSignUpConfirmationData(this);
    }

    @Override
    public void injectPresenter(SignUpConfirmationContract.Presenter presenter) {
        this.presenter = presenter;
    }

    @Override
    public void displaySignUpConfirmationData(SignUpConfirmationViewModel viewModel) {}

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle presses on the action bar items
        switch (item.getItemId()) {
            case android.R.id.home:
                presenter.backButtonPressed();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

}
