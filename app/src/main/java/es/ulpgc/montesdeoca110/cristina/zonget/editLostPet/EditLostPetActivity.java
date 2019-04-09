package es.ulpgc.montesdeoca110.cristina.zonget.editLostPet;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import es.ulpc.montesdeoca110.cristina.zonget.complete.R;

public class EditLostPetActivity
        extends AppCompatActivity implements EditLostPetContract.View {

    public static String TAG = EditLostPetActivity.class.getSimpleName();

    private EditLostPetContract.Presenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_lost_pet);

        // do the setup
        EditLostPetScreen.configure(this);
    }

    @Override
    protected void onResume() {
        super.onResume();

        // do some work
        presenter.fetchData();
    }

    @Override
    public void injectPresenter(EditLostPetContract.Presenter presenter) {
        this.presenter = presenter;
    }

    @Override
    public void displayData(EditLostPetViewModel viewModel) {
        //Log.e(TAG, "displayData()");

        // deal with the data
        ((TextView) findViewById(R.id.data)).setText(viewModel.data);
    }
}
