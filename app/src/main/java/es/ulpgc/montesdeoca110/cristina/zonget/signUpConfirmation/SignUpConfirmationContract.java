package es.ulpgc.montesdeoca110.cristina.zonget.signUpConfirmation;

import android.content.Context;
import es.ulpgc.montesdeoca110.cristina.zonget.app.SignUpToSignUpConfirmationState;
import java.lang.ref.WeakReference;

interface SignUpConfirmationContract {

  interface View {

    void injectPresenter(Presenter presenter);

    void displaySignUpConfirmationData(SignUpConfirmationViewModel viewModel);

    void finish();

  }

  interface Presenter {

    void injectView(WeakReference<View> view);

    void injectModel(Model model);

    void injectRouter(Router router);

    String getActualThemeName();

    void backButtonPressed();

    void fetchSignUpConfirmationData(Context context);

  }

  interface Model {

    void fetchSignUpConfirmationData();

    String getMessage(String accountName, String accountDni);
  }

  interface Router {

    void setSignUpConfirmationState(SignUpConfirmationState state);

    //------------------------- Tema ---------------------

    String getActualThemeName();

    //--------------- Navegación entre pantallas -----------

    void navigateToSignInScreen();

    //------------- Paso de datos entre pantallas ----------

    void passDataSignInScreen(SignUpConfirmationState state);

    //------------- Obtener datos entre pantallas ----------

    SignUpToSignUpConfirmationState getDataSignUpScreen();
  }
}
