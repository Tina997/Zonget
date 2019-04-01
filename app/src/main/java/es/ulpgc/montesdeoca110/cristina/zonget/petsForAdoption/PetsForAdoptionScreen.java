package es.ulpgc.montesdeoca110.cristina.zonget.petsForAdoption;

import java.lang.ref.WeakReference;

import android.support.v4.app.FragmentActivity;

import es.ulpgc.montesdeoca110.cristina.zonget.app.AppMediator;

public class PetsForAdoptionScreen {

    public static void configure(PetsForAdoptionContract.View view) {

        WeakReference<FragmentActivity> context =
                new WeakReference<>((FragmentActivity) view);

        AppMediator mediator = (AppMediator) context.get().getApplication();
        PetsForAdoptionState state = mediator.getPetsForAdoptionState();

        PetsForAdoptionContract.Router router = new PetsForAdoptionRouter(mediator);
        PetsForAdoptionContract.Presenter presenter = new PetsForAdoptionPresenter(state);
        PetsForAdoptionContract.Model model = new PetsForAdoptionModel();
        presenter.injectModel(model);
        presenter.injectRouter(router);
        presenter.injectView(new WeakReference<>(view));

        view.injectPresenter(presenter);

    }
}
