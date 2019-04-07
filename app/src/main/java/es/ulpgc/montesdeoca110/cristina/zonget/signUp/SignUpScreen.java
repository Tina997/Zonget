package es.ulpgc.montesdeoca110.cristina.zonget.signUp;

import java.lang.ref.WeakReference;

import android.support.v4.app.FragmentActivity;

import es.ulpgc.montesdeoca110.cristina.zonget.app.AppMediator;

public class SignUpScreen {

    public static void configure(SignUpContract.View view) {

        WeakReference<FragmentActivity> context = new WeakReference<>((FragmentActivity) view);

        AppMediator mediator = (AppMediator) context.get().getApplication();
        SignUpState state = mediator.getSignUpState();

        SignUpContract.Router router = new SignUpRouter(mediator);
        SignUpContract.Presenter presenter = new SignUpPresenter(state);
        SignUpContract.Model model = new SignUpModel();
        presenter.injectModel(model);
        presenter.injectRouter(router);
        presenter.injectView(new WeakReference<>(view));

        view.injectPresenter(presenter);

    }
}
