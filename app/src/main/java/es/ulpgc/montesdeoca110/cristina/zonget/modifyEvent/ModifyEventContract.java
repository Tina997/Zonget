package es.ulpgc.montesdeoca110.cristina.zonget.modifyEvent;

import java.lang.ref.WeakReference;

interface ModifyEventContract {

    interface View {
        void injectPresenter(Presenter presenter);

        void displayData(ModifyEventViewModel viewModel);
    }

    interface Presenter {
        void injectView(WeakReference<View> view);

        void injectModel(Model model);

        void injectRouter(Router router);

        void fetchData();

        void modifyEvent();

        void navigateToAdministratorAgendaScreen();

        String getActualThemeName();
    }

    interface Model {
        String fetchData();
    }

    interface Router {
        void navigateToNextScreen();

        void passDataToNextScreen(ModifyEventState state);

        ModifyEventState getDataFromPreviousScreen();

        void navigateToAdministratorAgendaScreen();

        String getActualThemeName();
    }
}
