package es.ulpgc.montesdeoca110.cristina.zonget.changeTheme;

import java.lang.ref.WeakReference;

import es.ulpgc.montesdeoca110.cristina.zonget.app.ChangeThemeItem;
import es.ulpgc.montesdeoca110.cristina.zonget.data.RepositoryContract;

public interface ChangeThemeContract {

    interface View {

        void injectPresenter(Presenter presenter);

        void displayChangeThemeListData(ChangeThemeViewModel viewModel);

        void reboot();

        void finish();
    }

    interface Presenter {

        void injectView(WeakReference<View> view);

        void injectModel(Model model);

        void injectRouter(Router router);

        String getActualThemeName();

        void fetchChangeThemeListData();

        void selectChangeThemeListData(ChangeThemeItem item);

        void backButtonPressed();
    }

    interface Model {

        void fetchChangeThemeListData(RepositoryContract.Settings.GetChangeThemeListCallback callback);

    }

    interface Router {

        //------------------------- Tema ---------------------

        String getActualThemeName();

        void changeActualTheme(String themeName);

        //--------------- Navegación entre pantallas -----------

        void navigateToMenuScreen();

        //------------- Paso de datos entre pantallas ----------

        void passDataToNextScreen(ChangeThemeState state);

        //------------- Obtener datos entre pantallas ----------

        ChangeThemeState getDataFromPreviousScreen();

    }
}
