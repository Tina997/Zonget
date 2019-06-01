package es.ulpgc.montesdeoca110.cristina.zonget.administratorQueryAnswer;

import android.util.Log;

import java.lang.ref.WeakReference;

import es.ulpgc.montesdeoca110.cristina.zonget.app.statesBetweenActivities.InboxToQueryDetailState;

public class AdministratorQueryAnswerPresenter implements AdministratorQueryAnswerContract.Presenter {

  public static String TAG = AdministratorQueryAnswerPresenter.class.getSimpleName();

  private WeakReference<AdministratorQueryAnswerContract.View> view;
  private AdministratorQueryAnswerViewModel viewModel;
  private AdministratorQueryAnswerContract.Model model;
  private AdministratorQueryAnswerContract.Router router;

  public AdministratorQueryAnswerPresenter(AdministratorQueryAnswerState state) {
    viewModel = state;
  }

  @Override
  public void injectView(WeakReference<AdministratorQueryAnswerContract.View> view) {
    this.view = view;
  }

  @Override
  public void injectModel(AdministratorQueryAnswerContract.Model model) {
    this.model = model;
  }

  @Override
  public void injectRouter(AdministratorQueryAnswerContract.Router router) {
    this.router = router;
  }

  @Override
  public void fetchData() {
    // Log.e(TAG, "fetchPetsForAdoptionListData()");

    // set passed state


  }

  @Override
  public String getActualThemeName() {
    return router.getActualThemeName();
  }

  @Override
  public void onSendButtonClicked(String answer){

  }

  @Override
  public void navigateToAdministratorInboxScreen() {
    router.navigateToAdministratorInboxScreen();
  }


}
