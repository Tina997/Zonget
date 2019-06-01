package es.ulpgc.montesdeoca110.cristina.zonget.administratorInbox;

import es.ulpgc.montesdeoca110.cristina.zonget.app.Query;
import es.ulpgc.montesdeoca110.cristina.zonget.app.QueryItem;
import es.ulpgc.montesdeoca110.cristina.zonget.data.RepositoryContract;

import java.lang.ref.WeakReference;
import java.util.List;

public class AdministratorInboxPresenter implements AdministratorInboxContract.Presenter {

  public static String TAG = AdministratorInboxPresenter.class.getSimpleName();

  private WeakReference<AdministratorInboxContract.View> view;
  private AdministratorInboxViewModel viewModel;
  private AdministratorInboxContract.Model model;
  private AdministratorInboxContract.Router router;


  public AdministratorInboxPresenter(AdministratorInboxState state) {
    viewModel = state;
  }

  @Override
  public void injectView(WeakReference<AdministratorInboxContract.View> view) {
    this.view = view;
  }

  @Override
  public void injectModel(AdministratorInboxContract.Model model) {
    this.model = model;
  }

  @Override
  public void injectRouter(AdministratorInboxContract.Router router) {
    this.router = router;
  }

  @Override
  public void fetchInboxData() {

    //set passed state

    //llamar al modelo
    model.fetchAdministratorQueriesListData(new RepositoryContract.Queries.GetAdministratorQueriesListCallback() {
      @Override
      public void setAdministratorQueriesList(List<QueryItem> administratorQueriesList) {
        viewModel.inboxList = administratorQueriesList;
        // update the view
        view.get().displayData(viewModel);
      }
    });
  }

  @Override
  public String getActualThemeName() {
    return router.getActualThemeName();
  }

  @Override
  public void onBackButtonPressed() {
    router.onBackButtonPressed();
  }

  @Override
  public void selectQueryItemState(QueryItem item) {
    router.passDataToQueryDetailScreen(item);
    router.navigateToAdministratorQueryDetailScreen();
  }


}
