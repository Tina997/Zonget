package es.ulpgc.montesdeoca110.cristina.zonget.userQueriesMenu;

public class UserQueriesMenuModel implements UserQueriesMenuContract.Model {

    public static String TAG = UserQueriesMenuModel.class.getSimpleName();

    public UserQueriesMenuModel() {

    }

    @Override
    public String fetchData() {
        // Log.e(TAG, "fetchInboxData()");
        return "Hello";
    }
}
