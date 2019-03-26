package es.ulpgc.montesdeoca110.cristina.zonget.administratorUsersPets;

import java.lang.ref.WeakReference;

import android.support.v4.app.FragmentActivity;

import es.ulpgc.montesdeoca110.cristina.zonget.app.AppMediator;

public class AdministratorUsersPetsListScreen {

    public static void configure(AdministratorUsersPetsListContract.View view) {

        WeakReference<FragmentActivity> context =
                new WeakReference<>((FragmentActivity) view);

        AppMediator mediator = (AppMediator) context.get().getApplication();
        AdministratorUsersPetsListState state = mediator.getAdministratorUsersPetsListState();

        AdministratorUsersPetsListContract.Router router = new AdministratorUsersPetsListRouter(mediator);
        AdministratorUsersPetsListContract.Presenter presenter = new AdministratorUsersPetsListPresenter(state);
        AdministratorUsersPetsListContract.Model model = new AdministratorUsersPetsListModel();
        presenter.injectModel(model);
        presenter.injectRouter(router);
        presenter.injectView(new WeakReference<>(view));

        view.injectPresenter(presenter);

    }
}
