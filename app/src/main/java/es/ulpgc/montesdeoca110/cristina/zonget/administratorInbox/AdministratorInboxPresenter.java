package es.ulpgc.montesdeoca110.cristina.zonget.administratorInbox;

import es.ulpgc.montesdeoca110.cristina.zonget.app.InboxItem;
import es.ulpgc.montesdeoca110.cristina.zonget.app.QueryItem;
import es.ulpgc.montesdeoca110.cristina.zonget.data.RepositoryContract;

import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;

public class AdministratorInboxPresenter implements AdministratorInboxContract.Presenter {

  public static String TAG = AdministratorInboxPresenter.class.getSimpleName();

  private WeakReference<AdministratorInboxContract.View> view;
  private final AdministratorInboxViewModel viewModel;
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

    final List<InboxItem> inboxItems = new ArrayList<>();

    //llamar al modelo
    model.fetchAdministratorQueriesListData(new RepositoryContract.Queries.GetAdministratorQueriesListCallback() {
      @Override
      public void setAdministratorQueriesList(List<QueryItem> administratorQueriesList) {
        for(int i = 0; i< administratorQueriesList.size(); i++){
          final QueryItem queryItem = administratorQueriesList.get(i);
          model.getUserName(queryItem.userId, new RepositoryContract.Accounts.GetUserNameCallback() {
            @Override
            public void getUserName(String userName) {
              inboxItems.add(new InboxItem(userName, queryItem));
            }
          });
        }
        viewModel.inboxList = inboxItems;
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
  public void selectQueryItemState(InboxItem item) {
    QueryItem queryItem = item.queryItem;
    router.passDataToQueryDetailScreen(queryItem);
    router.navigateToAdministratorQueryDetailScreen();
  }


}
