package es.ulpgc.montesdeoca110.cristina.zonget.AdministratorButtonsMenuList;

public class AdministratorButtonsMenuListModel implements AdministratorMenuButtonsListContract.Model {

    public static String TAG = AdministratorButtonsMenuListModel.class.getSimpleName();

    public AdministratorButtonsMenuListModel() {

    }

    @Override
    public String fetchData() {
        // Log.e(TAG, "fetchData()");
        return "Hello";
    }
}
