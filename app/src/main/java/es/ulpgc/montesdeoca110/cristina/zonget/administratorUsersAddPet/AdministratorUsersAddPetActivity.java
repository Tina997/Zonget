package es.ulpgc.montesdeoca110.cristina.zonget.administratorUsersAddPet;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import es.ulpgc.montesdeoca110.cristina.zonget.R;

public class AdministratorUsersAddPetActivity
        extends AppCompatActivity implements AdministratorUsersAddPetContract.View {

    public static String TAG = AdministratorUsersAddPetActivity.class.getSimpleName();

    private AdministratorUsersAddPetContract.Presenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_administrator_users_add_pet);

        // do the setup
        AdministratorUsersAddPetScreen.configure(this);
    }

    @Override
    protected void onResume() {
        super.onResume();

        // do some work
//        presenter.fetchData();
    }

    @Override
    public void injectPresenter(AdministratorUsersAddPetContract.Presenter presenter) {
        this.presenter = presenter;
    }

    @Override
    public void displayData(AdministratorUsersAddPetViewModel viewModel) {
        //Log.e(TAG, "displayData()");

        // deal with the data
    }
}
