package es.ulpgc.montesdeoca110.cristina.zonget.addLostPet;

import java.lang.ref.WeakReference;

interface AddLostPetContract {

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
     * Metodo que rellena la vista con la informacion del modelo
     */
    void fetchData();

    /**
     * Metodo que devuelve el tema actual que esta siendo usado en ese momento
     * @return String con el nombre del tema que esta siendo usado
     */
    String getActualThemeName();

    /**
     * Metodo llamado al pulsar el boton back el cual llama al router para cambiar de vista
     */
    void onBackButtonPressed();
  }

  interface Model {
      //TODO Metodo inutilizado
      String fetchData();
  }

  interface Router {

    /**
     * Metodo que recupera el estado de la vista en un punto anterior de esta
     * @return el estado de la vista.
     */
    AddLostPetState getDataFromPreviousScreen();

    /**
     * Metodo que devuelve el nombre del tema actual que esta siendo utilizado
     * @return string con el nombre  del tema que se esta siendo utilizado
     */
    String getActualThemeName();

    /**
     * Metodo que cambia la vista a la de la lista de mascotas perdidas
     */
    void onBackButtonPressed();
  }
}
