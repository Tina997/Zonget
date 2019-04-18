package es.ulpgc.montesdeoca110.cristina.zonget.signUp;

import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.Toast;

import es.ulpgc.montesdeoca110.cristina.zonget.R;

public class SignUpActivity extends AppCompatActivity implements SignUpContract.View {

    private SignUpContract.Presenter presenter;

    //Elementos de la vista
    private Toolbar toolbar;
    private EditText nameEditText, dniEditText, emailEditText, secondEmailEditText, passwordEditText, secondPasswordEditText;
    private ImageView passwordCorrectionImageView, emailCorrectionImageView;
    private ProgressBar progressBar;
    private Button confirmedButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        SignUpScreen.configure(this);

        //Theme
        String themeName = presenter.getActualThemeName();
        if (themeName != null){
            int themeID = getResources().getIdentifier(themeName,"style",getPackageName());
            setTheme(themeID);
        }

        setContentView(R.layout.activity_sign_up);

        //Configuracion de la toolBar/actionBar
        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        ActionBar actionBar = getSupportActionBar();
        actionBar.setTitle("Registro");
        actionBar.setDisplayHomeAsUpEnabled(true);

        //Búsqueda de los elementos de la vista
        nameEditText = findViewById(R.id.user_sing_up_name_edit_text);
        dniEditText = findViewById(R.id.user_sign_up_dni_edit_text);
        emailEditText = findViewById(R.id.user_sign_up_email_edit_text);
        secondEmailEditText = findViewById(R.id.user_sign_up_correct_email_edit_text);
        emailCorrectionImageView = findViewById(R.id.user_sign_up_email_correction_icon_view);
        passwordEditText = findViewById(R.id.user_sign_up_password_edit_text);
        secondPasswordEditText = findViewById(R.id.user_sign_up_correct_password_edit_text);
        passwordCorrectionImageView = findViewById(R.id.user_sign_up_password_correction_icon_view);
        progressBar = findViewById(R.id.sign_up_progress_bar);
        confirmedButton = findViewById(R.id.sign_up_accept_button);

        //Listeners
        nameEditText.addTextChangedListener(new TextWatcher() {
            @Override
            public void afterTextChanged(Editable name) {
                presenter.updateAccountNameEditText("" + name);
            }

            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) { }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) { }

        });

        dniEditText.addTextChangedListener(new TextWatcher() {
            @Override
            public void afterTextChanged(Editable dni) {
                presenter.updateAccountDniEditText("" + dni);
            }

            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) { }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) { }

        });

        emailEditText.addTextChangedListener(new TextWatcher() {
            @Override
            public void afterTextChanged(Editable email) {
                presenter.updateAccountEmailEditText("" + email);
            }

            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) { }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) { }

        });

        secondEmailEditText.addTextChangedListener(new TextWatcher() {
            @Override
            public void afterTextChanged(Editable secondEmail) {
                presenter.updateAccountSecondEmailEditText("" + secondEmail);
                presenter.checkEmails();
            }

            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) { }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) { }

        });

        passwordEditText.addTextChangedListener(new TextWatcher() {
            @Override
            public void afterTextChanged(Editable password) {
                presenter.updateAccountPasswordEditText("" + password);
            }

            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) { }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) { }

        });

        secondPasswordEditText.addTextChangedListener(new TextWatcher() {
            @Override
            public void afterTextChanged(Editable secondPassword) {
                presenter.updateAccountSecondPasswordEditText("" + secondPassword);
                presenter.checkPasswords();
            }

            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) { }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) { }

        });


        confirmedButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(presenter.checkAllDataIntroduced()){
                    progressBar.setVisibility(View.VISIBLE);
                    presenter.confirmedButtonPressed();
                }else {
                    displayAlertMesaje("Faltan datos por introducir.");
                }
            }
        });

    }

    @Override
    protected void onResume() {
        super.onResume();

        presenter.fetchSignUpData();
    }

    @Override
    public void finish() {
        super.finish();
    }

    @Override
    protected void onStop() {
        super.onStop();
        presenter.saveSignUpState();
    }

    @Override
    public void injectPresenter(SignUpContract.Presenter presenter) {
        this.presenter = presenter;
    }

    @Override
    public void displaySignUpData(SignUpViewModel viewModel) {
        nameEditText.setText(viewModel.accountName);
        dniEditText.setText(viewModel.accountDni);
        emailEditText.setText(viewModel.accountEmail);
        passwordEditText.setText(viewModel.accountPassword);

        emailCorrectionImageView.setImageResource(viewModel.correctEmailsImageView);
        emailCorrectionImageView.setVisibility(viewModel.correctEmailsImageViewVisibility);
        passwordCorrectionImageView.setImageResource(viewModel.correctPasswordsImageView);
        passwordCorrectionImageView.setVisibility(viewModel.correctPasswordsImageViewVisibility);

    }

    @Override
    public void displayInsertNewAccountMesaje(final String mesaje) {
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                progressBar.setVisibility(View.INVISIBLE);
                Toast.makeText(getBaseContext(),mesaje, Toast.LENGTH_LONG).show();
            }
        });
    }

    @Override
    public void displayAlertMesaje(String mesaje) {
        Toast.makeText(getBaseContext(),mesaje, Toast.LENGTH_LONG).show();
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()) {
            case android.R.id.home:
                presenter.backButtonPressed();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

}
