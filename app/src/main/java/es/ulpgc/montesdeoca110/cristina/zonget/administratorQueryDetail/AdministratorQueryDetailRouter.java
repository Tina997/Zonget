package es.ulpgc.montesdeoca110.cristina.zonget.administratorQueryDetail;

import android.util.Log;
import android.content.Intent;
import android.content.Context;

import es.ulpgc.montesdeoca110.cristina.zonget.administratorQueryAnswer.AdministratorQueryAnswerActivity;
import es.ulpgc.montesdeoca110.cristina.zonget.app.AppMediator;

public class AdministratorQueryDetailRouter implements AdministratorQueryDetailContract.Router {

    public static String TAG = AdministratorQueryDetailRouter.class.getSimpleName();

    private AppMediator mediator;

    public AdministratorQueryDetailRouter(AppMediator mediator) {
        this.mediator = mediator;
    }

    @Override
    public void navigateToNextScreen() {
        Context context = mediator.getApplicationContext();
        Intent intent = new Intent(context, AdministratorQueryDetailActivity.class);
        context.startActivity(intent);
    }

    @Override
    public void passDataToNextScreen(AdministratorQueryDetailState state) {
        mediator.setAdministratorQueryDetailState(state);
    }

    @Override
    public AdministratorQueryDetailState getDataFromPreviousScreen() {
        AdministratorQueryDetailState state = mediator.getAdministratorQueryDetailState();
        return state;
    }

    @Override
    public void navigateToAdministratorQueryAnswerScreen(){
        Context context = mediator.getApplicationContext();
        Intent intent = new Intent(context, AdministratorQueryAnswerActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        context.startActivity(intent);
    }
}
