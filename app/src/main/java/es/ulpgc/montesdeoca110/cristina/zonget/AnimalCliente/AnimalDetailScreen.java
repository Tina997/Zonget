package es.ulpgc.montesdeoca110.cristina.zonget.AnimalCliente;

import java.lang.ref.WeakReference;

import android.support.v4.app.FragmentActivity;

import es.ulpgc.montesdeoca110.cristina.zonget.AnimalesCliente.AnimalesClienteListModel;
import es.ulpgc.montesdeoca110.cristina.zonget.App.AppMediator;

public class AnimalDetailScreen {

    public static void configure(AnimalDetailContract.View view) {

        WeakReference<FragmentActivity> context =
                new WeakReference<>((FragmentActivity) view);

        AppMediator mediator = (AppMediator) context.get().getApplication();
        AnimalDetailState state = mediator.getAnimalDetailState();

        AnimalDetailContract.Router router = new AnimalDetailRouter(mediator);
        AnimalDetailContract.Presenter presenter = new AnimalDetailPresenter(state);
        AnimalDetailModel model = new AnimalDetailModel();
        presenter.injectView(new WeakReference<>(view));
        presenter.injectModel(model);
        presenter.injectRouter(router);


        view.injectPresenter(presenter);


    }
}
