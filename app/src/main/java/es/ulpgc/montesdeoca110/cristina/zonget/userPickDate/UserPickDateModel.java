package es.ulpgc.montesdeoca110.cristina.zonget.userPickDate;

import android.util.Log;

import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;

import android.support.v7.app.AppCompatActivity;
import android.support.v4.app.FragmentActivity;

import es.ulpgc.montesdeoca110.cristina.zonget.app.EventItem;
import es.ulpgc.montesdeoca110.cristina.zonget.app.HourItem;

public class UserPickDateModel implements UserPickDateContract.Model {

    public static String TAG = UserPickDateModel.class.getSimpleName();
    private final List<HourItem> hourItems = new ArrayList<>();
    private final int COUNT = 10;

    public UserPickDateModel() {
        for (int index = 1; index <= COUNT; index++) {
            addDate(createDate(index));
        }

    }

    @Override
    public List<HourItem> fetchData() {
        // Log.e(TAG, "fetchDateListData()");
        return hourItems;
    }

    private void addDate(HourItem item) {
        hourItems.add(item);
    }

    private HourItem createDate(int position) {
        String content = "Hora " + position;
        return new HourItem(content, position);
    }

    @Override
    public long fetchDateData(){
        long time = System.currentTimeMillis();
        return time;
    }
}
