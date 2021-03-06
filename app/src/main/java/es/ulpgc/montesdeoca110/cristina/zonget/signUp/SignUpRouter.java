package es.ulpgc.montesdeoca110.cristina.zonget.signUp;

import android.content.Context;
import android.content.Intent;

import es.ulpgc.montesdeoca110.cristina.zonget.app.AppMediator;
import es.ulpgc.montesdeoca110.cristina.zonget.app.statesBetweenActivities.SignUpToSignUpConfirmationState;
import es.ulpgc.montesdeoca110.cristina.zonget.signIn.SignInActivity;
import es.ulpgc.montesdeoca110.cristina.zonget.signUpConfirmation.SignUpConfirmationActivity;


public class SignUpRouter implements SignUpContract.Router {

  private final AppMediator mediator;

  public SignUpRouter(AppMediator mediator) {
    this.mediator = mediator;
  }

  @Override
  public void setSignUpState(SignUpState state) {
    mediator.setSignUpState(state);
  }

  @Override
  public String getActualThemeName() {
    return mediator.getactualThemeName();
  }

  @Override
  public void navigateToSinInScreen() {
    Context context = mediator.getApplicationContext();
    Intent intent = new Intent(context, SignInActivity.class);
    intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
    context.startActivity(intent);
  }


  @Override
  public void navigateToSignUpConfirmationScreen() {
    Context context = mediator.getApplicationContext();
    Intent intent = new Intent(context, SignUpConfirmationActivity.class);
    intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
    context.startActivity(intent);
  }

  @Override
  public void passDataSignUpConfirmationScreen(SignUpToSignUpConfirmationState state) {
    mediator.setSignUpToSignUpConfirmationState(state);
  }
}
