package es.ulpgc.montesdeoca110.cristina.zonget.administratorAgenda;

import android.support.v4.app.FragmentActivity;
import es.ulpgc.montesdeoca110.cristina.zonget.app.AppMediator;
import java.lang.ref.WeakReference;

public class AdministratorAgendaScreen {

  public static void configure(AdministratorAgendaContract.View view) {

    WeakReference<FragmentActivity> context =
            new WeakReference<>((FragmentActivity) view);

    AppMediator mediator = (AppMediator) context.get().getApplication();
    AdministratorAgendaState state = mediator.getAdministratorAgendaState();

    AdministratorAgendaContract.Router router = new AdministratorAgendaRouter(mediator);
    AdministratorAgendaContract.Presenter presenter = new AdministratorAgendaPresenter(state);
    AdministratorAgendaContract.Model model = new AdministratorAgendaModel();
    presenter.injectModel(model);
    presenter.injectRouter(router);
    presenter.injectView(new WeakReference<>(view));

    view.injectPresenter(presenter);

  }
}
