package es.ulpgc.montesdeoca110.cristina.zonget.addEvent;

import android.support.v4.app.FragmentActivity;
import es.ulpgc.montesdeoca110.cristina.zonget.app.AppMediator;
import java.lang.ref.WeakReference;

class AddEventScreen {

  public static void configure(AddEventContract.View view) {

    WeakReference<FragmentActivity> context =
            new WeakReference<>((FragmentActivity) view);

    AppMediator mediator = (AppMediator) context.get().getApplication();
    AddEventState state = mediator.getAddEventState();

    AddEventContract.Router router = new AddEventRouter(mediator);
    AddEventContract.Presenter presenter = new AddEventPresenter(state);
    AddEventContract.Model model = new AddEventModel();
    presenter.injectModel(model);
    presenter.injectRouter(router);
    presenter.injectView(new WeakReference<>(view));

    view.injectPresenter(presenter);

  }
}
