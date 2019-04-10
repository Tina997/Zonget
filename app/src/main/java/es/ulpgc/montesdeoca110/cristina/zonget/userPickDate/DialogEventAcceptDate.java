package es.ulpgc.montesdeoca110.cristina.zonget.userPickDate;

import android.annotation.SuppressLint;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.support.v7.app.AlertDialog;
import android.view.Gravity;
import android.view.View;
import android.widget.TextView;

import es.ulpgc.montesdeoca110.cristina.zonget.R;

@SuppressLint("ValidFragment")
public class DialogEventAcceptDate extends DialogFragment {
    String day, hour;
    private AlertDialog.Builder builder;

    public DialogEventAcceptDate(String date, String hours){
        hour = hours;
        day = date;
    }
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        AlertDialog.Builder builder =
                new AlertDialog.Builder(getActivity(), R.style.DialogTheme);

        builder.setMessage("¿Desea cita el día "+day+" a las "+hour+"?")
                .setPositiveButton(R.string.accept_button, new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        //TODO añadir reserva de cita
                        dialog.cancel();
                    }
                })
                .setNegativeButton(R.string.cancel_button, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.cancel();
                    }
                });

        return builder.create();
    }
}
