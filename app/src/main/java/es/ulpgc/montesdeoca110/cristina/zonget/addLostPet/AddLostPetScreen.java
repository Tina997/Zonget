package es.ulpgc.montesdeoca110.cristina.zonget.addLostPet;

import java.lang.ref.WeakReference;

import android.support.v4.app.FragmentActivity;

import es.ulpgc.montesdeoca110.cristina.zonget.app.AppMediator;

public class AddLostPetScreen {

    public static void configure(AddLostPetContract.View view) {

        WeakReference<FragmentActivity> context =
                new WeakReference<>((FragmentActivity) view);

        AppMediator mediator = (AppMediator) context.get().getApplication();
        AddLostPetState state = mediator.getAddLostPetState();

        AddLostPetContract.Router router = new AddLostPetRouter(mediator);
        AddLostPetContract.Presenter presenter = new AddLostPetPresenter(state);
        AddLostPetContract.Model model = new AddLostPetModel();
        presenter.injectModel(model);
        presenter.injectRouter(router);
        presenter.injectView(new WeakReference<>(view));

        view.injectPresenter(presenter);

    }
}
