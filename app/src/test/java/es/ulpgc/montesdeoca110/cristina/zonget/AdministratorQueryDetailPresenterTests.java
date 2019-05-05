package es.ulpgc.montesdeoca110.cristina.zonget;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;

import java.lang.ref.WeakReference;

import es.ulpgc.montesdeoca110.cristina.zonget.administratorQueryDetail.AdministratorQueryDetailContract;
import es.ulpgc.montesdeoca110.cristina.zonget.administratorQueryDetail.AdministratorQueryDetailPresenter;
import es.ulpgc.montesdeoca110.cristina.zonget.administratorQueryDetail.AdministratorQueryDetailState;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

@RunWith(MockitoJUnitRunner.class)
public class AdministratorQueryDetailPresenterTests {

    @Mock
    private AdministratorQueryDetailContract.Model modelMock;

    @Mock
    private AdministratorQueryDetailContract.View viewMock;

    @Mock
    private AdministratorQueryDetailContract.Router routerMock;

    private AdministratorQueryDetailContract.Presenter presenter;

    @Before
    public void configureMockito(){
        MockitoAnnotations.initMocks(this);
    }

    private void configureAdministratorInboxScreen(AdministratorQueryDetailState state){

        presenter = new AdministratorQueryDetailPresenter(state);

        presenter.injectView(new WeakReference<AdministratorQueryDetailContract.View>(viewMock));
        presenter.injectModel(modelMock);
        presenter.injectRouter(routerMock);
    }

    @Test
    public void onReplyButtonPressed(){
        //Given an initialized AdministratorQueryDetailPresenter
        //and a null state
        configureAdministratorInboxScreen(new AdministratorQueryDetailState());

        //When reply menu button is pressed
        presenter.navigateToAdministratorQueryAnswerScreen();

        //Then router navigates up to QueryAnswerScreen
        verify(routerMock,times(1)).navigateToAdministratorQueryAnswerScreen();
    }
}
