package es.ulpgc.montesdeoca110.cristina.zonget.lostPetsDetail;

import android.content.Intent;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.RequestBuilder;
import com.bumptech.glide.RequestManager;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.request.RequestOptions;

import es.ulpgc.montesdeoca110.cristina.zonget.R;
import es.ulpgc.montesdeoca110.cristina.zonget.app.LostPetItem;
import es.ulpgc.montesdeoca110.cristina.zonget.lostPets.LostPetsListActivity;

public class LostPetsDetailActivity
        extends AppCompatActivity implements LostPetsDetailContract.View {

    public static String TAG = LostPetsDetailActivity.class.getSimpleName();

    private LostPetsDetailContract.Presenter presenter;
    private ActionBar actionBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lost_pets_detail);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true);
            actionBar.setTitle(R.string.lost_pets_tittle);
        }

        // do the setup
        LostPetsDetailScreen.configure(this);
    }

    @Override
    protected void onResume() {
        super.onResume();

        // do some work
        presenter.fetchLostPetDetailData();
    }

    @Override
    public void injectPresenter(LostPetsDetailContract.Presenter presenter) {
        this.presenter = presenter;
    }

    @Override
    public void displayLostPetDetailData(LostPetsDetailViewModel viewModel) {
        //Log.e(TAG, "displayData()");
        LostPetItem lostPetItem = viewModel.lostPetItem;
        // deal with the data
        loadImageFromURL((ImageView) findViewById(R.id.lost_pet_image),lostPetItem.picture);
        ((TextView)findViewById(R.id.lost_pet_date)).setText(lostPetItem.date);
        ((TextView)findViewById(R.id.lost_pet_breed)).setText(lostPetItem.breed);
        ((TextView)findViewById(R.id.lost_pet_chipNum)).setText(lostPetItem.chipNum);
        ((TextView)findViewById(R.id.lost_pet_details)).setText(lostPetItem.details);
        ((TextView)findViewById(R.id.lost_pet_phone)).setText(lostPetItem.phoneNum);

    }
    private void loadImageFromURL(ImageView imageView, String imageUrl){
        RequestManager reqManager = Glide.with(imageView.getContext());
        RequestBuilder reqBuilder = reqManager.load(imageUrl);
        RequestOptions reqOptions = new RequestOptions();
        reqOptions.diskCacheStrategy(DiskCacheStrategy.ALL);
        reqBuilder.apply(reqOptions);
        reqBuilder.into(imageView);
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == android.R.id.home) {
            navigateUpTo(new Intent(this, LostPetsListActivity.class));
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
