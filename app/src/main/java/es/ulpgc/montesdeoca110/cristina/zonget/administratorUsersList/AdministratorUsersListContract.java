package es.ulpgc.montesdeoca110.cristina.zonget.administratorUsersList;

import java.lang.ref.WeakReference;

import es.ulpgc.montesdeoca110.cristina.zonget.app.AccountItem;
import es.ulpgc.montesdeoca110.cristina.zonget.app.statesBetweenActivities.SearchToListUserState;
import es.ulpgc.montesdeoca110.cristina.zonget.data.RepositoryContract;

interface AdministratorUsersListContract {

  interface View {

    /**
     * Metodo que inicializa el presentador asociado a la vista
     *
     * @param presenter: El presentador de la vista
     */
    void injectPresenter(Presenter presenter);

    /**
     * Relleno de la lista de mascotas obteniendo la informacion del viewModel
     *
     * @param viewModel: del cual se extrae la informacion
     */
    void displayData(AdministratorUsersListViewModel viewModel);
  }

  interface Presenter {

    /**
     * Método que inicializa la vista asociado a ese presentador
     *
     * @param view: La vista a iniciar
     */
    void injectView(WeakReference<View> view);

    /**
     * Metodo que inicializa el modelo asociado al presentador
     *
     * @param model: El modelo a iniciar
     */
    void injectModel(Model model);

    /**
     * Metodo que incializa el router asociado al presentador
     *
     * @param router: El router a iniciar
     */
    void injectRouter(Router router);

    /**
     * Cargar en el viewModel la informacion de lo obtenido del modelo
     */
    void fetchAdminUsersData();

    /**
     * Metodo que al elegir un usuario pasa este al router
     *
     * @param userItem: Usuario escogido
     */
    void selectAdminUserData(AccountItem userItem);

    /**
     * Metodo que devuelve el tema actual que esta siendo usado en ese momento
     *
     * @return String con el nombre del tema que esta siendo usado
     */
    String getActualThemeName();

    /**
     * Metodo que llama al presentador para cambiar de vista
     */
    void onBackButtonPressed();
  }

  interface Model {
    /**
     * Metodo que le pide la informacion al repositorio que cumpla el requisito de que
     * coincida con el nombre o DNI buscado
     *
     * @param nameOrDni: nombre o DNI buscado
     * @param callback:  callback que realiza la comunicacion entre modelo y el repositorio
     */
    void fetchUsersData(String nameOrDni, RepositoryContract.Accounts.GetUserListCallback callback);
  }

  interface Router {

    /**
     * Metodo que manda a la clase detalle el usuario seleccionado
     *
     * @param item: El usuario seleccionado
     */
    void passDataToUserDetailScreen(AccountItem item);

    /**
     * Metodo que cambia la vista por la vista del detalle de un usuario (Su lista de mascotas)
     */
    void navigateToUserDetailScreen();

    /**
     * Metodo que devuelve el nombre del tema actual que esta siendo utilizado
     *
     * @return string con el nombre  del tema que se esta siendo utilizado
     */
    String getActualThemeName();

    /**
     * Metodo que regresa la vista a la de la busqueda de usuarios
     */
    void onBackButtonPressed();

    /**
     * Metodo que devuelve el estado de searchToListUserState del mediador el cual
     * ha sido cambiado anteriormente por la vista search
     *
     * @return el estado el cual contiene la lista de usuarios que cumplen el requisito
     */
    SearchToListUserState getSearchToListUserState();
  }
}
