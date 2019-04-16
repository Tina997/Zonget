package es.ulpgc.montesdeoca110.cristina.zonget.changeTheme;

import java.lang.ref.WeakReference;

import android.support.v4.app.FragmentActivity;

public class ChangeThemeScreen {

    public static void configure(ChangeThemeContract.View view) {

        WeakReference<FragmentActivity> context =
                new WeakReference<>((FragmentActivity) view);

        AppMediator mediator = (AppMediator) context.get().getApplication();
        ChangeThemeState state = mediator.getChangeThemeState();

        ChangeThemeContract.Router router = new ChangeThemeRouter(mediator);
        ChangeThemeContract.Presenter presenter = new ChangeThemePresenter(state);
        ChangeThemeContract.Model model = new ChangeThemeModel();
        presenter.injectModel(model);
        presenter.injectRouter(router);
        presenter.injectView(new WeakReference<>(view));

        view.injectPresenter(presenter);

    }
}
