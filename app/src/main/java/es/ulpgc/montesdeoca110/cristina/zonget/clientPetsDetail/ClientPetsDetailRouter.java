package es.ulpgc.montesdeoca110.cristina.zonget.clientPetsDetail;

import android.util.Log;
import android.content.Intent;
import android.content.Context;

import es.ulpgc.montesdeoca110.cristina.zonget.app.AppMediator;
import es.ulpgc.montesdeoca110.cristina.zonget.app.PetsItem;

public class ClientPetsDetailRouter implements ClientPetsDetailContract.Router {

    public static String TAG = ClientPetsDetailRouter.class.getSimpleName();

    private AppMediator mediator;

    public ClientPetsDetailRouter(AppMediator mediator) {
        this.mediator = mediator;
    }

    @Override
    public void navigateToNextScreen() {
        Context context = mediator.getApplicationContext();
        Intent intent = new Intent(context, ClientPetsDetailActivity.class);
        context.startActivity(intent);
    }

    @Override
    public void passDataToNextScreen(ClientPetsDetailState state) {
       // mediator.setClientPetsDetailState(state);
    }

    @Override
    public PetsItem getDataFromPreviousScreen() {
        PetsItem pet = mediator.getAnimal();
        return pet;
    }
}
