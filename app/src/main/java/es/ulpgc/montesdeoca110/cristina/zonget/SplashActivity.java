package es.ulpgc.montesdeoca110.cristina.zonget;

import android.os.Bundle;
import android.os.Handler;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;

import es.ulpgc.montesdeoca110.cristina.zonget.signIn.SignInActivity;

public class SplashActivity extends AppCompatActivity {

    private Handler mWaitHandler = new Handler();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //Mensaje de Cris: Cambie el tema y ahora no te hace falta esto por eso te lo comente
        // Oculta la barra del título
        /*requestWindowFeature(Window.FEATURE_NO_TITLE);
        getSupportActionBar().hide();
        */
        setContentView(R.layout.activity_splash);

        mWaitHandler.postDelayed(new Runnable() {

            @Override
            public void run() {
                try {
                    //Siguiente activity
                    Intent intent = new Intent(getApplicationContext(), SignInActivity.class);
                    startActivity(intent);

                    //Let's Finish Splash Activity since we don't want to show this when user press back button.
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

        //Remove all the callbacks otherwise navigation will execute even after activity is killed or closed.
        mWaitHandler.removeCallbacksAndMessages(null);
    }

}
