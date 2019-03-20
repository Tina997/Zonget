package es.ulpgc.montesdeoca110.cristina.zonget.clientPets;

import android.content.Intent;
import android.content.Context;

import es.ulpgc.montesdeoca110.cristina.zonget.clientPetsDetail.AnimalDetailActivity;
import es.ulpgc.montesdeoca110.cristina.zonget.app.AnimalClientesItem;
import es.ulpgc.montesdeoca110.cristina.zonget.app.AppMediator;

public class AnimalesClienteListRouter implements AnimalesClienteListContract.Router {

    public static String TAG = AnimalesClienteListRouter.class.getSimpleName();

    private AppMediator mediator;

    public AnimalesClienteListRouter(AppMediator mediator) {
        this.mediator = mediator;
    }

    @Override
    public void navigateToAnimalDetailScreen() {
        Context context = mediator.getApplicationContext();
        Intent intent = new Intent(context, AnimalDetailActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        context.startActivity(intent);
    }

    @Override
    public void passDataToAnimalDetailScreen(AnimalClientesItem item) {
        mediator.setAnimalesClienteList(item);
    }

    @Override
    public AnimalesClienteListState getDataFromPreviousScreen() {
        AnimalesClienteListState state = mediator.getAnimalesClienteListState();
        return state;
    }
}
