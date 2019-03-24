package es.ulpgc.montesdeoca110.cristina.zonget.queriesMenu;

import java.lang.ref.WeakReference;

import android.support.v4.app.FragmentActivity;

public class QueriesMenuScreen {

    public static void configure(QueriesMenuContract.View view) {

        WeakReference<FragmentActivity> context =
                new WeakReference<>((FragmentActivity) view);

        AppMediator mediator = (AppMediator) context.get().getApplication();
        QueriesMenuState state = mediator.getQueriesMenuState();

        QueriesMenuContract.Router router = new QueriesMenuRouter(mediator);
        QueriesMenuContract.Presenter presenter = new QueriesMenuPresenter(state);
        QueriesMenuContract.Model model = new QueriesMenuModel();
        presenter.injectModel(model);
        presenter.injectRouter(router);
        presenter.injectView(new WeakReference<>(view));

        view.injectPresenter(presenter);

    }
}
