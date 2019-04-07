package es.ulpgc.montesdeoca110.cristina.zonget.lostPetsDetail;

import java.lang.ref.WeakReference;

import android.support.v4.app.FragmentActivity;

import es.ulpgc.montesdeoca110.cristina.zonget.app.AppMediator;

public class LostPetsDetailScreen {

    public static void configure(LostPetsDetailContract.View view) {

        WeakReference<FragmentActivity> context =
                new WeakReference<>((FragmentActivity) view);

        AppMediator mediator = (AppMediator) context.get().getApplication();
        LostPetsDetailState state = mediator.getLostPetsDetailState();

        LostPetsDetailContract.Router router = new LostPetsDetailRouter(mediator);
        LostPetsDetailContract.Presenter presenter = new LostPetsDetailPresenter(state);
        LostPetsDetailContract.Model model = new LostPetsDetailModel();
        presenter.injectModel(model);
        presenter.injectRouter(router);
        presenter.injectView(new WeakReference<>(view));

        view.injectPresenter(presenter);

    }
}
