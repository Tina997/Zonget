package es.ulpgc.montesdeoca110.cristina.zonget.userAgenda;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.webkit.WebView;


import es.ulpgc.montesdeoca110.cristina.zonget.R;

public class UserAgendaActivity
        extends AppCompatActivity implements UserAgendaContract.View {

    public static String TAG = UserAgendaActivity.class.getSimpleName();

    private UserAgendaContract.Presenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_agenda);



        // do the setup
        UserAgendaScreen.configure(this);
    }

    @Override
    protected void onResume() {
        super.onResume();

        // do some work
        presenter.fetchData();
    }

    @Override
    public void injectPresenter(UserAgendaContract.Presenter presenter) {
        this.presenter = presenter;
    }

    @Override
    public void displayData(UserAgendaViewModel viewModel) {

    }
}
