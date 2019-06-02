package es.ulpgc.montesdeoca110.cristina.zonget.administratorQueryAnswer;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import dmax.dialog.SpotsDialog;
import es.ulpgc.montesdeoca110.cristina.zonget.R;
import es.ulpgc.montesdeoca110.cristina.zonget.administratorQueryDetail.AdministratorQueryDetailActivity;

import static android.widget.Toast.LENGTH_LONG;

public class AdministratorQueryAnswerActivity
        extends AppCompatActivity implements AdministratorQueryAnswerContract.View {

  public static String TAG = AdministratorQueryAnswerActivity.class.getSimpleName();

  private AdministratorQueryAnswerContract.Presenter presenter;

  private EditText answer;
  private SpotsDialog dialog;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);

    AdministratorQueryAnswerScreen.configure(this);

    //Theme
    String themeName = presenter.getActualThemeName();
    if (themeName != null) {
      int themeID = getResources().getIdentifier(themeName, "style", getPackageName());
      setTheme(themeID);
    }

    setContentView(R.layout.activity_administrator_query_answer);

    Toolbar toolbar = findViewById(R.id.toolbar);
    setSupportActionBar(toolbar);

    // Show the data in the action bar
    ActionBar actionBar = getSupportActionBar();
    if (actionBar != null) {
      actionBar.setDisplayHomeAsUpEnabled(true);
      actionBar.setTitle(getString(R.string.administrator_query_answer_activity_name));
    }

    answer = findViewById(R.id.user_answer_query_edit_text);
    dialog = new SpotsDialog(this, R.style.SentEmailDialogProgressTheme);

  }

  @Override
  protected void onResume() {
    super.onResume();

    // do some work
    presenter.fetchData();
  }

  @Override
  public void injectPresenter(AdministratorQueryAnswerContract.Presenter presenter) {
    this.presenter = presenter;
  }

  @Override
  public void displayData(AdministratorQueryAnswerViewModel viewModel) {

  }

  @Override
  public boolean onOptionsItemSelected(MenuItem item) {
    switch (item.getItemId()) {
      default:
        int id = item.getItemId();
        if (id == android.R.id.home) {
          navigateUpTo(new Intent(this, AdministratorQueryDetailActivity.class));
          return true;
        }
        return super.onOptionsItemSelected(item);
    }
  }

  public void onSendButtonClicked(View v) {
    presenter.onSendButtonClicked(answer.getText() + "");
  }

  @Override
  public void startSendAnswer() {
    dialog.show();
  }

  @Override
  public void displayToastMessage(final String s) {
    runOnUiThread(new Runnable() {
      @Override
      public void run() {
        Toast.makeText(getApplicationContext(), s, LENGTH_LONG).show();
      }
    });
  }

  @Override
  public void finish() {
    dialog.dismiss();
    displayToastMessage("La respuesta se ha enviado correctamente.");
    super.finish();
  }


}
