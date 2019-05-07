package es.ulpgc.montesdeoca110.cristina.zonget.userPets;

import java.lang.ref.WeakReference;

import android.support.v4.app.FragmentActivity;

import es.ulpgc.montesdeoca110.cristina.zonget.app.AppMediator;
import es.ulpgc.montesdeoca110.cristina.zonget.data.RepositoryContract;
import es.ulpgc.motesdeoca110.cristina.zonget.data.AccountsRepository;

public class UserPetsScreen {

    public static void configure(UserPetsContract.View view) {

        WeakReference<FragmentActivity> context =
                new WeakReference<>((FragmentActivity) view);

        AppMediator mediator = (AppMediator) context.get().getApplication();
        UserPetsState state = mediator.getUserPetsState();
        RepositoryContract.Accounts accountsRepository = AccountsRepository.getInstance(context.get());

        UserPetsContract.Router router = new UserPetsRouter(mediator);
        UserPetsContract.Presenter presenter = new UserPetsPresenter(state);
        UserPetsContract.Model model = new UserPetsModel(accountsRepository);
        presenter.injectModel(model);
        presenter.injectRouter(router);
        presenter.injectView(new WeakReference<>(view));

        view.injectPresenter(presenter);

    }
}
