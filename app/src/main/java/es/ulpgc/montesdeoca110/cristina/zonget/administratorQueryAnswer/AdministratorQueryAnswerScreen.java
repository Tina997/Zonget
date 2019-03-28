package es.ulpgc.montesdeoca110.cristina.zonget.administratorQueryAnswer;

import java.lang.ref.WeakReference;

import android.support.v4.app.FragmentActivity;

public class AdministratorQueryAnswerScreen {

    public static void configure(AdministratorQueryAnswerContract.View view) {

        WeakReference<FragmentActivity> context =
                new WeakReference<>((FragmentActivity) view);

        AppMediator mediator = (AppMediator) context.get().getApplication();
        AdministratorQueryAnswerState state = mediator.getAdministratorQueryAnswerState();

        AdministratorQueryAnswerContract.Router router = new AdministratorQueryAnswerRouter(mediator);
        AdministratorQueryAnswerContract.Presenter presenter = new AdministratorQueryAnswerPresenter(state);
        AdministratorQueryAnswerContract.Model model = new AdministratorQueryAnswerModel();
        presenter.injectModel(model);
        presenter.injectRouter(router);
        presenter.injectView(new WeakReference<>(view));

        view.injectPresenter(presenter);

    }
}
