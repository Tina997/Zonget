package es.ulpgc.montesdeoca110.cristina.zonget.administratorInbox;

import java.lang.ref.WeakReference;

import android.support.v4.app.FragmentActivity;

import es.ulpgc.montesdeoca110.cristina.zonget.app.AppMediator;

public class AdministratorInboxScreen {

    public static void configure(AdministratorInboxContract.View view) {

        WeakReference<FragmentActivity> context =
                new WeakReference<>((FragmentActivity) view);

        AppMediator mediator = (AppMediator) context.get().getApplication();
        AdministratorInboxState state = mediator.getAdministratorInboxState();

        AdministratorInboxContract.Router router = new AdministratorInboxRouter(mediator);
        AdministratorInboxContract.Presenter presenter = new AdministratorInboxPresenter(state);
        AdministratorInboxContract.Model model = new AdministratorInboxModel();
        presenter.injectModel(model);
        presenter.injectRouter(router);
        presenter.injectView(new WeakReference<>(view));

        view.injectPresenter(presenter);

    }
}
