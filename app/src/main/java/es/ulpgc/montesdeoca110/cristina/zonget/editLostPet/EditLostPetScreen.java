package es.ulpgc.montesdeoca110.cristina.zonget.editLostPet;

import java.lang.ref.WeakReference;

import android.support.v4.app.FragmentActivity;

import es.ulpgc.montesdeoca110.cristina.zonget.app.AppMediator;

public class EditLostPetScreen {

    public static void configure(EditLostPetContract.View view) {

        WeakReference<FragmentActivity> context =
                new WeakReference<>((FragmentActivity) view);

        AppMediator mediator = (AppMediator) context.get().getApplication();
        //EditLostPetState state = mediator.getEditLostPetState();

        /*EditLostPetContract.Router router = new EditLostPetRouter(mediator);
        EditLostPetContract.Presenter presenter = new EditLostPetPresenter(state);
        EditLostPetContract.Model model = new EditLostPetModel();
        presenter.injectModel(model);
        presenter.injectRouter(router);
        presenter.injectView(new WeakReference<>(view));

        view.injectPresenter(presenter);*/

    }
}
