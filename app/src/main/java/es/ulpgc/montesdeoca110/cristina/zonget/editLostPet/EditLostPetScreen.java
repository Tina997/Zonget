package es.ulpgc.montesdeoca110.cristina.zonget.editLostPet;

import android.support.v4.app.FragmentActivity;

import es.ulpgc.montesdeoca110.cristina.zonget.app.AppMediator;
import java.lang.ref.WeakReference;

class EditLostPetScreen {

  public static void configure(EditLostPetContract.View view) {

    WeakReference<FragmentActivity> context =
            new WeakReference<>((FragmentActivity) view);

    AppMediator mediator = (AppMediator) context.get().getApplication();
    EditLostPetState state = mediator.getEditLostPetState();

    EditLostPetContract.Router router = new EditLostPetRouter(mediator);
    EditLostPetContract.Presenter presenter = new EditLostPetPresenter(state);
    EditLostPetContract.Model model = new EditLostPetModel();
    presenter.injectModel(model);
    presenter.injectRouter(router);
    presenter.injectView(new WeakReference<>(view));

    view.injectPresenter(presenter);

  }
}
