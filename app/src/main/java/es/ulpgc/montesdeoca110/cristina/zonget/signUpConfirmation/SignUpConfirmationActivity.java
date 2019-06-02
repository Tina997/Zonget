package es.ulpgc.montesdeoca110.cristina.zonget.signUpConfirmation;

import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;

import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import es.ulpgc.montesdeoca110.cristina.zonget.R;

public class SignUpConfirmationActivity extends AppCompatActivity
        implements SignUpConfirmationContract.View {

  private SignUpConfirmationContract.Presenter presenter;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);

    SignUpConfirmationScreen.configure(this);

    //Theme
    String themeName = presenter.getActualThemeName();
    if (themeName != null) {
      int themeID = getResources().getIdentifier(themeName, "style", getPackageName());
      setTheme(themeID);
    }

    setContentView(R.layout.activity_sign_up_confirmation);

    //Configuracion de la toolBar/actionBar
    //Elementos de la vista
    Toolbar toolbar = findViewById(R.id.toolbar);
    setSupportActionBar(toolbar);

    ActionBar actionBar = getSupportActionBar();
    actionBar.setTitle("Registro");
    actionBar.setDisplayHomeAsUpEnabled(true);
  }

  @Override
  protected void onResume() {
    super.onResume();

    presenter.fetchSignUpConfirmationData(this);
  }

  @Override
  public void finish() {
    super.finish();
  }

  @Override
  public void injectPresenter(SignUpConfirmationContract.Presenter presenter) {
    this.presenter = presenter;
  }

  @Override
  public void displaySignUpConfirmationData(SignUpConfirmationViewModel viewModel) {
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
