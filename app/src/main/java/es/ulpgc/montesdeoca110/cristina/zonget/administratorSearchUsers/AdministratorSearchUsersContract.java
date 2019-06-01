package es.ulpgc.montesdeoca110.cristina.zonget.administratorSearchUsers;

import java.lang.ref.WeakReference;

import es.ulpgc.montesdeoca110.cristina.zonget.app.statesBetweenActivities.SearchToListUserState;

public interface AdministratorSearchUsersContract {

    interface View {
        /**
         * Metodo que inicializa el presentador asociado a la vista
         * @param presenter: El presentador de la vista
         */
        void injectPresenter(Presenter presenter);

        void displayData(AdministratorSearchUsersViewModel viewModel);
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
         * Metodo que llama al modelo el parametro a buscar en la lista
         * @param nameOrDni: parametro de la busqueda del usuario
         */
        void searchButtonClicked(String nameOrDni);
        /**
         * Metodo que devuelve el tema actual que esta siendo usado en ese momento
         * @return String con el nombre del tema que esta siendo usado
         */
        String getActualThemeName();

        /**
         * Metodo que llama al router para realizar el cambio de vista a la anterior
         */
        void onBackButtonPressed();
    }

    interface Model {
    }

    interface Router {
        /**
         * Metodo que cambia la vista por la de la lista de usuarios que cumplan el requisito
         */
        void navigateToNextScreen();

        /**
         * Metodo que edita el estado searchToListUser almacenado en el mediador
         * @param state: El estado de la vista en cuestion
         */
        void passDataToNextScreen(SearchToListUserState state);

        /**
         * Metodo que devuelve el nombre del tema actual que esta siendo utilizado
         * @return string con el nombre  del tema que se esta siendo utilizado
         */
        String getActualThemeName();

        /**
         * Metodo que cambia la vista a la del menu principal del administrador
         */
        void onBackButtonPressed();
    }
}
