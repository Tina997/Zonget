package es.ulpgc.montesdeoca110.cristina.zonget.petsForAdoptionDetail;

import android.content.Intent;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;


import com.bumptech.glide.Glide;
import com.bumptech.glide.RequestBuilder;
import com.bumptech.glide.RequestManager;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.request.RequestOptions;

import es.ulpgc.montesdeoca110.cristina.zonget.R;
import es.ulpgc.montesdeoca110.cristina.zonget.app.PetForAdoptionItem;
import es.ulpgc.montesdeoca110.cristina.zonget.lostPets.LostPetsListActivity;

public class PetsForAdoptionDetailActivity
        extends AppCompatActivity implements PetsForAdoptionDetailContract.View {

    public static String TAG = PetsForAdoptionDetailActivity.class.getSimpleName();

    private PetsForAdoptionDetailContract.Presenter presenter;

    private ActionBar actionBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pets_for_adoption_detail);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        actionBar = getSupportActionBar();
        if(actionBar != null){
            actionBar.setDisplayHomeAsUpEnabled(true);
            actionBar.setTitle(R.string.animal_detail_tittle);
        }

        // do the setup
        PetsForAdoptionDetailScreen.configure(this);
    }

    @Override
    protected void onResume() {
        super.onResume();

        // do some work
        presenter.fetchPetForAdoptionDetailData();
    }

    @Override
    public void injectPresenter(PetsForAdoptionDetailContract.Presenter presenter) {
        this.presenter = presenter;
    }

    @Override
    public void displayData(PetsForAdoptionDetailViewModel viewModel) {
        PetForAdoptionItem petForAdoptionItem = viewModel.petForAdoptionItem;
        loadImageFromURL((ImageView) findViewById(R.id.pet_for_adoption_image),petForAdoptionItem.picture);
        ((TextView)findViewById(R.id.pet_for_adoption_date)).setText(petForAdoptionItem.date);
        ((TextView)findViewById(R.id.pet_for_adoption_breed)).setText(petForAdoptionItem.breed);
        ((TextView)findViewById(R.id.pet_for_adoption_details)).setText(petForAdoptionItem.details);
        ((TextView)findViewById(R.id.pet_for_adoption_phone)).setText(petForAdoptionItem.phoneNum);

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
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu items for use in the action bar
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.administrator_appbar_buttons_user_pet_detail, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.action_edit) {

            return true;
        }else if(id == R.id.action_delete){

            return true;
        }
        return super.onOptionsItemSelected(item);
    }


}
