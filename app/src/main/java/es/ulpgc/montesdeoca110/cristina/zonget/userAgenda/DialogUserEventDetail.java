package es.ulpgc.montesdeoca110.cristina.zonget.userAgenda;

import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.support.v7.app.AlertDialog;
import android.view.LayoutInflater;

import es.ulpgc.montesdeoca110.cristina.zonget.R;


public class DialogUserEventDetail extends DialogFragment {


  public DialogUserEventDetail() {
  }

  @Override
  public Dialog onCreateDialog(Bundle savedInstanceState) {


    AlertDialog.Builder builder =
            new AlertDialog.Builder(getActivity(), R.style.DialogTheme);
    LayoutInflater layoutInflater = getActivity().getLayoutInflater();

    builder.setView(layoutInflater.inflate(R.layout.user_agenda_event_details_dialog, null));

    builder.setPositiveButton(R.string.accept_button, new DialogInterface.OnClickListener() {
      @Override
      public void onClick(DialogInterface dialog, int which) {
        dialog.dismiss();
      }
    });

    return builder.create();
  }
}

