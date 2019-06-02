package es.ulpgc.montesdeoca110.cristina.zonget.administratorQueryDetail;

import java.lang.ref.WeakReference;

import es.ulpgc.montesdeoca110.cristina.zonget.app.statesBetweenActivities.InboxToQueryDetailState;

public class AdministratorQueryDetailPresenter
        implements AdministratorQueryDetailContract.Presenter {

  public static String TAG = AdministratorQueryDetailPresenter.class.getSimpleName();

  private WeakReference<AdministratorQueryDetailContract.View> view;
  private final AdministratorQueryDetailViewModel viewModel;
  private AdministratorQueryDetailContract.Router router;

  public AdministratorQueryDetailPresenter(AdministratorQueryDetailState state) {
    viewModel = state;
  }

  @Override
  public void injectView(WeakReference<AdministratorQueryDetailContract.View> view) {
    this.view = view;
  }

  @Override
  public void injectModel(AdministratorQueryDetailContract.Model model) {
    AdministratorQueryDetailContract.Model model1 = model;
  }

  @Override
  public void injectRouter(AdministratorQueryDetailContract.Router router) {
    this.router = router;
  }

  @Override
  public void fetchData() {
    // Log.e(TAG, "fetchPetsForAdoptionListData()");

    // set passed state
    InboxToQueryDetailState state = router.getDataFromPreviousScreen();
    if (state != null) {
      viewModel.queryItem = state.query;
    }

    // update the view
    view.get().displayData(viewModel);

  }

  @Override
  public String getActualThemeName() {
    return router.getActualThemeName();
  }

  @Override
  public void onReplyButtonPressed() {
    router.navigateToAdministratorQueryAnswerScreen();
  }

  @Override
  public void onBackButtonPressed(){
    router.navigateToAdministratorInboxScreen();
  }


}
