package es.ulpgc.montesdeoca110.cristina.zonget.queriesMenu;

import android.util.Log;
import android.content.Intent;
import android.content.Context;

public class QueriesMenuRouter implements QueriesMenuContract.Router {

    public static String TAG = QueriesMenuRouter.class.getSimpleName();

    private AppMediator mediator;

    public QueriesMenuRouter(AppMediator mediator) {
        this.mediator = mediator;
    }

    @Override
    public void navigateToNextScreen() {
        Context context = mediator.getApplicationContext();
        Intent intent = new Intent(context, QueriesMenuActivity.class);
        context.startActivity(intent);
    }

    @Override
    public void passDataToNextScreen(QueriesMenuState state) {
        mediator.setQueriesMenuState(state);
    }

    @Override
    public QueriesMenuState getDataFromPreviousScreen() {
        QueriesMenuState state = mediator.getQueriesMenuState();
        return state;
    }
}
