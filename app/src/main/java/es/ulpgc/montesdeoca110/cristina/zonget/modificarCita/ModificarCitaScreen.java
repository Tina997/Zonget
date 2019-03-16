package es.ulpgc.montesdeoca110.cristina.zonget.modificarCita;

import java.lang.ref.WeakReference;

import android.support.v4.app.FragmentActivity;

public class ModificarCitaScreen {

    public static void configure(ModificarCitaContract.View view) {

        WeakReference<FragmentActivity> context =
                new WeakReference<>((FragmentActivity) view);

        AppMediator mediator = (AppMediator) context.get().getApplication();
        ModificarCitaState state = mediator.getModificarCitaState();

        ModificarCitaContract.Router router = new ModificarCitaRouter(mediator);
        ModificarCitaContract.Presenter presenter = new ModificarCitaPresenter(state);
        ModificarCitaContract.Model model = new ModificarCitaModel();
        presenter.injectModel(model);
        presenter.injectRouter(router);
        presenter.injectView(new WeakReference<>(view));

        view.injectPresenter(presenter);

    }
}
