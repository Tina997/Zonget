package es.ulpgc.montesdeoca110.cristina.zonget.userPickDate;

import android.support.v4.app.FragmentActivity;

import es.ulpgc.montesdeoca110.cristina.zonget.app.AppMediator;
import java.lang.ref.WeakReference;

class UserPickDateScreen {

  public static void configure(UserPickDateContract.View view) {

    WeakReference<FragmentActivity> context =
            new WeakReference<>((FragmentActivity) view);

    AppMediator mediator = (AppMediator) context.get().getApplication();
    UserPickDateState state = mediator.getUserPickDateState();

    UserPickDateContract.Router router = new UserPickDateRouter(mediator);
    UserPickDateContract.Presenter presenter = new UserPickDatePresenter(state);
    UserPickDateContract.Model model = new UserPickDateModel();
    presenter.injectModel(model);
    presenter.injectRouter(router);
    presenter.injectView(new WeakReference<>(view));

    view.injectPresenter(presenter);

  }
}
