package es.ulpgc.montesdeoca110.cristina.zonget.signUpConfirmation;

import android.content.Context;
import android.content.Intent;

import es.ulpgc.montesdeoca110.cristina.zonget.app.AppMediator;
import es.ulpgc.montesdeoca110.cristina.zonget.app.statesBetweenActivities.SignUpToSignUpConfirmationState;
import es.ulpgc.montesdeoca110.cristina.zonget.signIn.SignInActivity;


public class SignUpConfirmationRouter implements SignUpConfirmationContract.Router {

  private final AppMediator mediator;

  public SignUpConfirmationRouter(AppMediator mediator) {
    this.mediator = mediator;
  }

  @Override
  public void setSignUpConfirmationState(SignUpConfirmationState state) {

  }

  @Override
  public String getActualThemeName() {
    return mediator.getactualThemeName();
  }

  @Override
  public void navigateToSignInScreen() {
    Context context = mediator.getApplicationContext();
    Intent intent = new Intent(context, SignInActivity.class);
    intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
    context.startActivity(intent);
  }

  @Override
  public void passDataSignInScreen(SignUpConfirmationState state) {

  }

  @Override
  public SignUpToSignUpConfirmationState getDataSignUpScreen() {
    return mediator.getSignUpToSignUpConfirmationState();
  }
}
