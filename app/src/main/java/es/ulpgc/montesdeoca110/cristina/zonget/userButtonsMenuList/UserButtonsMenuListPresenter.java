package es.ulpgc.montesdeoca110.cristina.zonget.userButtonsMenuList;

import android.util.Log;

import java.lang.ref.WeakReference;

import es.ulpgc.montesdeoca110.cristina.zonget.app.UserButtonMenuItem;

public class UserButtonsMenuListPresenter implements UserButtonsMenuListContract.Presenter {

    public static String TAG = UserButtonsMenuListPresenter.class.getSimpleName();

    private WeakReference<UserButtonsMenuListContract.View> view;
    private UserButtonsMenuListViewModel viewModel;
    private UserButtonsMenuListContract.Model model;
    private UserButtonsMenuListContract.Router router;

    public UserButtonsMenuListPresenter(UserButtonsMenuListState state) {
        viewModel = state;
    }

    @Override
    public void injectView(WeakReference<UserButtonsMenuListContract.View> view) {
        this.view = view;
    }

    @Override
    public void injectModel(UserButtonsMenuListContract.Model model) {
        this.model = model;
    }

    @Override
    public void injectRouter(UserButtonsMenuListContract.Router router) {
        this.router = router;
    }

    @Override
    public void fetchUserButtonsMenuListData() {

        //Llamamos al modelo para que nos de la información
        viewModel.user_buttons = model.fetchUserButtonsMenuListData();

        // Actualizamos la vista
        view.get().displayUserButtonsMenuListData(viewModel);

    }

    @Override
    public void selectUserButtonsMenuListData(UserButtonMenuItem item) {
        //router.passDataToProductListScreen(item);
        //router.navigateToProductListScreen();
    }

}
