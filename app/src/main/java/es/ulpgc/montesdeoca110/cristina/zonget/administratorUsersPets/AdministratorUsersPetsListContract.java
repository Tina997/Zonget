package es.ulpgc.montesdeoca110.cristina.zonget.administratorUsersPets;

import java.lang.ref.WeakReference;

import es.ulpgc.montesdeoca110.cristina.zonget.app.AccountItem;
import es.ulpgc.montesdeoca110.cristina.zonget.app.UserPetItem;
import es.ulpgc.montesdeoca110.cristina.zonget.data.RepositoryContract;


interface AdministratorUsersPetsListContract {

  interface View {

    /**
     * Metodo que inicializa el presentador asociado a la vista
     *
     * @param presenter: El presentador de la vista
     */
    void injectPresenter(Presenter presenter);

    void displayUserPetsData(AdministratorUsersPetsListViewModel viewModel);
  }

  interface Presenter {

    /**
     * Método que inicializa la vista asociado a ese presentador
     *
     * @param view: La vista a iniciar
     */
    void injectView(WeakReference<AdministratorUsersPetsListContract.View> view);

    /**
     * Metodo que inicializa el modelo asociado al presentador
     *
     * @param model: El modelo a iniciar
     */
    void injectModel(AdministratorUsersPetsListContract.Model model);

    /**
     * Metodo que incializa el router asociado al presentador
     *
     * @param router: El router a iniciar
     */
    void injectRouter(AdministratorUsersPetsListContract.Router router);

    void fetchUserPetsData();

    void selectUserPetsData(UserPetItem item);

    void onClickAddButton();

    /**
     * Metodo que devuelve el tema actual que esta siendo usado en ese momento
     *
     * @return String con el nombre del tema que esta siendo usado
     */
    String getActualThemeName();

    void onBackButtonPressed();
  }

  interface Model {
    void fetchPetsData(AccountItem item, RepositoryContract.Accounts.GetUserPetsListCallback callback);
  }

  interface Router {
    void navigateToPetsDetailScreen();

    void passDataToPetsDetailScreen(UserPetItem item);

    AdministratorUsersPetsListState getDataFromPreviousScreen();

    void navigateToAddScreen();

    /**
     * Metodo que devuelve el nombre del tema actual que esta siendo utilizado
     *
     * @return string con el nombre  del tema que se esta siendo utilizado
     */
    String getActualThemeName();

    void onBackButtonPressed();
  }
}
