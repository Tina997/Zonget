package es.ulpgc.montesdeoca110.cristina.zonget.clientPetsDetail;

import java.lang.ref.WeakReference;

import android.support.v4.app.FragmentActivity;

import es.ulpgc.montesdeoca110.cristina.zonget.app.AppMediator;

public class ClientPetsDetailScreen {

    public static void configure(ClientPetsDetailContract.View view) {

        WeakReference<FragmentActivity> context =
                new WeakReference<>((FragmentActivity) view);

        AppMediator mediator = (AppMediator) context.get().getApplication();
        ClientPetsDetailState state = mediator.getClientPetsDetailState();

        ClientPetsDetailContract.Router router = new ClientPetsDetailRouter(mediator);
        ClientPetsDetailContract.Presenter presenter = new ClientPetsDetailPresenter(state);
        ClientPetsDetailContract.Model model = new ClientPetsDetailModel();
        presenter.injectModel(model);
        presenter.injectRouter(router);
        presenter.injectView(new WeakReference<>(view));

        view.injectPresenter(presenter);

    }
}
