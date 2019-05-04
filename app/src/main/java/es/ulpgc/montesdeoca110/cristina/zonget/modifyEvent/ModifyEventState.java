package es.ulpgc.montesdeoca110.cristina.zonget.modifyEvent;

import java.util.Calendar;

public class ModifyEventState extends ModifyEventViewModel {

    int spinnerSelection;
    public Calendar calendar;

    public void setSpinnerSelection(int spinnerSelection) {
        this.spinnerSelection = spinnerSelection;
    }
}
