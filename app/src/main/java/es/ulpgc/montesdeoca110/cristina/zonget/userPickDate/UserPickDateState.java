package es.ulpgc.montesdeoca110.cristina.zonget.userPickDate;

public class UserPickDateState extends UserPickDateViewModel {

  public String selectedDate;
  public long calendarDate;

  public void setCalendarDate(long calendarDate) {
    this.calendarDate = calendarDate;
  }

  public void setSelectedDate(String selectedDate) {
    this.selectedDate = selectedDate;
  }
}
