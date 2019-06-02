package es.ulpgc.montesdeoca110.cristina.zonget.administratorQueryDetail;

import android.support.v4.app.FragmentActivity;
import es.ulpgc.montesdeoca110.cristina.zonget.app.AppMediator;
import java.lang.ref.WeakReference;

class AdministratorQueryDetailScreen {

  public static void configure(AdministratorQueryDetailContract.View view) {

    WeakReference<FragmentActivity> context =
            new WeakReference<>((FragmentActivity) view);

    AppMediator mediator = (AppMediator) context.get().getApplication();
    AdministratorQueryDetailState state = mediator.getAdministratorQueryDetailState();

    AdministratorQueryDetailContract.Router router = new AdministratorQueryDetailRouter(mediator);
    AdministratorQueryDetailContract.Presenter presenter =
            new AdministratorQueryDetailPresenter(state);
    AdministratorQueryDetailContract.Model model = new AdministratorQueryDetailModel();
    presenter.injectModel(model);
    presenter.injectRouter(router);
    presenter.injectView(new WeakReference<>(view));

    view.injectPresenter(presenter);

  }
}
