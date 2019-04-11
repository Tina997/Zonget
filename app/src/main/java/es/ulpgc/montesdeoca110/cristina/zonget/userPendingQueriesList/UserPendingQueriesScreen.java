package es.ulpgc.montesdeoca110.cristina.zonget.userPendingQueriesList;

import java.lang.ref.WeakReference;

import android.support.v4.app.FragmentActivity;

public class UserPendingQueriesScreen {

    public static void configure(UserPendingQueriesContract.View view) {

        WeakReference<FragmentActivity> context =
                new WeakReference<>((FragmentActivity) view);

        AppMediator mediator = (AppMediator) context.get().getApplication();
        UserPendingQueriesState state = mediator.getUserPendingQueriesState();

        UserPendingQueriesContract.Router router = new UserPendingQueriesRouter(mediator);
        UserPendingQueriesContract.Presenter presenter = new UserPendingQueriesPresenter(state);
        UserPendingQueriesContract.Model model = new UserPendingQueriesModel();
        presenter.injectModel(model);
        presenter.injectRouter(router);
        presenter.injectView(new WeakReference<>(view));

        view.injectPresenter(presenter);

    }
}
