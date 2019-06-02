package es.ulpgc.montesdeoca110.cristina.zonget.signIn;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import es.ulpgc.montesdeoca110.cristina.zonget.R;

import static android.widget.Toast.LENGTH_LONG;

public class SignInActivity extends AppCompatActivity implements SignInContract.View {

  private SignInContract.Presenter presenter;

  // Elementos de la vista
  private EditText accountNameEditText, accountPasswordEditText;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);

    SignInScreen.configure(this);

    //Theme
    String themeName = presenter.getActualThemeName();
    if (themeName != null) {
      int themeID = getResources().getIdentifier(themeName, "style", getPackageName());
      setTheme(themeID);
    }

    setContentView(R.layout.activity_sign_in);

    //Búsqueda de los elementos de la vista
    accountNameEditText = findViewById(R.id.account_name_edit_text);
    accountPasswordEditText = findViewById(R.id.account_password_edit_text);
    TextView passwordForgetTextView = findViewById(R.id.password_forget_text_label);
    Button signInButton = findViewById(R.id.sign_in_button);
    Button signUpButton = findViewById(R.id.sign_up_button);
    Button askDateButton = findViewById(R.id.ask_date_button);

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
        presenter.pickForADateButtonPressed();
      }
    });

    SignInScreen.configure(this);
  }

  @Override
  protected void onResume() {
    super.onResume();

    presenter.fetchSignInData();
  }

  @Override
  public void finish() {
    super.finish();
  }

  @Override
  public void injectPresenter(SignInContract.Presenter presenter) {
    this.presenter = presenter;
  }


  @Override
  public void displayCheckAccountError() {
    runOnUiThread(new Runnable() {
      @Override
      public void run() {
        Toast.makeText(getApplicationContext(),
                " · El usuario y/o contraseña son incorrectos.\n"
                        + " · El usuario no existe.", LENGTH_LONG).show();
      }
    });
  }
}
