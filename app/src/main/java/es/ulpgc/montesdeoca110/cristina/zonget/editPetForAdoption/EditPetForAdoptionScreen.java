package es.ulpgc.montesdeoca110.cristina.zonget.editPetForAdoption;

import java.lang.ref.WeakReference;

import android.support.v4.app.FragmentActivity;

import es.ulpgc.montesdeoca110.cristina.zonget.app.AppMediator;

public class EditPetForAdoptionScreen {

    public static void configure(EditPetForAdoptionContract.View view) {

        WeakReference<FragmentActivity> context =
                new WeakReference<>((FragmentActivity) view);

        AppMediator mediator = (AppMediator) context.get().getApplication();
        EditPetForAdoptionState state = mediator.getEditPetForAdoptionState();

        EditPetForAdoptionContract.Router router = new EditPetForAdoptionRouter(mediator);
        EditPetForAdoptionContract.Presenter presenter = new EditPetForAdoptionPresenter(state);
        EditPetForAdoptionContract.Model model = new EditPetForAdoptionModel();
        presenter.injectModel(model);
        presenter.injectRouter(router);
        presenter.injectView(new WeakReference<>(view));

        view.injectPresenter(presenter);

    }
}
