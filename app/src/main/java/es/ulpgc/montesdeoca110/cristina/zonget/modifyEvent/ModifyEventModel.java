package es.ulpgc.montesdeoca110.cristina.zonget.modifyEvent;

import java.util.Calendar;

public class ModifyEventModel implements ModifyEventContract.Model {

    public static String TAG = ModifyEventModel.class.getSimpleName();

    public ModifyEventModel() {

    }

    @Override
    public String fetchData() {
        return null;
    }

    @Override
    public Calendar fetchCalendar(){
        Calendar calendar = Calendar.getInstance();
        return calendar;
    }
}
