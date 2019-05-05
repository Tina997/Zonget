package es.ulpgc.montesdeoca110.cristina.zonget;

import android.support.v4.app.FragmentActivity;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;

import java.lang.ref.WeakReference;

import es.ulpgc.montesdeoca110.cristina.zonget.data.PetsForAdoptionRepository;
import es.ulpgc.montesdeoca110.cristina.zonget.data.RepositoryContract;
import es.ulpgc.montesdeoca110.cristina.zonget.petsForAdoption.PetsForAdoptionContract;
import es.ulpgc.montesdeoca110.cristina.zonget.petsForAdoption.PetsForAdoptionModel;
import es.ulpgc.montesdeoca110.cristina.zonget.petsForAdoption.PetsForAdoptionPresenter;
import es.ulpgc.montesdeoca110.cristina.zonget.petsForAdoption.PetsForAdoptionState;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

@RunWith(MockitoJUnitRunner.class)
public class PetsForAdoptionPresenterTests {

    @Mock
    private PetsForAdoptionContract.Model modelMock;

    @Mock
    private PetsForAdoptionContract.View viewMock;

    @Mock
    private PetsForAdoptionContract.Router routerMock;

    private PetsForAdoptionContract.Presenter presenter;

    @Before
    public void configureMockito() {
        MockitoAnnotations.initMocks(this);
    }

    public void configurePetsForAdoptionScreen(PetsForAdoptionState state){

        presenter = new PetsForAdoptionPresenter(state);

        WeakReference<FragmentActivity> context = new WeakReference<>(new FragmentActivity());
        RepositoryContract.PetsForAdoption repository = PetsForAdoptionRepository.getInstance(context.get());
        modelMock = new PetsForAdoptionModel(repository);

        presenter.injectView(new WeakReference<>(viewMock));
        presenter.injectModel(modelMock);
        presenter.injectRouter(routerMock);

    }

    @Test
    public void onAddPetForAdoptionButtonPressed(){
        // Given an initialized PetsFrAdoptionPresenter
        // and a null state
        configurePetsForAdoptionScreen(new PetsForAdoptionState());

        //When addPetForAdoption button is pressed
        presenter.gotToAddPetForAdoption();

        //Then router navugates up to AddPetForAdoption screen
        verify(routerMock,times(1)).navigateToAddPetForAdoptionScreen();
    }
}
