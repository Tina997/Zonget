package es.ulpgc.montesdeoca110.cristina.zonget.administratorUsersList;

import java.lang.ref.WeakReference;

import android.support.v4.app.FragmentActivity;

import es.ulpgc.montesdeoca110.cristina.zonget.app.AppMediator;

public class AdministratorUsersListScreen {

    public static void configure(AdministratorUsersListContract.View view) {

        WeakReference<FragmentActivity> context =
                new WeakReference<>((FragmentActivity) view);

        AppMediator mediator = (AppMediator) context.get().getApplication();
        AdministratorUsersListState state = mediator.getAdministratorUsersListState();

        AdministratorUsersListContract.Router router = new AdministratorUsersListRouter(mediator);
        AdministratorUsersListContract.Presenter presenter = new AdministratorUsersListPresenter(state);
        AdministratorUsersListContract.Model model = new AdministratorUsersListModel();
        presenter.injectModel(model);
        presenter.injectRouter(router);
        presenter.injectView(new WeakReference<>(view));

        view.injectPresenter(presenter);

    }
}
