package es.ulpgc.montesdeoca110.cristina.zonget;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;

import java.lang.ref.WeakReference;

import es.ulpgc.montesdeoca110.cristina.zonget.administratorButtonsMenuList.AdministratorButtonsMenuListContract;
import es.ulpgc.montesdeoca110.cristina.zonget.administratorButtonsMenuList.AdministratorButtonsMenuListModel;
import es.ulpgc.montesdeoca110.cristina.zonget.administratorButtonsMenuList.AdministratorButtonsMenuListPresenter;
import es.ulpgc.montesdeoca110.cristina.zonget.administratorButtonsMenuList.AdministratorButtonsMenuListState;
import es.ulpgc.montesdeoca110.cristina.zonget.data.RepositoryContract;

import static org.mockito.Mockito.verify;

@RunWith(MockitoJUnitRunner.class)
public class AdministratorButtonsMenuListPresenterMockitoTest {

    @Captor
    private ArgumentCaptor<RepositoryContract.Settings.GetAdministratorMenuButtonsListCallback> callbackCaptorOne;

    @Captor
    private ArgumentCaptor<RepositoryContract.Settings.FecthZongetDataCallback> callbackCaptorTwo;

    @Mock
    private AdministratorButtonsMenuListContract.Model modelMock;

    @Mock
    private AdministratorButtonsMenuListContract.View viewMock;

    @Mock
    private AdministratorButtonsMenuListContract.Router routerMock;

    @Mock
    private RepositoryContract.Settings repositoryMock;

    private AdministratorButtonsMenuListContract.Presenter presenter;

    @Before
    public void configureMockito() {
        MockitoAnnotations.initMocks(this);
    }

    private void configureAdministratorButtonsMenuListScreen(AdministratorButtonsMenuListState state){
        presenter =  new AdministratorButtonsMenuListPresenter(state);

        modelMock = new AdministratorButtonsMenuListModel(repositoryMock);

        presenter.injectView(new WeakReference<>(viewMock));
        presenter.injectModel(modelMock);
        presenter.injectRouter(routerMock);
    }

    @Test
    public void fetchAdministratorButtonsMenuList(){
        // Given an initialized AdministratorButtonsMenuListPresenter
        // and a null state
        configureAdministratorButtonsMenuListScreen(new AdministratorButtonsMenuListState());

        // When
        presenter.fetchAdministratorButtonsMenuListData();

        // Then
        verify(modelMock).fetchAdministratorButtonsMenuListData(callbackCaptorOne);
        verify(repositoryMock).loadZonget(callbackCaptorTwo);

        //TODO continuar y buscar una solución al error (preguntar)
    }

}
