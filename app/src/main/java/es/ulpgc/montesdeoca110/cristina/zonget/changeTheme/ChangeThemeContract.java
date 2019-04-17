package es.ulpgc.montesdeoca110.cristina.zonget.changeTheme;

import java.lang.ref.WeakReference;

import es.ulpgc.montesdeoca110.cristina.zonget.app.ChangeThemeItem;
import es.ulpgc.montesdeoca110.cristina.zonget.app.ThemeState;
import es.ulpgc.montesdeoca110.cristina.zonget.data.RepositoryContract;

public interface ChangeThemeContract {

    interface View {

        void injectPresenter(Presenter presenter);

        void displayChangeThemeListData(ChangeThemeViewModel viewModel);

    }

    interface Presenter {

        String getActualThemeName();

        void injectView(WeakReference<View> view);

        void injectModel(Model model);

        void injectRouter(Router router);

        void fetchChangeThemeListData();

        void selectChangeThemeListData(ChangeThemeItem item);

    }

    interface Model {

        void fetchChangeThemeListData(RepositoryContract.Settings.GetChangeThemeListCallback callback);

    }

    interface Router {

        // ----------------------- Tema ------------------------

        ThemeState getActualThemestate();

        void setNewThemeName(ThemeState state);

        //--------------- Navegación entre pantallas -----------

        void navigateToNextScreen();

        //------------- Paso de datos entre pantallas ----------

        void passDataToNextScreen(ChangeThemeState state);

        //------------- Obtener datos entre pantallas ----------

        ChangeThemeState getDataFromPreviousScreen();

    }
}
