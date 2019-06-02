package es.ulpgc.montesdeoca110.cristina.zonget.userButtonsMenuList;

import android.support.v4.app.FragmentActivity;

import es.ulpgc.montesdeoca110.cristina.zonget.app.AppMediator;
import es.ulpgc.montesdeoca110.cristina.zonget.data.RepositoryContract;
import es.ulpgc.montesdeoca110.cristina.zonget.data.SettingsRepository;
import java.lang.ref.WeakReference;

class UserButtonsMenuListScreen {

  public static void configure(UserButtonsMenuListContract.View view) {

    WeakReference<FragmentActivity> context = new WeakReference<>((FragmentActivity) view);

    AppMediator mediator = (AppMediator) context.get().getApplication();
    UserButtonsMenuListState state = mediator.getUserButtonsMenuListState();
    RepositoryContract.Settings repository = SettingsRepository.getInstance(context.get());

    UserButtonsMenuListContract.Router router = new UserButtonsMenuListRouter(mediator);
    UserButtonsMenuListContract.Presenter presenter = new UserButtonsMenuListPresenter(state);
    UserButtonsMenuListContract.Model model = new UserButtonsMenuListModel(repository);
    presenter.injectModel(model);
    presenter.injectRouter(router);
    presenter.injectView(new WeakReference<>(view));

    view.injectPresenter(presenter);

  }
}
