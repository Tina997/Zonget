package es.ulpgc.montesdeoca110.cristina.zonget.petsForAdoption;

import es.ulpgc.montesdeoca110.cristina.zonget.app.PetForAdoptionItem;
import es.ulpgc.montesdeoca110.cristina.zonget.data.RepositoryContract;
import java.lang.ref.WeakReference;

public interface PetsForAdoptionContract {

  interface View {

    /**
     * Metodo que inicializa el presentador asociado a la vista
     * @param presenter: El presentador de la vista
     */
    void injectPresenter(Presenter presenter);

    void displayData(PetsForAdoptionViewModel viewModel);
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

    void fetchPetsForAdoptionListData();

    void selectPet(PetForAdoptionItem petForAdoptionItem);

    void gotToAddPetForAdoption();

    /**
     * Metodo que devuelve el tema actual que esta siendo usado en ese momento
     * @return String con el nombre del tema que esta siendo usado
     */
    String getActualThemeName();

    void onBackButtonPressed();
  }

  interface Model {
    void fetchPetsForAdoptionListData(RepositoryContract.PetsForAdoption
                                              .GetPetsForAdoptionListCallback callback);
  }

  interface Router {
    void navigateToNextScreen();

    void passDataToDetailScreen(PetForAdoptionItem petsForAdoptionItem);

    PetsForAdoptionState getDataFromPreviousScreen();

    void navigateToAddPetForAdoptionScreen();

    /**
     * Metodo que devuelve el nombre del tema actual que esta siendo utilizado
     * @return string con el nombre  del tema que se esta siendo utilizado
     */
    String getActualThemeName();

    void onBackButtonPressed();
  }
}
