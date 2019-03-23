package es.ulpgc.montesdeoca110.cristina.zonget.modifyEvent;

public class ModifyEventModel implements ModifyEventContract.Model {

    public static String TAG = ModifyEventModel.class.getSimpleName();

    public ModifyEventModel() {

    }

    @Override
    public String fetchData() {
        // Log.e(TAG, "fetchDateListData()");
        return "Hello";
    }
}
