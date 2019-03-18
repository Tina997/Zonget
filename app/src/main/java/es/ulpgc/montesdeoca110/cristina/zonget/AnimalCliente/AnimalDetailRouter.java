package es.ulpgc.montesdeoca110.cristina.zonget.AnimalCliente;

import android.content.Intent;
import android.content.Context;

import es.ulpgc.montesdeoca110.cristina.zonget.App.AnimalClientesItem;
import es.ulpgc.montesdeoca110.cristina.zonget.App.AppMediator;

public class AnimalDetailRouter implements AnimalDetailContract.Router {

    public static String TAG = AnimalDetailRouter.class.getSimpleName();

    private AppMediator mediator;

    public AnimalDetailRouter(AppMediator mediator) {
        this.mediator = mediator;
    }

    @Override
    public void navigateToNextScreen() {
        Context context = mediator.getApplicationContext();
        Intent intent = new Intent(context, AnimalDetailActivity.class);
        context.startActivity(intent);
    }

    @Override
    public void passDataToNextScreen(AnimalDetailState state) {
      //  mediator.setAnimalDetailState(state);
    }

    @Override
    public AnimalClientesItem getDataFromPreviousScreen() {
        AnimalClientesItem animal = mediator.getAnimal();

        return animal;
    }
}
