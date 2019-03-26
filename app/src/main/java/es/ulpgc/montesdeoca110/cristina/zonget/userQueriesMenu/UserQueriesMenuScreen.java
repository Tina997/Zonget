package es.ulpgc.montesdeoca110.cristina.zonget.userQueriesMenu;

import java.lang.ref.WeakReference;

import android.support.v4.app.FragmentActivity;

import es.ulpgc.montesdeoca110.cristina.zonget.app.AppMediator;

public class UserQueriesMenuScreen {

    public static void configure(UserQueriesMenuContract.View view) {

        WeakReference<FragmentActivity> context =
                new WeakReference<>((FragmentActivity) view);

        AppMediator mediator = (AppMediator) context.get().getApplication();
        UserQueriesMenuState state = mediator.getUserQueriesMenuState();

        UserQueriesMenuContract.Router router = new UserQueriesMenuRouter(mediator);
        UserQueriesMenuContract.Presenter presenter = new UserQueriesMenuPresenter(state);
        UserQueriesMenuContract.Model model = new UserQueriesMenuModel();
        presenter.injectModel(model);
        presenter.injectRouter(router);
        presenter.injectView(new WeakReference<>(view));

        view.injectPresenter(presenter);

    }
}
