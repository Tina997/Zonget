package es.ulpgc.montesdeoca110.cristina.zonget;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;

import java.lang.ref.WeakReference;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import es.ulpgc.montesdeoca110.cristina.zonget.administratorAgenda.AdministratorAgendaContract;
import es.ulpgc.montesdeoca110.cristina.zonget.administratorAgenda.AdministratorAgendaPresenter;
import es.ulpgc.montesdeoca110.cristina.zonget.administratorAgenda.AdministratorAgendaState;
import es.ulpgc.montesdeoca110.cristina.zonget.app.EventItem;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class AdministratorAgendaPresenterTests {

  private static final List<EventItem> eventItemList = new ArrayList<>();

  @Mock
  private AdministratorAgendaContract.Model modelMock;

  @Mock
  private AdministratorAgendaContract.View viewMock;

  @Mock
  private AdministratorAgendaContract.Router routerMock;

  private AdministratorAgendaContract.Presenter presenter;

  @Before
  public void configureMockito() {
    MockitoAnnotations.initMocks(this);
  }

  private void configureAdministratorAgendaScreen(AdministratorAgendaState state) {

    presenter = new AdministratorAgendaPresenter(state);

    presenter.injectView(new WeakReference<AdministratorAgendaContract.View>(viewMock));
    presenter.injectModel(modelMock);
    presenter.injectRouter(routerMock);
  }

  /**
   * No funciona -> revisar test
   *
   * @Test public void fetchCalendarDataWithNullState(){
   * //Given an initialized AdministratorAgendaPresenter
   * //and a null AdministratorAgendaState
   * //and a new empty state in generated
   * configureAdministratorAgendaScreen(new AdministratorAgendaState());
   * when(routerMock.getDataFromPreviousScreen()).thenReturn(null);
   * <p>
   * AdministratorAgendaState viewModel = new AdministratorAgendaState();
   * viewModel.calendarDate = System.currentTimeMillis();
   * viewModel.selectedDate = new SimpleDateFormat("dd/MM/yyyy").format(new Date(System.currentTimeMillis()));
   * <p>
   * for(int i = 0; i <10; i++){
   * eventItemList.add(new EventItem("Cita " + i, i));
   * }
   * <p>
   * viewModel.eventList = eventItemList;
   * <p>
   * //When loading data is requested
   * presenter.fetchAdministratorAgendaData();
   * <p>
   * //Then
   * verify(viewMock).displayData(viewModel);
   * <p>
   * }
   **/

  @Test
  public void fetchCalendarDataWithNullStateCallsTheModel() {
    //Given an initialized AdministratorAgendaPresenter
    //and a null AdministratorAgendaState
    //and a new empty state in generated
    configureAdministratorAgendaScreen(new AdministratorAgendaState());
    when(routerMock.getDataFromPreviousScreen()).thenReturn(null);

    AdministratorAgendaState viewModel = new AdministratorAgendaState();


    //When loading data is requested
    presenter.fetchAdministratorAgendaData();

    //Then model is called
    verify(modelMock, times(1)).fetchData();
    verify(modelMock, times(1)).fetchDateData();

  }

  @Test
  public void onAddEventButtonPressed() {
    //Given an initialized AdministratorAgendaPresenter
    //and a null AdministratorAgendaState
    configureAdministratorAgendaScreen(new AdministratorAgendaState());

    //When AddEvent button is pressed
    presenter.gotToAddEvent();

    //Then router navigates to AddEvent
    verify(routerMock, times(1)).navigateToAddEventScreen();
  }

  @Test
  public void onModifyEventPressed() {
    //Given an initialized AdministratorAgendaPresenter
    //and a null AdministratorAgendaState
    configureAdministratorAgendaScreen(new AdministratorAgendaState());

    //When AddEvent button is pressed
    presenter.navigateToModifyEventScreen();

    //Then router navigates to AddEvent
    verify(routerMock, times(1)).navigateToModifyEventScreen();
  }


}
