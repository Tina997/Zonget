package es.ulpgc.montesdeoca110.cristina.zonget;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;

import java.lang.ref.WeakReference;

import es.ulpgc.montesdeoca110.cristina.zonget.app.AccountItem;
import es.ulpgc.montesdeoca110.cristina.zonget.data.RepositoryContract;
import es.ulpgc.montesdeoca110.cristina.zonget.signIn.SignInContract;
import es.ulpgc.montesdeoca110.cristina.zonget.signIn.SignInModel;
import es.ulpgc.montesdeoca110.cristina.zonget.signIn.SignInPresenter;
import es.ulpgc.montesdeoca110.cristina.zonget.signIn.SignInState;

import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

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

    @Mock
    private RepositoryContract.Accounts repositoryMock;

    private SignInContract.Presenter presenter;

    @Before
    public void configureMockito() {
        MockitoAnnotations.initMocks(this);
    }

    private void configureSignInScreen(SignInState state){
        presenter =  new SignInPresenter(state);

        modelMock = Mockito.spy(new SignInModel(repositoryMock));

        presenter.injectView(new WeakReference<>(viewMock));
        presenter.injectModel(modelMock);
        presenter.injectRouter(routerMock);
    }

    @Test
    public void signUpWithoutData(){
        // Given an initialized SignInPresenter
        // and a null state
        configureSignInScreen(new SignInState());

        //Data is null
        String accountName = "";
        String accountPassword = "";

        // When SignUp button is pressed
        presenter.signInButtonPressed(accountName,accountPassword);

        // Callback is captured and invoked with false and null
        verify(modelMock).checkAccount(eq(accountName),eq(accountPassword),callbackCaptor.capture());
        callbackCaptor.getValue().setCheckAccountExist(false,null);
        verify(viewMock,never()).finish();
        verify(routerMock,never()).navigateToMenuScreen();

        //Then view show a toast
        verify(viewMock,times(1)).displayCheckAccountError();

    }

    @Test
    public void signUpWithData(){
        // Given an initialized SignInPresenter
        // and a null state
        configureSignInScreen(new SignInState());

        //Data is administrator data
        String accountName = "admin";
        String accountPassword = "admin";

        AccountItem adminAccount = new AccountItem(0,"administrator","admin","XXXXXXXXX","admin@zonget.com","admin");

        // When SignUp button is pressed
        presenter.signInButtonPressed(accountName,accountPassword);

        // Callback is captured and invoked with correct data
        verify(modelMock).checkAccount(eq(accountName),eq(accountPassword),callbackCaptor.capture());
        callbackCaptor.getValue().setCheckAccountExist(true,adminAccount);
        verify(viewMock,times(1)).finish();
        verify(routerMock,times(1)).navigateToMenuScreen();

        //Then view no show a toast
        verify(viewMock,never()).displayCheckAccountError();

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
