package es.ulpgc.montesdeoca110.cristina.zonget.userPets;

import java.lang.ref.WeakReference;

import android.support.v4.app.FragmentActivity;

import es.ulpgc.montesdeoca110.cristina.zonget.app.AppMediator;

public class UserPetsScreen {

    public static void configure(UserPetsContract.View view) {

        WeakReference<FragmentActivity> context =
                new WeakReference<>((FragmentActivity) view);

        AppMediator mediator = (AppMediator) context.get().getApplication();
        UserPetsState state = mediator.getUserPetsState();

        UserPetsContract.Router router = new UserPetsRouter(mediator);
        UserPetsContract.Presenter presenter = new UserPetsPresenter(state);
        UserPetsContract.Model model = new UserPetsModel();
        presenter.injectModel(model);
        presenter.injectRouter(router);
        presenter.injectView(new WeakReference<>(view));

        view.injectPresenter(presenter);

    }
}
