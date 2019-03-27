package es.ulpgc.montesdeoca110.cristina.zonget.signIn;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import es.ulpgc.montesdeoca110.cristina.zonget.R;

public class SignInActivity extends AppCompatActivity implements SignInContract.View {

    public static String TAG = SignInActivity.class.getSimpleName();

    private SignInContract.Presenter presenter;

    // Elementos de la vista
    private EditText accountNameEditText, accountPasswordEditText;
    private TextView passwordForgetTextView;
    private Button signInButton, signUpButton, askDateButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in);

        //Búsqueda de los elementos de la vista
        accountNameEditText = findViewById(R.id.accountNameEditText);
        accountPasswordEditText = findViewById(R.id.accountPasswordEditText);
        passwordForgetTextView = findViewById(R.id.passwordForgetTextLabel);
        signInButton = findViewById(R.id.signInButton);
        signUpButton = findViewById(R.id.signUpButton);
        askDateButton = findViewById(R.id.askDateButton);

        //Listeners
        passwordForgetTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                presenter.forgetPasswordPressed();
            }
        });

        signInButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Todo Cambiar lo de las comillas 77, buscar otra forma de pasarlo a String
                String accountName = "" + accountNameEditText.getText();
                String accountPassword = "" + accountPasswordEditText.getText();
                presenter.signInButtonPressed(accountName, accountPassword);
            }
        });

        signUpButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                presenter.signUpButtonPressed();
            }
        });

        askDateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                presenter.askDateButtonPressed();
            }
        });


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
    }

    @Override
    public void displayCheckAccountError() {

    }
}
