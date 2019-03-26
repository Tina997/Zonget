package es.ulpgc.montesdeoca110.cristina.zonget.userPetsDetail;

public class UserPetsDetailModel implements UserPetsDetailContract.Model {

    public static String TAG = UserPetsDetailModel.class.getSimpleName();

    public UserPetsDetailModel() {

    }

    @Override
    public String fetchData() {
        // Log.e(TAG, "fetchInboxData()");
        return "Hello";
    }
}
