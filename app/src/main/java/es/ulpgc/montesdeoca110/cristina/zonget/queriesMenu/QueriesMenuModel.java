package es.ulpgc.montesdeoca110.cristina.zonget.queriesMenu;

import android.util.Log;

import java.lang.ref.WeakReference;

import android.support.v7.app.AppCompatActivity;
import android.support.v4.app.FragmentActivity;

public class QueriesMenuModel implements QueriesMenuContract.Model {

    public static String TAG = QueriesMenuModel.class.getSimpleName();

    public QueriesMenuModel() {

    }

    @Override
    public String fetchData() {
        // Log.e(TAG, "fetchInboxData()");
        return "Hello";
    }
}
