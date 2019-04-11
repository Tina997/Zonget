package es.ulpgc.montesdeoca110.cristina.zonget.userNewQuery;

import java.lang.ref.WeakReference;

import android.support.v4.app.FragmentActivity;

import es.ulpgc.montesdeoca110.cristina.zonget.app.AppMediator;

public class UserNewQueryScreen {

    public static void configure(UserNewQueryContract.View view) {

        WeakReference<FragmentActivity> context = new WeakReference<>((FragmentActivity) view);

        AppMediator mediator = (AppMediator) context.get().getApplication();
        UserNewQueryState state = mediator.getUserNewQueryState();

        UserNewQueryContract.Router router = new UserNewQueryRouter(mediator);
        UserNewQueryContract.Presenter presenter = new UserNewQueryPresenter(state);
        UserNewQueryContract.Model model = new UserNewQueryModel();
        presenter.injectModel(model);
        presenter.injectRouter(router);
        presenter.injectView(new WeakReference<>(view));

        view.injectPresenter(presenter);

    }
}
