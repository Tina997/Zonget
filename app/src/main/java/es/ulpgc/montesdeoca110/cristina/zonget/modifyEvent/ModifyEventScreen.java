package es.ulpgc.montesdeoca110.cristina.zonget.modifyEvent;

import android.support.v4.app.FragmentActivity;

import es.ulpgc.montesdeoca110.cristina.zonget.app.AppMediator;
import java.lang.ref.WeakReference;

public class ModifyEventScreen {

  public static void configure(ModifyEventContract.View view) {

    WeakReference<FragmentActivity> context =
            new WeakReference<>((FragmentActivity) view);

    AppMediator mediator = (AppMediator) context.get().getApplication();
    ModifyEventState state = mediator.getModifyEventState();

    ModifyEventContract.Router router = new ModifyEventRouter(mediator);
    ModifyEventContract.Presenter presenter = new ModifyEventPresenter(state);
    ModifyEventContract.Model model = new ModifyEventModel();
    presenter.injectModel(model);
    presenter.injectRouter(router);
    presenter.injectView(new WeakReference<>(view));

    view.injectPresenter(presenter);

  }
}
