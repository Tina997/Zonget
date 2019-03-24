package es.ulpgc.montesdeoca110.cristina.zonget.administratorSearchUsers;

import java.lang.ref.WeakReference;

import android.support.v4.app.FragmentActivity;

import es.ulpgc.montesdeoca110.cristina.zonget.app.AppMediator;

public class AdministratorSearchUsersScreen {

    public static void configure(AdministratorSearchUsersContract.View view) {

        WeakReference<FragmentActivity> context =
                new WeakReference<>((FragmentActivity) view);

        AppMediator mediator = (AppMediator) context.get().getApplication();
        AdministratorSearchUsersState state = mediator.getadminSearchUsersState();

        AdministratorSearchUsersContract.Router router = new AdministratorSearchUsersRouter(mediator);
        AdministratorSearchUsersContract.Presenter presenter = new AdministratorSearchUsersPresenter(state);
        AdministratorSearchUsersContract.Model model = new AdministratorSearchUsersModel();
        presenter.injectModel(model);
        presenter.injectRouter(router);
        presenter.injectView(new WeakReference<>(view));

        view.injectPresenter(presenter);

    }
}
