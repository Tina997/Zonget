package es.ulpgc.montesdeoca110.cristina.zonget.administratorSearchUsers;

import java.lang.ref.WeakReference;

import es.ulpgc.montesdeoca110.cristina.zonget.app.statesBetweenActivities.SearchToListUserState;

public class AdministratorSearchUsersPresenter implements AdministratorSearchUsersContract.Presenter {

    public static String TAG = AdministratorSearchUsersPresenter.class.getSimpleName();

  private AdministratorSearchUsersContract.Router router;

    public AdministratorSearchUsersPresenter(AdministratorSearchUsersState state) {
      AdministratorSearchUsersViewModel viewModel = state;
    }

    @Override
    public void injectView(WeakReference<AdministratorSearchUsersContract.View> view) {
      WeakReference<AdministratorSearchUsersContract.View> view1 = view;
    }

    @Override
    public void injectModel(AdministratorSearchUsersContract.Model model) {
      AdministratorSearchUsersContract.Model model1 = model;
    }

    @Override
    public void injectRouter(AdministratorSearchUsersContract.Router router) {
        this.router = router;
    }

    @Override
    public void searchButtonClicked(String nameOrDni) {
        SearchToListUserState state = new SearchToListUserState();
        state.nameOrDni = nameOrDni;
        router.passDataToNextScreen(state);
        router.navigateToNextScreen();
    }

    @Override
    public String getActualThemeName() {
        return router.getActualThemeName();
    }

    @Override
    public void onBackButtonPressed() {
        router.onBackButtonPressed();
    }


}
