package es.ulpgc.montesdeoca110.cristina.zonget.userButtonsMenuList;

import java.lang.ref.WeakReference;
import java.util.List;

import es.ulpgc.montesdeoca110.cristina.zonget.app.ChangeThemeToMenuState;
import es.ulpgc.montesdeoca110.cristina.zonget.app.UserButtonMenuItem;
import es.ulpgc.montesdeoca110.cristina.zonget.data.RepositoryContract;

public class UserButtonsMenuListPresenter implements UserButtonsMenuListContract.Presenter {

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
    public String getActualThemeName() {
        return router.getActualThemeName();
    }

    @Override
    public void fetchUserButtonsMenuListData() {

        model.fetchUserButtonsMenuListData(new RepositoryContract.Settings.GetUserMenuButtonsListCallback() {
            @Override
            public void setUserMenuButtonsList(List<UserButtonMenuItem> userButtons) {
                viewModel.userButtons = userButtons;
                view.get().displayUserButtonsMenuListData(viewModel);
            }
        });

    }

    @Override
    public void signOutButtonPressed() {
        view.get().finish();
        router.navigateToSignInScreen();
    }

    @Override
    public void pickForADateButtonPressed() {
        router.passDataToUserPickDateScreen();
        router.navigateToUserPickDateScreen();
    }

    @Override
    public void selectUserButtonsMenuListData(UserButtonMenuItem button) {
        view.get().finish();
        router.navigateToSelectedActivityScreen(button.activity);
    }

    @Override
    public void changeThemeButtonPressed() {
        router.navigateToChangeThemeScreen();
    }

    @Override
    public void checkThemeChanged() {
        ChangeThemeToMenuState state = router.getDataFromChangeThemeScreen();
        if (state != null){
            //Todo Apaño temporal
            String completeThemename = "es.ulpc.montesdeoca110.cristina.zonget.complete:style/" + state.themeChanged;
            if (!view.get().getActualThemeName().equals(completeThemename)){
                view.get().reboot();
            }
        }
    }

}
