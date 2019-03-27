package es.ulpgc.montesdeoca110.cristina.zonget.administratorUsersPetDetail;

import java.lang.ref.WeakReference;

import android.support.v4.app.FragmentActivity;

import es.ulpgc.montesdeoca110.cristina.zonget.app.AppMediator;

public class AdministratorUserPetsDetailScreen {

    public static void configure(AdministratorUserPetsDetailContract.View view) {

        WeakReference<FragmentActivity> context =
                new WeakReference<>((FragmentActivity) view);

        AppMediator mediator = (AppMediator) context.get().getApplication();
        AdministratorUserPetsDetailState state = mediator.getAdministratorUserPetsDetailState();

        AdministratorUserPetsDetailContract.Router router = new AdministratorUserPetsDetailRouter(mediator);
        AdministratorUserPetsDetailContract.Presenter presenter = new AdministratorUserPetsDetailPresenter(state);
        AdministratorUserPetsDetailContract.Model model = new AdministratorUserPetsDetailModel();
        presenter.injectModel(model);
        presenter.injectRouter(router);
        presenter.injectView(new WeakReference<>(view));

        view.injectPresenter(presenter);

    }
}
