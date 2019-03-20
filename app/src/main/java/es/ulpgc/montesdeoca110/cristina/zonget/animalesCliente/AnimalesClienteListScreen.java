package es.ulpgc.montesdeoca110.cristina.zonget.animalesCliente;

import java.lang.ref.WeakReference;

import android.support.v4.app.FragmentActivity;

import es.ulpgc.montesdeoca110.cristina.zonget.app.AppMediator;

public class AnimalesClienteListScreen {

    public static void configure(AnimalesClienteListContract.View view) {

        WeakReference<FragmentActivity> context =
                new WeakReference<>((FragmentActivity) view);

        AppMediator mediator = (AppMediator) context.get().getApplication();
        AnimalesClienteListState state = mediator.getAnimalesClienteListState();

        AnimalesClienteListContract.Router router = new AnimalesClienteListRouter(mediator);
        AnimalesClienteListContract.Presenter presenter = new AnimalesClienteListPresenter(state);
        AnimalesClienteListModel model = new AnimalesClienteListModel();
        presenter.injectModel(model);
        presenter.injectRouter(router);
        presenter.injectView(new WeakReference<>(view));

        view.injectPresenter(presenter);

    }
}
