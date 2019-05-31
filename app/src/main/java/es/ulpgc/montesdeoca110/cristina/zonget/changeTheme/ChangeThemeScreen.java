package es.ulpgc.montesdeoca110.cristina.zonget.changeTheme;

import android.support.v4.app.FragmentActivity;
import es.ulpgc.montesdeoca110.cristina.zonget.app.AppMediator;
import es.ulpgc.montesdeoca110.cristina.zonget.data.RepositoryContract;
import es.ulpgc.montesdeoca110.cristina.zonget.data.SettingsRepository;

import java.lang.ref.WeakReference;

public class ChangeThemeScreen {

  public static void configure(ChangeThemeContract.View view) {

    WeakReference<FragmentActivity> context = new WeakReference<>((FragmentActivity) view);

    AppMediator mediator = (AppMediator) context.get().getApplication();
    ChangeThemeState state = mediator.getChangeThemeState();
    RepositoryContract.Settings repository = SettingsRepository.getInstance(context.get());

    ChangeThemeContract.Router router = new ChangeThemeRouter(mediator);
    ChangeThemeContract.Presenter presenter = new ChangeThemePresenter(state);
    ChangeThemeContract.Model model = new ChangeThemeModel(repository);
    presenter.injectModel(model);
    presenter.injectRouter(router);
    presenter.injectView(new WeakReference<>(view));

    view.injectPresenter(presenter);

  }
}
