package es.ulpgc.montesdeoca110.cristina.zonget.administratorButtonsMenuList;

import java.lang.ref.WeakReference;

import android.support.v4.app.FragmentActivity;

import es.ulpgc.montesdeoca110.cristina.zonget.app.AppMediator;
import es.ulpgc.montesdeoca110.cristina.zonget.data.RepositoryContract;
import es.ulpgc.motesdeoca110.cristina.zonget.data.SettingsRepository;

public class AdministratorButtonsMenuListScreen {

    public static void configure(AdministratorButtonsMenuListContract.View view) {

        WeakReference<FragmentActivity> context = new WeakReference<>((FragmentActivity) view);

        AppMediator mediator = (AppMediator) context.get().getApplication();
        AdministratorButtonsMenuListState state = mediator.getAdministratorMenuListState();
        RepositoryContract.Settings repository = SettingsRepository.getInstance(context.get());

        AdministratorButtonsMenuListContract.Router router = new AdministratorButtonsMenuListRouter(mediator);
        AdministratorButtonsMenuListContract.Presenter presenter = new AdministratorButtonsMenuListPresenter(state);
        AdministratorButtonsMenuListContract.Model model = new AdministratorButtonsMenuListModel(repository);
        presenter.injectModel(model);
        presenter.injectRouter(router);
        presenter.injectView(new WeakReference<>(view));

        view.injectPresenter(presenter);

    }
}
