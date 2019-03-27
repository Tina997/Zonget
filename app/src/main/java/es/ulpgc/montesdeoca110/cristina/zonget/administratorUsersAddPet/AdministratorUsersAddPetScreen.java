package es.ulpgc.montesdeoca110.cristina.zonget.administratorUsersAddPet;

import java.lang.ref.WeakReference;

import android.support.v4.app.FragmentActivity;

import es.ulpgc.montesdeoca110.cristina.zonget.app.AppMediator;

public class AdministratorUsersAddPetScreen {

    public static void configure(AdministratorUsersAddPetContract.View view) {

        WeakReference<FragmentActivity> context =
                new WeakReference<>((FragmentActivity) view);

        AppMediator mediator = (AppMediator) context.get().getApplication();
        //AdministratorUsersAddPetState state = mediator.getAdministratorUsersAddPetState();

        AdministratorUsersAddPetContract.Router router = new AdministratorUsersAddPetRouter(mediator);
        //AdministratorUsersAddPetContract.Presenter presenter = new AdministratorUsersAddPetPresenter(state);
        AdministratorUsersAddPetContract.Model model = new AdministratorUsersAddPetModel();
       /* presenter.injectModel(model);
        presenter.injectRouter(router);
        presenter.injectView(new WeakReference<>(view));

        view.injectPresenter(presenter);*/

    }
}
