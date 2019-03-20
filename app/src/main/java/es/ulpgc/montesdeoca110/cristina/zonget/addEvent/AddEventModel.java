package es.ulpgc.montesdeoca110.cristina.zonget.addEvent;

public class AddEventModel implements AddEventContract.Model {

    public static String TAG = AddEventModel.class.getSimpleName();

    public AddEventModel() {

    }

    @Override
    public String fetchData() {
        // Log.e(TAG, "fetchDateListData()");
        return "Hello";
    }
}
