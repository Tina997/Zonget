package es.ulpgc.montesdeoca110.cristina.zonget.administratorUsersList;

import android.support.v4.app.FragmentActivity;

import es.ulpgc.montesdeoca110.cristina.zonget.app.AppMediator;
import es.ulpgc.montesdeoca110.cristina.zonget.data.RepositoryContract;
import es.ulpgc.montesdeoca110.cristina.zonget.data.UsersRepository;
import java.lang.ref.WeakReference;

public class AdministratorUsersListScreen {

  public static void configure(AdministratorUsersListContract.View view) {

    WeakReference<FragmentActivity> context =
            new WeakReference<>((FragmentActivity) view);

    AppMediator mediator = (AppMediator) context.get().getApplication();
    AdministratorUsersListState state = mediator.getAdministratorUsersListState();
    RepositoryContract.Users repository = UsersRepository.getInstance(context.get());

    AdministratorUsersListContract.Router router = new AdministratorUsersListRouter(mediator);
    AdministratorUsersListContract.Presenter presenter = new AdministratorUsersListPresenter(state);
    AdministratorUsersListContract.Model model = new AdministratorUsersListModel(repository);
    presenter.injectModel(model);
    presenter.injectRouter(router);
    presenter.injectView(new WeakReference<>(view));

    view.injectPresenter(presenter);

  }
}
