package es.ulpgc.montesdeoca110.cristina.zonget.signIn;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import es.ulpgc.montesdeoca110.cristina.zonget.R;

public class SignInActivity extends AppCompatActivity implements SignInContract.View {

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
        accountNameEditText = findViewById(R.id.account_name_edit_text);
        accountPasswordEditText = findViewById(R.id.account_password_edit_text);
        passwordForgetTextView = findViewById(R.id.password_forget_text_label);
        signInButton = findViewById(R.id.sign_in_button);
        signUpButton = findViewById(R.id.sign_up_button);
        askDateButton = findViewById(R.id.ask_date_button);

        //Listeners
        accountNameEditText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {}

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {}

            @Override
            public void afterTextChanged(Editable accountName) {
                presenter.updateAccountNameEditText("" + accountName);
            }
        });

        accountPasswordEditText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {}

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {}

            @Override
            public void afterTextChanged(Editable accountPassword) {
                presenter.updateAccountPasswordEditText("" + accountPassword);
            }
        });

        passwordForgetTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                presenter.forgetPasswordPressed();
            }
        });

        signInButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
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
                finish();
                presenter.pickForADateButtonPressed();
            }
        });

        // do the setup
        SignInScreen.configure(this);
    }

    @Override
    protected void onResume() {
        super.onResume();

        presenter.fetchSignInData();
    }

    @Override
    public void injectPresenter(SignInContract.Presenter presenter) {
        this.presenter = presenter;
    }


    @Override
    public void displaySignInData(SignInViewModel viewModel) {
        accountNameEditText.setText(viewModel.accountName);
        accountNameEditText.setText(viewModel.accountPassword);
    }

    @Override
    public void displayCheckAccountError() {

    }
}
