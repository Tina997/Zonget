package es.ulpgc.montesdeoca110.cristina.zonget.administratorQueryAnswer;

import java.lang.ref.WeakReference;

import es.ulpgc.montesdeoca110.cristina.zonget.app.QueryItem;
import es.ulpgc.montesdeoca110.cristina.zonget.app.statesBetweenActivities.InboxToQueryDetailState;
import es.ulpgc.montesdeoca110.cristina.zonget.data.RepositoryContract;

interface AdministratorQueryAnswerContract {

  interface View {
    /**
     * Metodo que inicializa el presentador asociado a la vista
     * @param presenter: El presentador de la vista
     */
    void injectPresenter(Presenter presenter);

    void displayData(AdministratorQueryAnswerViewModel viewModel);

    void finish();

    void displayToastMessage(String s);

    void startSendAnswer();
  }

  interface Presenter {

    /**
     * Método que inicializa la vista asociado a ese presentador
     * @param view: La vista a iniciar
     */
    void injectView(WeakReference<View> view);

    /**
     * Metodo que inicializa el modelo asociado al presentador
     * @param model: El modelo a iniciar
     */
    void injectModel(Model model);

    /**
     * Metodo que incializa el router asociado al presentador
     * @param router: El router a iniciar
     */
    void injectRouter(Router router);

    void fetchData();


    /**
     * Metodo que devuelve el tema actual que esta siendo usado en ese momento
     * @return String con el nombre del tema que esta siendo usado
     */
    String getActualThemeName();

    void onSendButtonClicked(String text);
  }

  interface Model {


    void updateQueryAnswer(QueryItem item, String answer,
                           RepositoryContract.Queries.SetQueryAnswerCallback callback);
  }

  interface Router {
    void navigateToNextScreen();

    /**
     * Metodo que edita el estado de la vista almacenado en el mediador
     * @param state: El estado de la vista en cuestion
     */
    void passDataToNextScreen(AdministratorQueryAnswerState state);

    InboxToQueryDetailState getDataFromPreviousScreen();

    void navigateToAdministratorInboxScreen();

    /**
     * Metodo que devuelve el nombre del tema actual que esta siendo utilizado
     * @return string con el nombre  del tema que se esta siendo utilizado
     */
    String getActualThemeName();

    InboxToQueryDetailState getInboxToQueryDetailState();
  }
}
