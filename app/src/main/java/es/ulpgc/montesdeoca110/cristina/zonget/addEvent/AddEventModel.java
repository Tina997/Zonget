package es.ulpgc.montesdeoca110.cristina.zonget.addEvent;

import java.util.Calendar;

public class AddEventModel implements AddEventContract.Model {

  public static String TAG = AddEventModel.class.getSimpleName();

  public AddEventModel() {

  }

  @Override
  public String fetchData() {
    return null;
  }

  @Override
  public Calendar fetchCalendar() {
    return Calendar.getInstance();
  }

}
