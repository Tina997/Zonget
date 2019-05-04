package es.ulpgc.montesdeoca110.cristina.zonget;

import android.support.v4.app.FragmentActivity;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;

import java.lang.ref.WeakReference;

import es.ulpgc.montesdeoca110.cristina.zonget.data.RepositoryContract;
import es.ulpgc.montesdeoca110.cristina.zonget.signIn.SignInContract;
import es.ulpgc.montesdeoca110.cristina.zonget.signIn.SignInModel;
import es.ulpgc.montesdeoca110.cristina.zonget.signIn.SignInPresenter;
import es.ulpgc.montesdeoca110.cristina.zonget.signIn.SignInState;
import es.ulpgc.motesdeoca110.cristina.zonget.data.AccountsRepository;

import static org.mockito.Mockito.never;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;


@RunWith(MockitoJUnitRunner.class)
public class SignInPresenterMockitoTests {


    @Captor
    private ArgumentCaptor<RepositoryContract.Accounts.GetCheckAccountExistCallback> callbackCaptor;

    @Mock
    private SignInContract.Model modelMock;

    @Mock
    private SignInContract.View viewMock;

    @Mock
    private SignInContract.Router routerMock;

    private SignInContract.Presenter presenter;

    @Before
    public void configureMockito() {
        MockitoAnnotations.initMocks(this);
    }

    private void configureSignInScreen(SignInState state){
        presenter =  new SignInPresenter(state);

        // TODO Problema debido a que no puedo asignar e repositorio al modelo
        // java.lang.ClassCastException: es.ulpgc.montesdeoca110.cristina.zonget.signIn.SignInContract$View$MockitoMock$1242759836 cannot be cast to android.support.v4.app.FragmentActivity


        WeakReference<FragmentActivity> context = new WeakReference<FragmentActivity>((FragmentActivity) viewMock);
        RepositoryContract.Accounts repository = AccountsRepository.getInstance(context.get());
        modelMock = new SignInModel(repository);

        presenter.injectView((WeakReference<SignInContract.View>) viewMock);
        presenter.injectModel(modelMock);
        presenter.injectRouter(routerMock);
    }

    @Test
    public void signInPressedWithoutData(){
        // Given an initialized SignInPresenter
        // and a null state
        configureSignInScreen(new SignInState());

        // When SignIn button is pressed
        presenter.signInButtonPressed("","");

    }

    @Test
    public void signUpButtonPressed(){
        // Given an initialized SignInPresenter
        // and a null state
        configureSignInScreen(new SignInState());

        // When SignUp button is pressed
        presenter.signUpButtonPressed();

        // Router navigate to SignUp
        verify(routerMock,times(1)).navigateToSignUpScreen();
    }

    @Test
    public void pickForADateButtonPressed(){
        // Given an initialized SignInPresenter
        // and a null state
        configureSignInScreen(new SignInState());

        // When PickForADate button is pressed
        presenter.signUpButtonPressed();

        // Router navigate to PickForADate
        verify(routerMock,times(1)).navigateToUserPickDateScreen();
    }

}
