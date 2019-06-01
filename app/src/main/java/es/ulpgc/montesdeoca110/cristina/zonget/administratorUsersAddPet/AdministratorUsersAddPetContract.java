package es.ulpgc.montesdeoca110.cristina.zonget.administratorUsersAddPet;

import android.text.Editable;

import java.lang.ref.WeakReference;

import es.ulpgc.montesdeoca110.cristina.zonget.data.RepositoryContract;

interface AdministratorUsersAddPetContract {

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
     * Metodo que pasa al modelo los parametros necesarios para un userPet
     * @param name: nombre de la mascota
     * @param species: especie de la mascota
     * @param breed: raza de la mascota
     * @param chipNum: numero de chip de la mascota
     * @param birthday: fecha de nacimiento de la mascota
     */
    void insertNewPet(String name, String species, String breed, String chipNum, String birthday);

    /**
     * Metodo que devuelve el tema actual que esta siendo usado en ese momento
     * @return String con el nombre del tema que esta siendo usado
     */
    String getActualThemeName();

    /**
     * Metodo que cambia la vista por la vista anterior
     */
    void onBackButtonPressed();

    /**
     * Metodo que comprueba si todos los campos de texto tienen algo escrito o no
     * @param name: campo de texto del nombre de la mascota
     * @param species: campo de texto de la especie de la mascota
     * @param breed: campo de texto de la raza de la mascota
     * @param chip: campo de texto del numero de chip de la mascota
     * @param birthday: campo de texto de la fecha de nacimiento de la mascota
     * @return true en caso de que haya algo escrito en todos y false en caso de que alguno este vacio
     */
    boolean checkAllDataIntroduced(Editable name, Editable species, Editable breed, Editable chip, Editable birthday);
  }

  interface Model {

    /**
     * Metodo que le pasa al repositorio los parametros del animal a añadir
     * @param userID: identificador del usuario al que se le va a añadir la mascota
     * @param name: nombre de la mascota a editar
     * @param species: especie de la mascota a añadir
     * @param breed: raza de las mascota a añadir
     * @param chipNum: numero de chip de la mascota a añadir
     * @param birthday: fecha de nacimiento de la mascota a añadir
     * @param callback: callback que realizara las operaciones
     */
    void insertNewPet(int userID, String name, String species, String breed, String chipNum, String birthday, RepositoryContract.Accounts.InsertNewUserPetCallback callback);
  }

  interface Router {
    /**
     * Metodo que cambia la vista por la del detalle de la mascota añadida
     */
    void navigateToNextScreen();

    /**
     * Metodo que edita el estado de la vista almacenado en el mediador
     * @param state: El estado de la vista en cuestion
     */
    void passDataToNextScreen(AdministratorUsersAddPetState state);

      /**
       * Metodo que obtiene el estado de la clase desde el mediador
       * @return el estado de la clase
       */
    AdministratorUsersAddPetState getDataFromPreviousScreen();

    /**
     * Metodo que devuelve el nombre del tema actual que esta siendo utilizado
     * @return string con el nombre  del tema que se esta siendo utilizado
     */
    String getActualThemeName();

      /**
       * Metodo que cambia la vista por la de la busqueda de usuarios
       */
    void onBackButtonPressed();
  }
}
