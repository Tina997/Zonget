package es.ulpgc.montesdeoca110.cristina.zonget.changeTheme;

import java.lang.ref.WeakReference;

public interface ChangeThemeContract {

    interface View {

        void injectPresenter(Presenter presenter);

        void displayChangeThemeData(ChangeThemeViewModel viewModel);

    }

    interface Presenter {

        void injectView(WeakReference<View> view);

        void injectModel(Model model);

        void injectRouter(Router router);

        void fetchChangeThemeData();

    }

    interface Model {

        String fetchChangeThemeData();

    }

    interface Router {

        void navigateToNextScreen();

        void passDataToNextScreen(ChangeThemeState state);

        ChangeThemeState getDataFromPreviousScreen();

    }
}
