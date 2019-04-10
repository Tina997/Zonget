package es.ulpgc.montesdeoca110.cristina.zonget.editPetForAdoption;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import es.ulpgc.montesdeoca110.cristina.zonget.R;

public class EditPetForAdoptionActivity
        extends AppCompatActivity implements EditPetForAdoptionContract.View {

    public static String TAG = EditPetForAdoptionActivity.class.getSimpleName();

    private EditPetForAdoptionContract.Presenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_pet_for_adoption);

        // do the setup
        EditPetForAdoptionScreen.configure(this);
    }

    @Override
    protected void onResume() {
        super.onResume();

        // do some work
        presenter.fetchData();
    }

    @Override
    public void injectPresenter(EditPetForAdoptionContract.Presenter presenter) {
        this.presenter = presenter;
    }

    @Override
    public void displayData(EditPetForAdoptionViewModel viewModel) {
    }
}
