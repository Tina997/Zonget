package es.ulpgc.montesdeoca110.cristina.zonget.userAgenda;

import android.support.v4.app.FragmentActivity;

import es.ulpgc.montesdeoca110.cristina.zonget.app.AppMediator;

import java.lang.ref.WeakReference;

class UserAgendaScreen {

  public static void configure(UserAgendaContract.View view) {

    WeakReference<FragmentActivity> context =
            new WeakReference<>((FragmentActivity) view);

    AppMediator mediator = (AppMediator) context.get().getApplication();
    UserAgendaState state = mediator.getUserAgendaState();

    UserAgendaContract.Router router = new UserAgendaRouter(mediator);
    UserAgendaContract.Presenter presenter = new UserAgendaPresenter(state);
    UserAgendaContract.Model model = new UserAgendaModel();
    presenter.injectModel(model);
    presenter.injectRouter(router);
    presenter.injectView(new WeakReference<>(view));

    view.injectPresenter(presenter);

  }
}
