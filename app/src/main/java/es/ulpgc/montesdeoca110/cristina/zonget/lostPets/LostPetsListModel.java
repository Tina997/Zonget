package es.ulpgc.montesdeoca110.cristina.zonget.lostPets;

public class LostPetsListModel implements LostPetsListContract.Model {

    public static String TAG = LostPetsListModel.class.getSimpleName();

    public LostPetsListModel() {

    }

    @Override
    public String fetchData() {
        // Log.e(TAG, "fetchData()");
        return "Hello";
    }
}
