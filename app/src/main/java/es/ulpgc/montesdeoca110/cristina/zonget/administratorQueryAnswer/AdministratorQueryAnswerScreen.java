package es.ulpgc.montesdeoca110.cristina.zonget.administratorQueryAnswer;

import android.support.v4.app.FragmentActivity;

import es.ulpgc.montesdeoca110.cristina.zonget.app.AppMediator;
import es.ulpgc.montesdeoca110.cristina.zonget.data.QueriesRepository;
import es.ulpgc.montesdeoca110.cristina.zonget.data.RepositoryContract;

import java.lang.ref.WeakReference;

public class AdministratorQueryAnswerScreen {

  public static void configure(AdministratorQueryAnswerContract.View view) {

    WeakReference<FragmentActivity> context =
            new WeakReference<>((FragmentActivity) view);

    AppMediator mediator = (AppMediator) context.get().getApplication();
    AdministratorQueryAnswerState state = mediator.getAdministratorQueryAnswerState();
    RepositoryContract.Queries queriesRepository = QueriesRepository.getInstance(context.get());

    AdministratorQueryAnswerContract.Router router =
            new AdministratorQueryAnswerRouter(mediator);
    AdministratorQueryAnswerContract.Presenter presenter =
            new AdministratorQueryAnswerPresenter(state);
    AdministratorQueryAnswerContract.Model model = new AdministratorQueryAnswerModel(queriesRepository);
    presenter.injectModel(model);
    presenter.injectRouter(router);
    presenter.injectView(new WeakReference<>(view));

    view.injectPresenter(presenter);

  }
}
