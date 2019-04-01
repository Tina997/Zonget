package es.ulpgc.montesdeoca110.cristina.zonget.userNewQuery;

public class UserNewQueryModel implements UserNewQueryContract.Model {

    public static String TAG = UserNewQueryModel.class.getSimpleName();

    public UserNewQueryModel() {

    }

    @Override
    public String fetchData() {
        // Log.e(TAG, "fetchPetsForAdoptionListData()");
        return "Hello";
    }
}
