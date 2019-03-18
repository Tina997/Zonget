package es.ulpgc.montesdeoca110.cristina.zonget.AnimalesCliente;

import android.content.Intent;
import android.content.Context;

import es.ulpgc.montesdeoca110.cristina.zonget.AnimalCliente.AnimalDetailActivity;
import es.ulpgc.montesdeoca110.cristina.zonget.App.AnimalClientesItem;
import es.ulpgc.montesdeoca110.cristina.zonget.App.AppMediator;

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
