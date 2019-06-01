package es.ulpgc.montesdeoca110.cristina.zonget.administratorUsersList;

import java.lang.ref.WeakReference;

import android.support.v4.app.FragmentActivity;

import es.ulpgc.montesdeoca110.cristina.zonget.app.AppMediator;
import es.ulpgc.montesdeoca110.cristina.zonget.data.RepositoryContract;
import es.ulpgc.montesdeoca110.cristina.zonget.data.AccountsRepository;

public class AdministratorUsersListScreen {

    public static void configure(AdministratorUsersListContract.View view) {

        WeakReference<FragmentActivity> context =
                new WeakReference<>((FragmentActivity) view);

        AppMediator mediator = (AppMediator) context.get().getApplication();
        AdministratorUsersListState state = mediator.getAdministratorUsersListState();
        RepositoryContract.Accounts repository = AccountsRepository.getInstance(context.get());

        AdministratorUsersListContract.Router router = new AdministratorUsersListRouter(mediator);
        AdministratorUsersListContract.Presenter presenter = new AdministratorUsersListPresenter(state);
        AdministratorUsersListContract.Model model = new AdministratorUsersListModel(repository);
        presenter.injectModel(model);
        presenter.injectRouter(router);
        presenter.injectView(new WeakReference<>(view));

        view.injectPresenter(presenter);

    }
}
