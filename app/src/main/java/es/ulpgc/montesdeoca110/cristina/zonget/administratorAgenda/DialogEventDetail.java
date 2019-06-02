package es.ulpgc.montesdeoca110.cristina.zonget.administratorAgenda;

import android.annotation.SuppressLint;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AlertDialog;
import android.view.LayoutInflater;

import es.ulpgc.montesdeoca110.cristina.zonget.R;

@SuppressLint("ValidFragment")
public class DialogEventDetail extends DialogFragment {

  private final AdministratorAgendaContract.View view;

  public DialogEventDetail(AdministratorAgendaContract.View view) {
    this.view = view;
  }

  @Override
  public Dialog onCreateDialog(Bundle savedInstanceState) {

    AlertDialog.Builder builder =
            new AlertDialog.Builder(getActivity(), R.style.DialogTheme);
    LayoutInflater layoutInflater = getActivity().getLayoutInflater();

    builder.setView(layoutInflater
            .inflate(R.layout.administrator_agenda_event_details_dialog, null));

    builder.setNeutralButton(R.string.modify_button, new DialogInterface.OnClickListener() {
      public void onClick(DialogInterface dialog, int id) {
        view.onModifyButtonClicked();
      }
    })
            .setNegativeButton(R.string.eliminate_button, new DialogInterface.OnClickListener() {
              @Override
              public void onClick(DialogInterface dialog, int which) {
                FragmentManager fragmentManager = getFragmentManager();
                DialogEventDelete dialogo = new DialogEventDelete();
                dialogo.show(fragmentManager, "Alerta");
              }
            });

    setRetainInstance(true);
    return builder.create();
  }
}

