package es.ulpgc.montesdeoca110.cristina.zonget.changeTheme;

import es.ulpgc.montesdeoca110.cristina.zonget.app.ChangeThemeItem;
import es.ulpgc.montesdeoca110.cristina.zonget.app.ChangeThemeToMenuState;
import es.ulpgc.montesdeoca110.cristina.zonget.data.RepositoryContract;
import java.lang.ref.WeakReference;
import java.util.List;

public class ChangeThemePresenter implements ChangeThemeContract.Presenter {

  private WeakReference<ChangeThemeContract.View> view;
  private ChangeThemeViewModel viewModel;
  private ChangeThemeContract.Model model;
  private ChangeThemeContract.Router router;

  public ChangeThemePresenter(ChangeThemeState state) {
    viewModel = state;
  }

  @Override
  public String getActualThemeName() {
    return router.getActualThemeName();
  }

  @Override
  public void injectView(WeakReference<ChangeThemeContract.View> view) {
    this.view = view;
  }

  @Override
  public void injectModel(ChangeThemeContract.Model model) {
    this.model = model;
  }

  @Override
  public void injectRouter(ChangeThemeContract.Router router) {
    this.router = router;
  }

  @Override
  public void backButtonPressed() {
    ChangeThemeToMenuState state = new ChangeThemeToMenuState();
    state.themeChanged = true;
    view.get().finish();
    router.passDataToMenuScreen(state);
    router.navigateToMenuScreen();
  }

  @Override
  public void fetchChangeThemeListData() {
    model.fetchChangeThemeListData(new RepositoryContract.Settings.GetChangeThemeListCallback() {
      @Override
      public void setChangeThemeList(List<ChangeThemeItem> themeList) {
        viewModel.themeList = themeList;
        view.get().displayChangeThemeListData(viewModel);
      }
    });
  }

  @Override
  public void selectChangeThemeListData(ChangeThemeItem item) {
    router.changeActualTheme(item.themeName);
    viewModel.themeChanged = item.themeName;
    view.get().reboot();
  }
}
