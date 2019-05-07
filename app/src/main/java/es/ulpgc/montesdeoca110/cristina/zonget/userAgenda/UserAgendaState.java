package es.ulpgc.montesdeoca110.cristina.zonget.userAgenda;

public class UserAgendaState extends UserAgendaViewModel {

  public String selectedDate;
  public long calendarDate;

  public void setCalendarDate(long calendarDate) {
    this.calendarDate = calendarDate;
  }

  public void setSelectedDate(String selectedDate) {
    this.selectedDate = selectedDate;
  }

}
