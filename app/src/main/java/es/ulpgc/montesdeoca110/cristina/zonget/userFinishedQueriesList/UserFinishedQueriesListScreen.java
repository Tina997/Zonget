package es.ulpgc.montesdeoca110.cristina.zonget.userFinishedQueriesList;

import android.support.v4.app.FragmentActivity;

import es.ulpgc.montesdeoca110.cristina.zonget.app.AppMediator;
import es.ulpgc.montesdeoca110.cristina.zonget.data.QueriesRepository;
import es.ulpgc.montesdeoca110.cristina.zonget.data.RepositoryContract;

import java.lang.ref.WeakReference;

public class UserFinishedQueriesListScreen {

  public static void configure(UserFinishedQueriesListContract.View view) {

    WeakReference<FragmentActivity> context = new WeakReference<>((FragmentActivity) view);

    AppMediator mediator = (AppMediator) context.get().getApplication();
    UserFinishedQueriesListState state = mediator.getUserFinishedQueriesListState();
    RepositoryContract.Queries repository = QueriesRepository.getInstance(context.get());

    UserFinishedQueriesListContract.Router router = new UserFinishedQueriesListRouter(mediator);
    UserFinishedQueriesListContract.Presenter presenter = new UserFinishedQueriesListPresenter(state);
    UserFinishedQueriesListContract.Model model = new UserFinishedQueriesListModel(repository);
    presenter.injectModel(model);
    presenter.injectRouter(router);
    presenter.injectView(new WeakReference<>(view));

    view.injectPresenter(presenter);

  }
}
