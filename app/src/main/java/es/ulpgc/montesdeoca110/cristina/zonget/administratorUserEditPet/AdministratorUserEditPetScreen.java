package es.ulpgc.montesdeoca110.cristina.zonget.administratorUserEditPet;

import android.support.v4.app.FragmentActivity;

import es.ulpgc.montesdeoca110.cristina.zonget.app.AppMediator;
import java.lang.ref.WeakReference;

public class AdministratorUserEditPetScreen {

  public static void configure(AdministratorUserEditPetContract.View view) {

    WeakReference<FragmentActivity> context =
            new WeakReference<>((FragmentActivity) view);

    AppMediator mediator = (AppMediator) context.get().getApplication();
    AdministratorUserEditPetState state = mediator.getAdministratorUserEditPetState();

    AdministratorUserEditPetContract.Router router = new AdministratorUserEditPetRouter(mediator);
    AdministratorUserEditPetContract.Presenter presenter =
            new AdministratorUserEditPetPresenter(state);
    AdministratorUserEditPetContract.Model model = new AdministratorUserEditPetModel();
    presenter.injectModel(model);
    presenter.injectRouter(router);
    presenter.injectView(new WeakReference<>(view));

    view.injectPresenter(presenter);

  }
}
