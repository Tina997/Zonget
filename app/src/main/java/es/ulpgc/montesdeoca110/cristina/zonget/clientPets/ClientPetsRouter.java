package es.ulpgc.montesdeoca110.cristina.zonget.clientPets;

import android.util.Log;
import android.content.Intent;
import android.content.Context;

import es.ulpgc.montesdeoca110.cristina.zonget.app.AppMediator;
import es.ulpgc.montesdeoca110.cristina.zonget.app.PetsItem;
import es.ulpgc.montesdeoca110.cristina.zonget.clientPetsDetail.ClientPetsDetailActivity;

public class ClientPetsRouter implements ClientPetsContract.Router {

    public static String TAG = ClientPetsRouter.class.getSimpleName();

    private AppMediator mediator;

    public ClientPetsRouter(AppMediator mediator) {
        this.mediator = mediator;
    }

    @Override
    public void navigateToPetsDetailScreen() {
        Context context = mediator.getApplicationContext();
        Intent intent = new Intent(context, ClientPetsDetailActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        context.startActivity(intent);
    }

    @Override
    public void passDataToPetsDetailScreen(PetsItem item) {
        mediator.setClientPetsState(item);
    }

    @Override
    public ClientPetsState getDataFromPreviousScreen() {
        ClientPetsState state = mediator.getClientPetsState();
        return state;
    }
}
