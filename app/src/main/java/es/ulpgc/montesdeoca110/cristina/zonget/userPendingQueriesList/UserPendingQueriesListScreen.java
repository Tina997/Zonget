package es.ulpgc.montesdeoca110.cristina.zonget.userPendingQueriesList;

import android.support.v4.app.FragmentActivity;

import es.ulpgc.montesdeoca110.cristina.zonget.app.AppMediator;

import java.lang.ref.WeakReference;

public class UserPendingQueriesListScreen {

  public static void configure(UserPendingQueriesListContract.View view) {

    WeakReference<FragmentActivity> context = new WeakReference<>((FragmentActivity) view);

    AppMediator mediator = (AppMediator) context.get().getApplication();
    UserPendingQueriesListState state = mediator.getUserPendingQueriesListState();

    UserPendingQueriesListContract.Router router = new UserPendingQueriesListRouter(mediator);
    UserPendingQueriesListContract.Presenter presenter = new UserPendingQueriesListPresenter(state);
    UserPendingQueriesListContract.Model model = new UserPendingQueriesListModel();
    presenter.injectModel(model);
    presenter.injectRouter(router);
    presenter.injectView(new WeakReference<>(view));

    view.injectPresenter(presenter);

  }
}
