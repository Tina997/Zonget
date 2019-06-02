package es.ulpgc.montesdeoca110.cristina.zonget;

import android.content.Intent;
import android.os.Bundle;

import android.os.Handler;
import android.support.v7.app.AppCompatActivity;

import es.ulpgc.montesdeoca110.cristina.zonget.signIn.SignInActivity;

public class SplashActivity extends AppCompatActivity {

  private final Handler mWaitHandler = new Handler();

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);

    setContentView(R.layout.activity_splash);

    mWaitHandler.postDelayed(new Runnable() {

      @Override
      public void run() {
        try {
          //Siguiente activity
          Intent intent = new Intent(getApplicationContext(), SignInActivity.class);
          startActivity(intent);

          //Let's Finish Splash Activity since we don't want to
          // show this when user press back button.
          finish();
        } catch (Exception ignored) {
          ignored.printStackTrace();
        }
      }
    }, 3000);
  }

  @Override
  public void onDestroy() {
    super.onDestroy();

    //Remove all the callbacks otherwise navigation will execute
    // even after activity is killed or closed.
    mWaitHandler.removeCallbacksAndMessages(null);
  }

}
