package es.ulpgc.montesdeoca110.cristina.zonget.addPetForAdoption;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;
import es.ulpgc.montesdeoca110.cristina.zonget.R;

public class AddPetForAdoptionActivity
        extends AppCompatActivity implements AddPetForAdoptionContract.View {

    public static String TAG = AddPetForAdoptionActivity.class.getSimpleName();

    private AddPetForAdoptionContract.Presenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_pet_for_adoption);

        // do the setup
        AddPetForAdoptionScreen.configure(this);
    }

    @Override
    protected void onResume() {
        super.onResume();

        // do some work
        presenter.fetchData();
    }

    @Override
    public void injectPresenter(AddPetForAdoptionContract.Presenter presenter) {
        this.presenter = presenter;
    }

    @Override
    public void displayData(AddPetForAdoptionViewModel viewModel) {

    }
}
