package es.ulpgc.montesdeoca110.cristina.zonget.administratorInbox;

import android.support.v4.app.FragmentActivity;
import es.ulpgc.montesdeoca110.cristina.zonget.app.AppMediator;
import es.ulpgc.montesdeoca110.cristina.zonget.data.AccountsRepository;
import es.ulpgc.montesdeoca110.cristina.zonget.data.QueriesRepository;
import es.ulpgc.montesdeoca110.cristina.zonget.data.RepositoryContract;

import java.lang.ref.WeakReference;

class AdministratorInboxScreen {

  public static void configure(AdministratorInboxContract.View view) {

    WeakReference<FragmentActivity> context =
            new WeakReference<>((FragmentActivity) view);

    AppMediator mediator = (AppMediator) context.get().getApplication();
    AdministratorInboxState state = mediator.getAdministratorInboxState();
    RepositoryContract.Queries queriesRepository = QueriesRepository.getInstance(context.get());
    RepositoryContract.Accounts accountsRepository = AccountsRepository.getInstance(context.get());

    AdministratorInboxContract.Router router = new AdministratorInboxRouter(mediator);
    AdministratorInboxContract.Presenter presenter = new AdministratorInboxPresenter(state);
    AdministratorInboxContract.Model model = new AdministratorInboxModel(queriesRepository
            , accountsRepository);
    presenter.injectModel(model);
    presenter.injectRouter(router);
    presenter.injectView(new WeakReference<>(view));

    view.injectPresenter(presenter);

  }
}
