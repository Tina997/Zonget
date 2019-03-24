package es.ulpgc.montesdeoca110.cristina.zonget.userButtonsMenuList;

import java.lang.ref.WeakReference;

import android.support.v4.app.FragmentActivity;

public class UserButtonsMenuListScreen {

    public static void configure(UserButtonsMenuListContract.View view) {

        WeakReference<FragmentActivity> context =
                new WeakReference<>((FragmentActivity) view);

        AppMediator mediator = (AppMediator) context.get().getApplication();
        UserButtonsMenuListState state = mediator.getUserButtonsMenuListState();

        UserButtonsMenuListContract.Router router = new UserButtonsMenuListRouter(mediator);
        UserButtonsMenuListContract.Presenter presenter = new UserButtonsMenuListPresenter(state);
        UserButtonsMenuListContract.Model model = new UserButtonsMenuListModel();
        presenter.injectModel(model);
        presenter.injectRouter(router);
        presenter.injectView(new WeakReference<>(view));

        view.injectPresenter(presenter);

    }
}
