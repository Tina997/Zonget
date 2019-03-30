package es.ulpgc.montesdeoca110.cristina.zonget.lostPets;

import java.lang.ref.WeakReference;

import android.support.v4.app.FragmentActivity;

import es.ulpgc.montesdeoca110.cristina.zonget.app.AppMediator;

public class LostPetsListScreen {

    public static void configure(LostPetsListContract.View view) {

        WeakReference<FragmentActivity> context =
                new WeakReference<>((FragmentActivity) view);

        AppMediator mediator = (AppMediator) context.get().getApplication();
        LostPetsListState state = mediator.getlostPetsListState();

        LostPetsListContract.Router router = new LostPetsListRouter(mediator);
        LostPetsListContract.Presenter presenter = new LostPetsListPresenter(state);
        LostPetsListContract.Model model = new LostPetsListModel();
        presenter.injectModel(model);
        presenter.injectRouter(router);
        presenter.injectView(new WeakReference<>(view));

        view.injectPresenter(presenter);

    }
}
