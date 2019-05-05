package es.ulpgc.montesdeoca110.cristina.zonget.administratorButtonsMenuList;

import es.ulpgc.montesdeoca110.cristina.zonget.app.AdministratorButtonMenuItem;
import es.ulpgc.montesdeoca110.cristina.zonget.app.ChangeThemeToMenuState;
import es.ulpgc.montesdeoca110.cristina.zonget.app.MenuToSelectedActivityState;
import es.ulpgc.montesdeoca110.cristina.zonget.app.MenuToSignInState;
import es.ulpgc.montesdeoca110.cristina.zonget.data.RepositoryContract;
import java.lang.ref.WeakReference;
import java.util.List;

public class AdministratorButtonsMenuListPresenter
        implements AdministratorButtonsMenuListContract.Presenter {

  private WeakReference<AdministratorButtonsMenuListContract.View> view;
  private AdministratorButtonsMenuListViewModel viewModel;
  private AdministratorButtonsMenuListContract.Model model;
  private AdministratorButtonsMenuListContract.Router router;

  public AdministratorButtonsMenuListPresenter(AdministratorButtonsMenuListState state) {
    viewModel = state;
  }

  @Override
  public void injectView(WeakReference<AdministratorButtonsMenuListContract.View> view) {
    this.view = view;
  }

  @Override
  public void injectModel(AdministratorButtonsMenuListContract.Model model) {
    this.model = model;
  }

  @Override
  public void injectRouter(AdministratorButtonsMenuListContract.Router router) {
    this.router = router;
  }

  @Override
  public String getActualThemeName() {
    return router.getActualThemeName();
  }

  @Override
  public void fetchAdministratorButtonsMenuListData() {

    model.fetchAdministratorButtonsMenuListData(
            new RepositoryContract.Settings.GetAdministratorMenuButtonsListCallback() {
            @Override
            public void setAdministratorMenuButtonsList(List<AdministratorButtonMenuItem>
                                                                administratorButtons) {
              viewModel.administratorButtons = administratorButtons;
              view.get().displayAdministratorButtonsMenuListData(viewModel);
            }
          });

  }

  @Override
  public void signOutButtonPressed() {
    MenuToSignInState state = new MenuToSignInState();
    view.get().finish();
    router.passDataToSignInScreen(state);
    router.navigateToSignInScreen();
  }

  @Override
  public void selectAdministratorButtonsMenuListData(AdministratorButtonMenuItem button) {

    MenuToSelectedActivityState state = new MenuToSelectedActivityState();
    router.passDataToSelectedActivityScreen(state);
    router.navigateToSelectedActivityScreen(button.activity);
  }

  @Override
  public void changeThemeButtonPressed() {
    router.navigateToChangeThemeScreen();
  }

  @Override
  public void checkThemeChanged() {
    ChangeThemeToMenuState state = router.getDataFromChangeThemeScreen();
    if (state != null) {
      if (state.themeChanged == true) {
        router.setChangeThemeToMenuState(false);
        view.get().reboot();
      }
    }
  }

}
