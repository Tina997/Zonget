package es.ulpgc.montesdeoca110.cristina.zonget.agregarCita;

import java.lang.ref.WeakReference;

import android.support.v4.app.FragmentActivity;

import es.ulpgc.montesdeoca110.cristina.zonget.app.AppMediator;

public class AgregarCitaScreen {

    public static void configure(AgregarCitaContract.View view) {

        WeakReference<FragmentActivity> context =
                new WeakReference<>((FragmentActivity) view);

        AppMediator mediator = (AppMediator) context.get().getApplication();
        AgregarCitaState state = mediator.getAgregarCitaState();

        AgregarCitaContract.Router router = new AgregarCitaRouter(mediator);
        AgregarCitaContract.Presenter presenter = new AgregarCitaPresenter(state);
        AgregarCitaContract.Model model = new AgregarCitaModel();
        presenter.injectModel(model);
        presenter.injectRouter(router);
        presenter.injectView(new WeakReference<>(view));

        view.injectPresenter(presenter);

    }
}
