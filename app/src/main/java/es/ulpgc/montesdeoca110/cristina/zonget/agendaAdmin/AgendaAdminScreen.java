package es.ulpgc.montesdeoca110.cristina.zonget.agendaAdmin;

import java.lang.ref.WeakReference;

import android.support.v4.app.FragmentActivity;

public class AgendaAdminScreen {

    public static void configure(AgendaAdminContract.View view) {

        WeakReference<FragmentActivity> context =
                new WeakReference<>((FragmentActivity) view);

        AppMediator mediator = (AppMediator) context.get().getApplication();
        AgendaAdminState state = mediator.getAgendaAdminState();

        AgendaAdminContract.Router router = new AgendaAdminRouter(mediator);
        AgendaAdminContract.Presenter presenter = new AgendaAdminPresenter(state);
        AgendaAdminContract.Model model = new AgendaAdminModel();
        presenter.injectModel(model);
        presenter.injectRouter(router);
        presenter.injectView(new WeakReference<>(view));

        view.injectPresenter(presenter);

    }
}
