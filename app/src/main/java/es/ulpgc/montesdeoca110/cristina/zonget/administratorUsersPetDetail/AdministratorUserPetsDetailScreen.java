package es.ulpgc.montesdeoca110.cristina.zonget.administratorUsersPetDetail;

import android.support.v4.app.FragmentActivity;

import es.ulpgc.montesdeoca110.cristina.zonget.app.AppMediator;
import es.ulpgc.montesdeoca110.cristina.zonget.data.RepositoryContract;
import es.ulpgc.montesdeoca110.cristina.zonget.data.AccountsRepository;

import java.lang.ref.WeakReference;

class AdministratorUserPetsDetailScreen {

  public static void configure(AdministratorUserPetsDetailContract.View view) {

    WeakReference<FragmentActivity> context =
            new WeakReference<>((FragmentActivity) view);

    AppMediator mediator = (AppMediator) context.get().getApplication();
    AdministratorUserPetsDetailState state = mediator.getAdministratorUserPetsDetailState();
    RepositoryContract.Accounts repository = AccountsRepository.getInstance(context.get());

    AdministratorUserPetsDetailContract.Router router =
            new AdministratorUserPetsDetailRouter(mediator);
    AdministratorUserPetsDetailContract.Presenter presenter =
            new AdministratorUserPetsDetailPresenter(state);
    AdministratorUserPetsDetailContract.Model model = new AdministratorUserPetsDetailModel(repository);
    presenter.injectModel(model);
    presenter.injectRouter(router);
    presenter.injectView(new WeakReference<>(view));

    view.injectPresenter(presenter);

  }
}
