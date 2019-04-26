package es.ulpgc.montesdeoca110.cristina.zonget.lostPets;

import android.content.Intent;
import android.content.Context;

import es.ulpgc.montesdeoca110.cristina.zonget.addLostPet.AddLostPetActivity;
import es.ulpgc.montesdeoca110.cristina.zonget.app.AppMediator;
import es.ulpgc.montesdeoca110.cristina.zonget.app.LostPetItem;
import es.ulpgc.montesdeoca110.cristina.zonget.lostPetsDetail.LostPetsDetailActivity;

public class LostPetsListRouter implements LostPetsListContract.Router {

    public static String TAG = LostPetsListRouter.class.getSimpleName();

    private AppMediator mediator;

    public LostPetsListRouter(AppMediator mediator) {
        this.mediator = mediator;
    }

    @Override
    public void navigateToNextScreen() {
        Context context = mediator.getApplicationContext();
        Intent intent = new Intent(context, LostPetsDetailActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        context.startActivity(intent);
    }

    @Override
    public void passDataToDetailScreen(LostPetItem item) {
        mediator.setLostPet(item);
    }

    @Override
    public LostPetsListState getDataFromPreviousScreen() {
        LostPetsListState state = mediator.getlostPetsListState();
        return state;
    }

    @Override
    public void navigateToAddLostPetScreen() {
        Context context = mediator.getApplicationContext();
        Intent intent = new Intent(context, AddLostPetActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        context.startActivity(intent);
    }

    @Override
    public String getActualThemeName() {
        return mediator.getactualThemeName();
    }
}
