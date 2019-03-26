package es.ulpgc.montesdeoca110.cristina.zonget.userNewQuery;

import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.widget.EditText;
import android.widget.ImageButton;

import es.ulpgc.montesdeoca110.cristina.zonget.R;

public class UserNewQueryActivity
        extends AppCompatActivity implements UserNewQueryContract.View {

    public static String TAG = UserNewQueryActivity.class.getSimpleName();

    private UserNewQueryContract.Presenter presenter;

    //Elementos de la vista
    private Toolbar toolbar;
    private EditText queryTitleEditText, queryDescriptionEditText;
    private ImageButton attachImagesButton, sendQueryButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_new_query);

        //Configuracion de la toolBar/actionBar
        toolbar = findViewById(R.id.user_new_query_toolbar);;
        setSupportActionBar(toolbar);

        ActionBar actionBar = getSupportActionBar();
        actionBar.setTitle("Nueva consulta");
        actionBar.setDisplayHomeAsUpEnabled(true);

        //Búsqueda de los elementos de la vista
        queryTitleEditText = findViewById(R.id.user_new_query_title_edit_text);
        queryDescriptionEditText =  findViewById(R.id.user_new_query_desciption_edit_text);
        attachImagesButton = findViewById(R.id.user_new_query_attach_image_button);
        sendQueryButton = findViewById(R.id.user_new_query_send_button);

        // do the setup
        UserNewQueryScreen.configure(this);
    }

    @Override
    protected void onResume() {
        super.onResume();

        // do some work
        presenter.fetchData();
    }

    @Override
    public void injectPresenter(UserNewQueryContract.Presenter presenter) {
        this.presenter = presenter;
    }

    @Override
    public void displayData(UserNewQueryViewModel viewModel) {
        //Log.e(TAG, "displayData()");

        // deal with the data

    }
}
