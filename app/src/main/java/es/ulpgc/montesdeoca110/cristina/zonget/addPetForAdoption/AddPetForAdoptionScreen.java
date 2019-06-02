package es.ulpgc.montesdeoca110.cristina.zonget.addPetForAdoption;

import android.support.v4.app.FragmentActivity;

import es.ulpgc.montesdeoca110.cristina.zonget.app.AppMediator;

import java.lang.ref.WeakReference;

class AddPetForAdoptionScreen {

  public static void configure(AddPetForAdoptionContract.View view) {

    WeakReference<FragmentActivity> context =
            new WeakReference<>((FragmentActivity) view);

    AppMediator mediator = (AppMediator) context.get().getApplication();
    AddPetForAdoptionState state = mediator.getAddPetForAdoptionState();

    AddPetForAdoptionContract.Router router = new AddPetForAdoptionRouter(mediator);
    AddPetForAdoptionContract.Presenter presenter = new AddPetForAdoptionPresenter(state);
    AddPetForAdoptionContract.Model model = new AddPetForAdoptionModel();
    presenter.injectModel(model);
    presenter.injectRouter(router);
    presenter.injectView(new WeakReference<>(view));

    view.injectPresenter(presenter);

  }
}
