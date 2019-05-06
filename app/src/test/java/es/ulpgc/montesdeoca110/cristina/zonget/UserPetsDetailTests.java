package es.ulpgc.montesdeoca110.cristina.zonget;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;

import java.lang.ref.WeakReference;

import es.ulpgc.montesdeoca110.cristina.zonget.app.UserPetItem;
import es.ulpgc.montesdeoca110.cristina.zonget.userPets.UserPetsState;
import es.ulpgc.montesdeoca110.cristina.zonget.userPetsDetail.UserPetsDetailContract;
import es.ulpgc.montesdeoca110.cristina.zonget.userPetsDetail.UserPetsDetailModel;
import es.ulpgc.montesdeoca110.cristina.zonget.userPetsDetail.UserPetsDetailPresenter;
import es.ulpgc.montesdeoca110.cristina.zonget.userPetsDetail.UserPetsDetailState;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class UserPetsDetailTests {

  private static final UserPetItem notNullUserPetItem = new UserPetItem(0,
          "Nombre", "Especie", "Raza",
          "Chip", "Fecha");

  @Mock
  private UserPetsDetailContract.Model modelMock;

  @Mock
  private UserPetsDetailContract.View viewMock;

  @Mock
  private UserPetsDetailContract.Router routerMock;

  private UserPetsDetailContract.Presenter presenter;

  @Before
  public void configureMockito(){
    MockitoAnnotations.initMocks(this);
  }

  private void configureUserPetsDetailScreen(UserPetsDetailState state){

    presenter = new UserPetsDetailPresenter(state);

    presenter.injectView(new WeakReference<>(viewMock));

    presenter.injectModel(new UserPetsDetailModel());

    presenter.injectRouter(routerMock);

  }

  @Test
  public void fetchUserPetsDataWithNullState(){
    //Given an initialized UserPetsDetailPresenter
    //and a null UserPetsDetailState
    //and a new empty state in generated
    configureUserPetsDetailScreen(new UserPetsDetailState());
    when(routerMock.getDataFromPreviousScreen()).thenReturn(null);

    UserPetsDetailState viewModel = new UserPetsDetailState();
    viewModel.pet = null;

    //When loading data is requested
    presenter.fetchPetsData();

    //Then
    verify(viewMock).displayData(viewModel);
  }

  @Test
  public void fetchUserPetsDataWithNotNullState(){
    //Given an initialized UserPetsDetailPresenter
    //and a null UserPetsDetailState
    //and a not null passed state is generated
    configureUserPetsDetailScreen(new UserPetsDetailState());
    when(routerMock.getDataFromPreviousScreen()).thenReturn(notNullUserPetItem);

    UserPetsDetailState viewModel = new UserPetsDetailState();
    viewModel.pet = notNullUserPetItem;

    //When loading data is requested
    presenter.fetchPetsData();

    //Then
    verify(viewMock).displayData(viewModel);
  }
}
