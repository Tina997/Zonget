package es.ulpgc.montesdeoca110.cristina.zonget.lostPetsDetail;

import android.util.Log;
import android.content.Intent;
import android.content.Context;

import es.ulpgc.montesdeoca110.cristina.zonget.app.AppMediator;
import es.ulpgc.montesdeoca110.cristina.zonget.app.LostPetItem;

public class LostPetsDetailRouter implements LostPetsDetailContract.Router {

    public static String TAG = LostPetsDetailRouter.class.getSimpleName();

    private AppMediator mediator;

    public LostPetsDetailRouter(AppMediator mediator) {
        this.mediator = mediator;
    }

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
}
