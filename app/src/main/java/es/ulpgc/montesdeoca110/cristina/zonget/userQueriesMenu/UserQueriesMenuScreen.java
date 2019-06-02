package es.ulpgc.montesdeoca110.cristina.zonget.userQueriesMenu;

import android.support.v4.app.FragmentActivity;

import es.ulpgc.montesdeoca110.cristina.zonget.app.AppMediator;
import es.ulpgc.montesdeoca110.cristina.zonget.data.QueriesRepository;
import es.ulpgc.montesdeoca110.cristina.zonget.data.RepositoryContract;

import java.lang.ref.WeakReference;

class UserQueriesMenuScreen {

  public static void configure(UserQueriesMenuContract.View view) {

    WeakReference<FragmentActivity> context = new WeakReference<>((FragmentActivity) view);

    AppMediator mediator = (AppMediator) context.get().getApplication();
    UserQueriesMenuState state = mediator.getUserQueriesMenuState();
    RepositoryContract.Queries repository = QueriesRepository.getInstance(context.get());

    UserQueriesMenuContract.Router router = new UserQueriesMenuRouter(mediator);
    UserQueriesMenuContract.Presenter presenter = new UserQueriesMenuPresenter(state);
    UserQueriesMenuContract.Model model = new UserQueriesMenuModel(repository);
    presenter.injectModel(model);
    presenter.injectRouter(router);
    presenter.injectView(new WeakReference<>(view));

    view.injectPresenter(presenter);

  }
}
