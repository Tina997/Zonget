package es.ulpgc.montesdeoca110.cristina.zonget.administratorSearchUsers;

public class AdministratorSearchUsersModel implements AdministratorSearchUsersContract.Model {

    public static String TAG = AdministratorSearchUsersModel.class.getSimpleName();

    public AdministratorSearchUsersModel() {

    }

    @Override
    public String fetchData() {
        // Log.e(TAG, "fetchData()");
        return "Hello";
    }
}
