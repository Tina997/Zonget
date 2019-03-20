package es.ulpgc.montesdeoca110.cristina.zonget.administratorAgenda;

import java.lang.ref.WeakReference;

import android.support.v4.app.FragmentActivity;

import es.ulpgc.montesdeoca110.cristina.zonget.app.AppMediator;

public class AdministratorAgendaScreen {

    public static void configure(AdministratorAgendaContract.View view) {

        WeakReference<FragmentActivity> context =
                new WeakReference<>((FragmentActivity) view);

        AppMediator mediator = (AppMediator) context.get().getApplication();
        AdministratorAdministratorAgendaState state = mediator.getAdministratorAgendaState();

        AdministratorAgendaContract.Router router = new AdministratorAgendaRouter(mediator);
        AdministratorAgendaContract.Presenter presenter = new AdministratorAgendaPresenter(state);
        AdministratorAgendaContract.Model model = new AdministratorAgendaModel();
       presenter.injectModel(model);
        presenter.injectRouter(router);
        presenter.injectView(new WeakReference<>(view));

        view.injectPresenter(presenter);

    }
}
