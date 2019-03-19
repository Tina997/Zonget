package es.ulpgc.montesdeoca110.cristina.zonget.AdministratorMenu;

import java.lang.ref.WeakReference;

import android.support.v4.app.FragmentActivity;

import es.ulpgc.montesdeoca110.cristina.zonget.App.AppMediator;

public class AdministratorMenuScreen {

    public static void configure(AdministratorMenuContract.View view) {

        WeakReference<FragmentActivity> context =
                new WeakReference<>((FragmentActivity) view);

        AppMediator mediator = (AppMediator) context.get().getApplication();
        AdministratorMenuState state = mediator.getAdministratorMenuState();

        AdministratorMenuContract.Router router = new AdministratorMenuRouter(mediator);
        AdministratorMenuContract.Presenter presenter = new AdministratorMenuPresenter(state);
        AdministratorMenuContract.Model model = new AdministratorMenuModel();
        presenter.injectModel(model);
        presenter.injectRouter(router);
        presenter.injectView(new WeakReference<>(view));

        view.injectPresenter(presenter);

    }
}
