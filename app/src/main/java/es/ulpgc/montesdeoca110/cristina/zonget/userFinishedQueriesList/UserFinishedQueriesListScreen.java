package es.ulpgc.montesdeoca110.cristina.zonget.userFinishedQueriesList;

import java.lang.ref.WeakReference;

import android.support.v4.app.FragmentActivity;

import es.ulpgc.montesdeoca110.cristina.zonget.app.AppMediator;

public class UserFinishedQueriesListScreen {

    public static void configure(UserFinishedQueriesListContract.View view) {

        WeakReference<FragmentActivity> context = new WeakReference<>((FragmentActivity) view);

        AppMediator mediator = (AppMediator) context.get().getApplication();
        UserFinishedQueriesListState state = mediator.getUserFinishedQueriesListState();

        UserFinishedQueriesListContract.Router router = new UserFinishedQueriesListRouter(mediator);
        UserFinishedQueriesListContract.Presenter presenter = new UserFinishedQueriesListPresenter(state);
        UserFinishedQueriesListContract.Model model = new UserFinishedQueriesListModel();
        presenter.injectModel(model);
        presenter.injectRouter(router);
        presenter.injectView(new WeakReference<>(view));

        view.injectPresenter(presenter);

    }
}
