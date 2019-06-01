package es.ulpgc.montesdeoca110.cristina.zonget.administratorQueryAnswer;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.EdgeEffect;
import android.widget.EditText;
import android.widget.TextView;

import es.ulpgc.montesdeoca110.cristina.zonget.R;
import es.ulpgc.montesdeoca110.cristina.zonget.administratorQueryDetail.AdministratorQueryDetailActivity;

public class AdministratorQueryAnswerActivity
        extends AppCompatActivity implements AdministratorQueryAnswerContract.View {

  public static String TAG = AdministratorQueryAnswerActivity.class.getSimpleName();

  private AdministratorQueryAnswerContract.Presenter presenter;

 EditText answer;

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
          //TODO destruir activity
          navigateUpTo(new Intent(this, AdministratorQueryDetailActivity.class));
          return true;
        }
        return super.onOptionsItemSelected(item);
    }
  }

  public void onSendButtonClicked(View v) {
    if(!answer.getText().equals(null)){
      presenter.onSendButtonClicked(answer.getText() + "");
      presenter.navigateToAdministratorInboxScreen();
    }else{
      //toast
    }

    finish();
  }
}
