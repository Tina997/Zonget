package es.ulpgc.montesdeoca110.cristina.zonget.Animal;

import java.lang.ref.WeakReference;

import android.support.v4.app.FragmentActivity;

import es.ulpgc.montesdeoca110.cristina.zonget.AppMediator;

public class AnimalDetailScreen {

    public static void configure(AnimalDetailContract.View view) {

        WeakReference<FragmentActivity> context =
                new WeakReference<>((FragmentActivity) view);

        AppMediator mediator = (AppMediator) context.get().getApplication();
        //AnimalDetailState state = mediator.getAnimalDetailState();

        AnimalDetailContract.Router router = new AnimalDetailRouter(mediator);
        //AnimalDetailContract.Presenter presenter = new AnimalDetailPresenter(state);
        AnimalDetailContract.Model model = new AnimalDetailModel();
        /*presenter.injectModel(model);
        presenter.injectRouter(router);
        presenter.injectView(new WeakReference<>(view));

        view.injectPresenter(presenter);
        */

    }
}
