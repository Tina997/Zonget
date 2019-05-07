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

import es.ulpgc.montesdeoca110.cristina.zonget.app.AccountItem;
import es.ulpgc.montesdeoca110.cristina.zonget.app.UserPetItem;
import es.ulpgc.montesdeoca110.cristina.zonget.data.RepositoryContract;
import es.ulpgc.montesdeoca110.cristina.zonget.userPets.UserPetsContract;
import es.ulpgc.montesdeoca110.cristina.zonget.userPets.UserPetsModel;
import es.ulpgc.montesdeoca110.cristina.zonget.userPets.UserPetsPresenter;
import es.ulpgc.montesdeoca110.cristina.zonget.userPets.UserPetsState;
import es.ulpgc.motesdeoca110.cristina.zonget.data.AccountsRepository;

import static org.mockito.ArgumentMatchers.refEq;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class UserPetsPresenterTests {

  private static final AccountItem accountItem = new AccountItem(1,
          "tipo", "nombre", "dni", "email", "password");

  private static final UserPetItem item = new UserPetItem(0,
          "Nombre", "Especie", "Raza",
          "Chip", "Fecha");

  @Captor
  private ArgumentCaptor<RepositoryContract.Accounts.GetUserPetsListCallback> callbackCaptor;

  @Mock
  private UserPetsContract.Model modelMock;

  @Mock
  private UserPetsContract.View viewMock;

  @Mock
  private UserPetsContract.Router routerMock;

  private UserPetsContract.Presenter presenter;

  @Before
  public void configureMockito(){
    MockitoAnnotations.initMocks(this);
  }

  private void configureUserPetsScreen(UserPetsState state){

    presenter = new UserPetsPresenter(state);

    presenter.injectView(new WeakReference<>(viewMock));

    AccountsRepository accountsRepository = mock(AccountsRepository.class);
    presenter.injectModel(new UserPetsModel(accountsRepository));

    presenter.injectRouter(routerMock);

  }

  @Test
  public void onUserPetsListItemSelected(){
    //Given an initialized UserPetsPresenter
    //and a null UserPetsState
    //and a new UsersPetItem is created
    configureUserPetsScreen(new UserPetsState());

    //When an item is selected
    presenter.selectUserPetsData(item);

    //Then router is called
    verify(routerMock, times(1)).passDataToPetsDetailScreen(item);
    verify(routerMock, times(1)).navigateToPetsDetailScreen();
  }

}
