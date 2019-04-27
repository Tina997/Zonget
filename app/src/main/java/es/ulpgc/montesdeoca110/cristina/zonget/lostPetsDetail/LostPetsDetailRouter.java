package es.ulpgc.montesdeoca110.cristina.zonget.lostPetsDetail;

import android.util.Log;
import android.content.Intent;
import android.content.Context;

import es.ulpgc.montesdeoca110.cristina.zonget.administratorUsersPetDetail.AdministratorUserPetsDetailActivity;
import es.ulpgc.montesdeoca110.cristina.zonget.app.AppMediator;
import es.ulpgc.montesdeoca110.cristina.zonget.app.LostPetItem;
import es.ulpgc.montesdeoca110.cristina.zonget.editLostPet.EditLostPetActivity;
import es.ulpgc.montesdeoca110.cristina.zonget.lostPets.LostPetsListActivity;

public class LostPetsDetailRouter implements LostPetsDetailContract.Router {

    public static String TAG = LostPetsDetailRouter.class.getSimpleName();

    private AppMediator mediator;

    public LostPetsDetailRouter(AppMediator mediator) {
        this.mediator = mediator;
    }

    //Limpiar
    @Override
    public void navigateToNextScreen() {
        Context context = mediator.getApplicationContext();
        Intent intent = new Intent(context, LostPetsDetailActivity.class);
        context.startActivity(intent);
    }

    @Override
    public void passDataToNextScreen(LostPetsDetailState state) {
       // mediator.setLostPetsDetailState(state);
    }

    @Override
    public LostPetItem getDataFromLostPetsListScreen() {
        LostPetItem lostPetItem = mediator.getLostPetsDetailItem();
        return lostPetItem;
    }

    @Override
    public void navigateToEditScreen() {
        Context context = mediator.getApplicationContext();
        Intent intent = new Intent(context, EditLostPetActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        context.startActivity(intent);
    }

    @Override
    public void navigateToLostPetListScreen() {
        Context context = mediator.getApplicationContext();
        Intent intent = new Intent(context, LostPetsListActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        context.startActivity(intent);
    }

    @Override
    public String getActualThemeName() {
        return mediator.getactualThemeName();
    }

    @Override
    public void onBackButtonClicked() {
        Context context = mediator.getApplicationContext();
        Intent intent = new Intent(context, LostPetsListActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        context.startActivity(intent);
    }
}
