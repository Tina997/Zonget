package es.ulpgc.montesdeoca110.cristina.zonget.changeTheme;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import es.ulpgc.montesdeoca110.cristina.zonget.R;


public class ChangeThemeActivity extends AppCompatActivity implements ChangeThemeContract.View {

    private ChangeThemeContract.Presenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_change_theme);

        ChangeThemeScreen.configure(this);
    }

    @Override
    protected void onResume() {
        super.onResume();

        presenter.fetchChangeThemeData();
    }

    @Override
    public void displayChangeThemeData(ChangeThemeViewModel viewModel) {

    }

    @Override
    public void injectPresenter(ChangeThemeContract.Presenter presenter) {
        this.presenter = presenter;
    }
}
