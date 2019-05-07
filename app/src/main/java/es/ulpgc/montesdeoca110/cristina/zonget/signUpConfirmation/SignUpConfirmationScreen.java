package es.ulpgc.montesdeoca110.cristina.zonget.signUpConfirmation;

import android.support.v4.app.FragmentActivity;

import es.ulpgc.montesdeoca110.cristina.zonget.app.AppMediator;
import java.lang.ref.WeakReference;

public class SignUpConfirmationScreen {

  public static void configure(SignUpConfirmationContract.View view) {

    WeakReference<FragmentActivity> context =
            new WeakReference<>((FragmentActivity) view);

    AppMediator mediator = (AppMediator) context.get().getApplication();
    SignUpConfirmationState state = mediator.getSignUpConfirmationState();

    SignUpConfirmationContract.Router router = new SignUpConfirmationRouter(mediator);
    SignUpConfirmationContract.Presenter presenter = new SignUpConfirmationPresenter(state);
    SignUpConfirmationContract.Model model = new SignUpConfirmationModel();
    presenter.injectModel(model);
    presenter.injectRouter(router);
    presenter.injectView(new WeakReference<>(view));

    view.injectPresenter(presenter);
  }
}
