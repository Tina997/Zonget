package es.ulpgc.montesdeoca110.cristina.zonget.clientPets;

import java.lang.ref.WeakReference;

import android.support.v4.app.FragmentActivity;

import es.ulpgc.montesdeoca110.cristina.zonget.app.AppMediator;

public class ClientPetsScreen {

    public static void configure(ClientPetsContract.View view) {

        WeakReference<FragmentActivity> context =
                new WeakReference<>((FragmentActivity) view);

        AppMediator mediator = (AppMediator) context.get().getApplication();
        ClientPetsState state = mediator.getClientPetsState();

        ClientPetsContract.Router router = new ClientPetsRouter(mediator);
        ClientPetsContract.Presenter presenter = new ClientPetsPresenter(state);
        ClientPetsContract.Model model = new ClientPetsModel();
        presenter.injectModel(model);
        presenter.injectRouter(router);
        presenter.injectView(new WeakReference<>(view));

        view.injectPresenter(presenter);

    }
}
