package es.ulpgc.montesdeoca110.cristina.zonget.AnimalesCliente;

import android.util.Log;
import android.content.Intent;
import android.content.Context;

import es.ulpgc.montesdeoca110.cristina.zonget.App.AppMediator;

public class AnimalesClienteListRouter implements AnimalesClienteListContract.Router {

    public static String TAG = AnimalesClienteListRouter.class.getSimpleName();

    private AppMediator mediator;

    public AnimalesClienteListRouter(AppMediator mediator) {
        this.mediator = mediator;
    }

    @Override
    public void navigateToNextScreen() {
        Context context = mediator.getApplicationContext();
        Intent intent = new Intent(context, AnimalesClienteListActivity.class);
        context.startActivity(intent);
    }

    @Override
    public void passDataToNextScreen(AnimalesClienteListState state) {
       // mediator.setAnimalesClienteListState(state);
    }

    @Override
    public AnimalesClienteListState getDataFromPreviousScreen() {
      /*  AnimalesClienteListState state = mediator.getAnimalesClienteListState();
        return state;*/
      return null;
    }
}
