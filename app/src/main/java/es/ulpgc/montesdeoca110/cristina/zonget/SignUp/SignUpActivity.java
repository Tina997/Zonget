package es.ulpgc.montesdeoca110.cristina.zonget.SignUp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import es.ulpgc.montesdeoca110.cristina.zonget.R;

public class SignUpActivity
        extends AppCompatActivity implements SignUpContract.View {

    public static String TAG = SignUpActivity.class.getSimpleName();

    private SignUpContract.Presenter presenter;

    //Elementos de la vista
    private EditText nameEditText, dniEditText, emailEditText, passwordEditText, secondPasswordEditText;
    private ImageView passwordCorrectionImageView;
    private Button confirmedButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        nameEditText = findViewById(R.id.user_sing_up_name_edit_text);
        dniEditText = findViewById(R.id.user_sign_up_dni_edit_text);
        emailEditText = findViewById(R.id.user_sign_up_email_edit_text);
        passwordEditText = findViewById(R.id.user_sign_up_password_edit_text);
        secondPasswordEditText = findViewById(R.id.user_sign_up_correct_password_edit_text);
        passwordCorrectionImageView = findViewById(R.id.password_correction_icon_view);
        confirmedButton = findViewById(R.id.sign_up_accept_button);

        // do the setup
        SignUpScreen.configure(this);
    }

    @Override
    protected void onResume() {
        super.onResume();

        // do some work
        //presenter.fetchData();
    }

    @Override
    public void injectPresenter(SignUpContract.Presenter presenter) {
        this.presenter = presenter;
    }

    @Override
    public void displayData(SignUpViewModel viewModel) {
        //Log.e(TAG, "displayData()");

        // deal with the data

    }
}
