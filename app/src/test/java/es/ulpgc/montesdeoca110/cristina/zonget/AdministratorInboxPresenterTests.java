package es.ulpgc.montesdeoca110.cristina.zonget;


import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;

import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;

import es.ulpgc.montesdeoca110.cristina.zonget.administratorInbox.AdministratorInboxContract;
import es.ulpgc.montesdeoca110.cristina.zonget.administratorInbox.AdministratorInboxPresenter;
import es.ulpgc.montesdeoca110.cristina.zonget.administratorInbox.AdministratorInboxState;
import es.ulpgc.montesdeoca110.cristina.zonget.app.QueryItem;

import static org.mockito.Mockito.never;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class AdministratorInboxPresenterTests {

    private static final List<QueryItem> queryItemList = new ArrayList<>();

    @Mock
    private AdministratorInboxContract.Model modelMock;

    @Mock
    private AdministratorInboxContract.View viewMock;

    @Mock
    private AdministratorInboxContract.Router routerMock;

    private AdministratorInboxContract.Presenter presenter;

    @Before
    public void configureMockito(){
        MockitoAnnotations.initMocks(this);
    }

    private void configureAdministratorInboxScreen(AdministratorInboxState state){

        presenter = new AdministratorInboxPresenter(state);

        presenter.injectView(new WeakReference<AdministratorInboxContract.View>(viewMock));
        presenter.injectModel(modelMock);
        presenter.injectRouter(routerMock);
    }


    @Test
    public void fetchInboxListDataWithNullStateCallsTheModel(){
        //Given an initialized AdministratorInboxPresenter
        //and a null state
        configureAdministratorInboxScreen(new AdministratorInboxState());

        //When loading data is requested
        presenter.fetchInboxData();

        //Then model is called
        verify(modelMock, times(1)).fetchData();
    }

    @Test
    public void navigateToQueryDetailScreem(){
        //Given an initialized AdministratorInboxPresenter
        //and a null state
        configureAdministratorInboxScreen(new AdministratorInboxState());

        //When an item is selected
        presenter.goToAdministratorQueryDetailScreen();

        //Then router navigates to QueryDetailScreen
        verify(routerMock, times(1)).navigateToAdministratorQueryDetailScreen();
    }




}
