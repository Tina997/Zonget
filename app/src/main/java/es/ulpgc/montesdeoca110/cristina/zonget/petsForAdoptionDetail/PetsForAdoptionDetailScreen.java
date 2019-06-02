package es.ulpgc.montesdeoca110.cristina.zonget.petsForAdoptionDetail;

import android.support.v4.app.FragmentActivity;

import es.ulpgc.montesdeoca110.cristina.zonget.app.AppMediator;
import java.lang.ref.WeakReference;

class PetsForAdoptionDetailScreen {

  public static void configure(PetsForAdoptionDetailContract.View view) {

    WeakReference<FragmentActivity> context =
            new WeakReference<>((FragmentActivity) view);

    AppMediator mediator = (AppMediator) context.get().getApplication();
    PetsForAdoptionDetailState state = mediator.getPetsForAdoptionDetailState();

    PetsForAdoptionDetailContract.Router router = new PetsForAdoptionDetailRouter(mediator);
    PetsForAdoptionDetailContract.Presenter presenter = new PetsForAdoptionDetailPresenter(state);
    PetsForAdoptionDetailContract.Model model = new PetsForAdoptionDetailModel();
    presenter.injectModel(model);
    presenter.injectRouter(router);
    presenter.injectView(new WeakReference<>(view));

    view.injectPresenter(presenter);

  }
}
