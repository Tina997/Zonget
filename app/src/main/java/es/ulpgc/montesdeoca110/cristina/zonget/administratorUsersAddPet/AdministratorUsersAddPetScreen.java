package es.ulpgc.montesdeoca110.cristina.zonget.administratorUsersAddPet;

import android.support.v4.app.FragmentActivity;

import es.ulpgc.montesdeoca110.cristina.zonget.app.AppMediator;
import es.ulpgc.montesdeoca110.cristina.zonget.data.RepositoryContract;
import es.ulpgc.montesdeoca110.cristina.zonget.data.AccountsRepository;

import java.lang.ref.WeakReference;

class AdministratorUsersAddPetScreen {

  public static void configure(AdministratorUsersAddPetContract.View view) {

    WeakReference<FragmentActivity> context =
            new WeakReference<>((FragmentActivity) view);

    AppMediator mediator = (AppMediator) context.get().getApplication();
    AdministratorUsersAddPetState state = mediator.getAdministratorUsersAddPetState();
    RepositoryContract.Accounts repository = AccountsRepository.getInstance(context.get());

    AdministratorUsersAddPetContract.Router router = new AdministratorUsersAddPetRouter(mediator);
    AdministratorUsersAddPetContract.Presenter presenter =
            new AdministratorUsersAddPetPresenter(state);
    AdministratorUsersAddPetContract.Model model = new AdministratorUsersAddPetModel(repository);
    presenter.injectModel(model);
    presenter.injectRouter(router);
    presenter.injectView(new WeakReference<>(view));

    view.injectPresenter(presenter);

  }
}
