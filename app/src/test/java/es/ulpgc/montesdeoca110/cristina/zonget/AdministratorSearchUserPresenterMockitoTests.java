package es.ulpgc.montesdeoca110.cristina.zonget;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;

import java.lang.ref.WeakReference;

import es.ulpgc.montesdeoca110.cristina.zonget.administratorSearchUsers.AdministratorSearchUsersContract;
import es.ulpgc.montesdeoca110.cristina.zonget.administratorSearchUsers.AdministratorSearchUsersPresenter;
import es.ulpgc.montesdeoca110.cristina.zonget.administratorSearchUsers.AdministratorSearchUsersState;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

@RunWith(MockitoJUnitRunner.class)
public class AdministratorSearchUserPresenterMockitoTests {

    @Mock
    private AdministratorSearchUsersContract.Model model;

    @Mock
    private AdministratorSearchUsersContract.View view;
    @Mock
    private AdministratorSearchUsersContract.Router router;
    private AdministratorSearchUsersContract.Presenter presenter;

    @Before
    public void configureMockito() {
        MockitoAnnotations.initMocks(this);
    }

    private void configureScreen(AdministratorSearchUsersState state) {
        presenter = new AdministratorSearchUsersPresenter(state);
        presenter.injectView(new WeakReference<>(view));
        presenter.injectModel(model);
        presenter.injectRouter(router);
    }

    @Test
    public void searchUserWithoutData() {
        configureScreen(new AdministratorSearchUsersState());
        presenter.searchButtonClicked("");
        verify(router, times(1)).navigateToNextScreen();
    }

    @Test
    public void backPressed() {
        configureScreen(new AdministratorSearchUsersState());
        presenter.onBackButtonPressed();
        verify(router, times(1)).onBackButtonPressed();
    }


}
