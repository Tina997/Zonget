package es.ulpgc.montesdeoca110.cristina.zonget.administratorUserEditPet;

import java.lang.ref.WeakReference;

import es.ulpgc.montesdeoca110.cristina.zonget.app.UserPetItem;
import es.ulpgc.montesdeoca110.cristina.zonget.data.RepositoryContract;

interface AdministratorUserEditPetContract {

  interface View {

    /**
     * Metodo que inicializa el presentador asociado a la vista
     * @param presenter: El presentador de la vista
     */
    void injectPresenter(Presenter presenter);

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

    /**
     * Metodo que le pasa al modelo una mascota para ser añadida a la lista de mascotas del cliente
     * @param userPetItem: Mascota que sera añadida
     */
    void insertNewPet(UserPetItem userPetItem);
    /**
     * Metodo que devuelve el tema actual que esta siendo usado en ese momento
     * @return String con el nombre del tema que esta siendo usado
     */
    String getActualThemeName();

    /**
     * Metodo que llama al router para regresar a la pantalla anterior
     */
    void onBackButtonPressed();

    /**
     * Metodo que se utiliza obtiene la mascota a editar para rellenar la informacion de la vista
     * @return la mascota que se va a editar
     */
    UserPetItem fetchPetData();
  }

  interface Model {

      String fetchData();

    /**
     * Metodo que la pasa al repositorio la nueva mascota para cambiar la que ya se encuentra en la BD con ese ID por la nueva
     * @param userPetItem: Nueva mascota a añadir
     * @param updateNewUserPetCallback: Callback que realizara las operaciones
     */
    void editPet(UserPetItem userPetItem, RepositoryContract.Accounts.UpdateUserPetCallback updateNewUserPetCallback);
  }

  interface Router {

    /**
    * Metodo que cambia la vista mostrada por la vista de la lista de mascotas
    */
    void navigateToNextScreen();

    /**
     * Metodo que edita el estado de la vista almacenado en el mediador
     * @param state: El estado de la vista en cuestion
     */
    void passDataToNextScreen(AdministratorUserEditPetState state);

      /**
       * Metodo que obtiene desde el mediator la mascota que se esta editando
       * @return : la mascota que se esta editando
       */
    UserPetItem getDataFromPreviousScreen();

    /**
     * Metodo que devuelve el nombre del tema actual que esta siendo utilizado
     * @return string con el nombre  del tema que se esta siendo utilizado
     */
    String getActualThemeName();

    /**
     * Metodo que cambia la vista por la vista anterior
     */
    void onBackButtonPressed();
  }
}
