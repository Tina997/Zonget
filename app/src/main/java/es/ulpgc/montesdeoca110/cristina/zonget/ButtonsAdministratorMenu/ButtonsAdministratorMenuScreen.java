package es.ulpgc.montesdeoca110.cristina.zonget.ButtonsAdministratorMenu;

import java.lang.ref.WeakReference;

import android.support.v4.app.FragmentActivity;

import es.ulpgc.montesdeoca110.cristina.zonget.App.AppMediator;

public class ButtonsAdministratorMenuScreen {

    public static void configure(ButtonsAdministratorMenuContract.View view) {

        WeakReference<FragmentActivity> context =
                new WeakReference<>((FragmentActivity) view);

        AppMediator mediator = (AppMediator) context.get().getApplication();
        ButtonsAdministratorMenuState state = mediator.getAdministratorMenuState();

        ButtonsAdministratorMenuContract.Router router = new ButtonsAdministratorMenuRouter(mediator);
        ButtonsAdministratorMenuContract.Presenter presenter = new ButtonsAdministratorMenuPresenter(state);
        ButtonsAdministratorMenuContract.Model model = new ButtonsAdministratorMenuModel();
        presenter.injectModel(model);
        presenter.injectRouter(router);
        presenter.injectView(new WeakReference<>(view));

        view.injectPresenter(presenter);

    }
}
