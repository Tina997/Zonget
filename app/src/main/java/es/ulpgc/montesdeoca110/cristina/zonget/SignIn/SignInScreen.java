package es.ulpgc.montesdeoca110.cristina.zonget.SignIn;

import java.lang.ref.WeakReference;

import android.support.v4.app.FragmentActivity;
import es.ulpgc.montesdeoca110.cristina.zonget.App.AppMediator;

public class SignInScreen {

    public static void configure(SignInContract.View view) {

        WeakReference<FragmentActivity> context =
                new WeakReference<>((FragmentActivity) view);

        AppMediator mediator = (AppMediator) context.get().getApplication();
        SignInState state = mediator.getSignInState();

        SignInContract.Router router = new SignInRouter(mediator);
        SignInContract.Presenter presenter = new SignInPresenter(state);
        SignInContract.Model model = new SignInModel();
        presenter.injectModel(model);
        presenter.injectRouter(router);
        presenter.injectView(new WeakReference<>(view));

        view.injectPresenter(presenter);

    }
}
