package es.ulpgc.montesdeoca110.cristina.zonget.administratorQueryAnswer;

import java.lang.ref.WeakReference;

import es.ulpgc.montesdeoca110.cristina.zonget.app.statesBetweenActivities.InboxToQueryDetailState;
import es.ulpgc.montesdeoca110.cristina.zonget.data.RepositoryContract;

public class AdministratorQueryAnswerPresenter implements AdministratorQueryAnswerContract.Presenter {

  public static String TAG = AdministratorQueryAnswerPresenter.class.getSimpleName();

  private WeakReference<AdministratorQueryAnswerContract.View> view;
  private final AdministratorQueryAnswerViewModel viewModel;
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
    //set passed state
    InboxToQueryDetailState state = router.getInboxToQueryDetailState();
    if(state != null){
      viewModel.query = state.query;
    }


  }

  @Override
  public String getActualThemeName() {
    return router.getActualThemeName();
  }

  @Override
  public void onSendButtonClicked(String answer){
    if(answer != ""){
      view.get().startSendAnswer();
      InboxToQueryDetailState item = router.getInboxToQueryDetailState();
      model.updateQueryAnswer(item.query, answer, new RepositoryContract.Queries.SetQueryAnswerCallback() {
        @Override
        public void onQueryAnswerSet(boolean correct) {
          if(correct){
            view.get().finish();
            router.navigateToAdministratorInboxScreen();
          }else{
            view.get().displayToastMessage("La respuesta no ha sido enviada correctamemte.");
          }
        }
      });
    }else{
      view.get().displayToastMessage("Falta por introducir información");
    }

  }


  @Override
  public void onBackButtonPressed(){
    router.navigateToQueryDetailScreen();
  }


}
