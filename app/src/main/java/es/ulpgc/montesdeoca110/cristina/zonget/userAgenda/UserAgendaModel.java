package es.ulpgc.montesdeoca110.cristina.zonget.userAgenda;

public class UserAgendaModel implements UserAgendaContract.Model {

    public static String TAG = UserAgendaModel.class.getSimpleName();

    public UserAgendaModel() {

    }

    @Override
    public String fetchData() {
        // Log.e(TAG, "fetchPetsForAdoptionListData()");
        return "Hello";
    }
}
