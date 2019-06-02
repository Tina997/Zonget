package es.ulpgc.montesdeoca110.cristina.zonget.userPendingQueriesList;

import android.support.v4.app.FragmentActivity;

import es.ulpgc.montesdeoca110.cristina.zonget.app.AppMediator;
import es.ulpgc.montesdeoca110.cristina.zonget.data.QueriesRepository;
import es.ulpgc.montesdeoca110.cristina.zonget.data.RepositoryContract;

import java.lang.ref.WeakReference;

class UserPendingQueriesListScreen {

  public static void configure(UserPendingQueriesListContract.View view) {

    WeakReference<FragmentActivity> context = new WeakReference<>((FragmentActivity) view);

    AppMediator mediator = (AppMediator) context.get().getApplication();
    UserPendingQueriesListState state = mediator.getUserPendingQueriesListState();
    RepositoryContract.Queries repository = QueriesRepository.getInstance(context.get());

    UserPendingQueriesListContract.Router router = new UserPendingQueriesListRouter(mediator);
    UserPendingQueriesListContract.Presenter presenter = new UserPendingQueriesListPresenter(state);
    UserPendingQueriesListContract.Model model = new UserPendingQueriesListModel(repository);
    presenter.injectModel(model);
    presenter.injectRouter(router);
    presenter.injectView(new WeakReference<>(view));

    view.injectPresenter(presenter);

  }
}
