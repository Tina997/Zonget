package es.ulpgc.montesdeoca110.cristina.zonget.userPetsDetail;

import java.lang.ref.WeakReference;

import android.support.v4.app.FragmentActivity;

import es.ulpgc.montesdeoca110.cristina.zonget.app.AppMediator;

public class UserPetsDetailScreen {

    public static void configure(UserPetsDetailContract.View view) {

        WeakReference<FragmentActivity> context =
                new WeakReference<>((FragmentActivity) view);

        AppMediator mediator = (AppMediator) context.get().getApplication();
        UserPetsDetailState state = mediator.getUserPetsDetailState();

        UserPetsDetailContract.Router router = new UserPetsDetailRouter(mediator);
        UserPetsDetailContract.Presenter presenter = new UserPetsDetailPresenter(state);
        UserPetsDetailContract.Model model = new UserPetsDetailModel();
        presenter.injectModel(model);
        presenter.injectRouter(router);
        presenter.injectView(new WeakReference<>(view));

        view.injectPresenter(presenter);

    }
}
