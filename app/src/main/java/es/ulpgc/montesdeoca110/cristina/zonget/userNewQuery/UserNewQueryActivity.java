package es.ulpgc.montesdeoca110.cristina.zonget.userNewQuery;

import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;

import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

import dmax.dialog.SpotsDialog;
import es.ulpgc.montesdeoca110.cristina.zonget.R;

import static android.widget.Toast.LENGTH_LONG;

public class UserNewQueryActivity extends AppCompatActivity implements UserNewQueryContract.View {

  private UserNewQueryContract.Presenter presenter;

  private SpotsDialog dialog;

  private EditText queryTitleEditText;
  private EditText queryDescriptionEditText;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);

    UserNewQueryScreen.configure(this);

    //Theme
    String themeName = presenter.getActualThemeName();
    if (themeName != null) {
      int themeID = getResources().getIdentifier(themeName, "style", getPackageName());
      setTheme(themeID);
    }

    setContentView(R.layout.activity_user_new_query);

    //Configuracion de la toolBar/actionBar
    //Elementos de la vista
    Toolbar toolbar = findViewById(R.id.toolbar);
    setSupportActionBar(toolbar);

    ActionBar actionBar = getSupportActionBar();
    actionBar.setTitle("Nueva consulta");
    actionBar.setDisplayHomeAsUpEnabled(true);

    //Búsqueda de los elementos de la vista
    queryTitleEditText = findViewById(R.id.user_new_query_title_edit_text);
    queryDescriptionEditText = findViewById(R.id.user_new_query_desciption_edit_text);
    ImageButton attachImagesButton = findViewById(R.id.user_new_query_attach_image_button);
    ImageButton sendQueryButton = findViewById(R.id.user_new_query_send_button);

    dialog = new SpotsDialog(this, R.style.SentEmailDialogProgressTheme);

    //Listeners
    sendQueryButton.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View v) {
        presenter.sendButtonPressed(queryTitleEditText.getText() + "", queryDescriptionEditText.getText() + "");
      }
    });
  }

  @Override
  protected void onResume() {
    super.onResume();

    // do some work
    presenter.fetchUserNewQueryData();
  }

  @Override
  public void injectPresenter(UserNewQueryContract.Presenter presenter) {
    this.presenter = presenter;
  }

  @Override
  public void displayUserNewQueryData(UserNewQueryViewModel viewModel) {
  }


  @Override
  public void startSendQuery() {
    dialog.show();
  }

  @Override
  public void displayToastMessage(final String message) {
    runOnUiThread(new Runnable() {
      @Override
      public void run() {
        Toast.makeText(getApplicationContext(), message, LENGTH_LONG).show();
      }
    });
  }

  @Override
  public void finish() {
    dialog.dismiss();
    displayToastMessage("La consulta se ha enviado correctamente.");

    super.finish();
  }

  @Override
  public boolean onOptionsItemSelected(MenuItem item) {
    // Handle presses on the action bar items
    switch (item.getItemId()) {
      case android.R.id.home:
        presenter.backButtonPressed();
        super.finish();
        return true;
      default:
        return super.onOptionsItemSelected(item);
    }
  }
}
