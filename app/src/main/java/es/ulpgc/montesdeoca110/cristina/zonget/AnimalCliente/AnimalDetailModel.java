package es.ulpgc.montesdeoca110.cristina.zonget.AnimalCliente;

public class AnimalDetailModel implements AnimalDetailContract.Model {

    public static String TAG = AnimalDetailModel.class.getSimpleName();

    public AnimalDetailModel() {

    }

    @Override
    public String fetchData() {
        // Log.e(TAG, "fetchDateListData()");
        return "Hello";
    }
}
