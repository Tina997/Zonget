package es.ulpgc.montesdeoca110.cristina.zonget.AdministratorButtonsMenuList;

import java.lang.ref.WeakReference;

import android.support.v4.app.FragmentActivity;

import es.ulpgc.montesdeoca110.cristina.zonget.App.AppMediator;

public class AdministratorButtonsMenuListScreen {

    public static void configure(AdministratorMenuButtonsListContract.View view) {

        WeakReference<FragmentActivity> context =
                new WeakReference<>((FragmentActivity) view);

        AppMediator mediator = (AppMediator) context.get().getApplication();
        AdministratorButtonsMenuListState state = mediator.getAdministratorMenuListState();

        AdministratorMenuButtonsListContract.Router router = new AdministratorButtonsMenuListRouter(mediator);
        AdministratorMenuButtonsListContract.Presenter presenter = new AdministratorButtonsMenuListPresenter(state);
        AdministratorMenuButtonsListContract.Model model = new AdministratorButtonsMenuListModel();
        presenter.injectModel(model);
        presenter.injectRouter(router);
        presenter.injectView(new WeakReference<>(view));

        view.injectPresenter(presenter);

    }
}
