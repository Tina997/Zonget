package es.ulpgc.montesdeoca110.cristina.zonget.administratorUsersPets;

import android.support.v4.app.FragmentActivity;

import es.ulpgc.montesdeoca110.cristina.zonget.app.AppMediator;
import es.ulpgc.montesdeoca110.cristina.zonget.data.RepositoryContract;
import es.ulpgc.montesdeoca110.cristina.zonget.data.AccountsRepository;

import java.lang.ref.WeakReference;

public class AdministratorUsersPetsListScreen {

  public static void configure(AdministratorUsersPetsListContract.View view) {

    WeakReference<FragmentActivity> context =
            new WeakReference<>((FragmentActivity) view);

    AppMediator mediator = (AppMediator) context.get().getApplication();
    AdministratorUsersPetsListState state = mediator.getAdministratorUsersPetsListState();
    RepositoryContract.Accounts accountsRepository = AccountsRepository.getInstance(context.get());

    AdministratorUsersPetsListContract.Router router =
            new AdministratorUsersPetsListRouter(mediator);
    AdministratorUsersPetsListContract.Presenter presenter =
            new AdministratorUsersPetsListPresenter(state);
    AdministratorUsersPetsListContract.Model model = new AdministratorUsersPetsListModel(accountsRepository);
    presenter.injectModel(model);
    presenter.injectRouter(router);
    presenter.injectView(new WeakReference<>(view));

    view.injectPresenter(presenter);

  }
}
