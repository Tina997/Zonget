package es.ulpgc.montesdeoca110.cristina.zonget.ButtonsAdministratorMenu;

public class ButtonsAdministratorMenuModel implements ButtonsAdministratorMenuContract.Model {

    public static String TAG = ButtonsAdministratorMenuModel.class.getSimpleName();

    public ButtonsAdministratorMenuModel() {

    }

    @Override
    public String fetchData() {
        // Log.e(TAG, "fetchData()");
        return "Hello";
    }
}
