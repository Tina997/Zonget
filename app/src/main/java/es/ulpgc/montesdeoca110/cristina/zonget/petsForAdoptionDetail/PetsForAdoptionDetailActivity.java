package es.ulpgc.montesdeoca110.cristina.zonget.petsForAdoptionDetail;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;
import es.ulpgc.montesdeoca110.cristina.zonget.R;

public class PetsForAdoptionDetailActivity
        extends AppCompatActivity implements PetsForAdoptionDetailContract.View {

    public static String TAG = PetsForAdoptionDetailActivity.class.getSimpleName();

    private PetsForAdoptionDetailContract.Presenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pets_for_adoption_detail);

        // do the setup
        PetsForAdoptionDetailScreen.configure(this);
    }

    @Override
    protected void onResume() {
        super.onResume();

        // do some work
        presenter.fetchData();
    }

    @Override
    public void injectPresenter(PetsForAdoptionDetailContract.Presenter presenter) {
        this.presenter = presenter;
    }

    @Override
    public void displayData(PetsForAdoptionDetailViewModel viewModel) {

    }
}
