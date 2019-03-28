package es.ulpgc.montesdeoca110.cristina.zonget.administratorQueryAnswer;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import es.ulpgc.montesdeoca110.cristina.zonget.R;

public class AdministratorQueryAnswerActivity
        extends AppCompatActivity implements AdministratorQueryAnswerContract.View {

    public static String TAG = AdministratorQueryAnswerActivity.class.getSimpleName();

    private AdministratorQueryAnswerContract.Presenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_administrator_query_answer);

        // do the setup
        AdministratorQueryAnswerScreen.configure(this);
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
}
