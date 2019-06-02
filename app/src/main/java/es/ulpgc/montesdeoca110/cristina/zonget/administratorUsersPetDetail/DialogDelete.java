package es.ulpgc.montesdeoca110.cristina.zonget.administratorUsersPetDetail;

import android.annotation.SuppressLint;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.support.v7.app.AlertDialog;

import es.ulpgc.montesdeoca110.cristina.zonget.R;


@SuppressLint("ValidFragment")
public class DialogDelete extends DialogFragment {
  private AdministratorUserPetsDetailContract.View view;

  public DialogDelete(AdministratorUserPetsDetailContract.View view) {
    this.view = view;
  }

  @Override
  public Dialog onCreateDialog(Bundle savedInstanceState) {

    AlertDialog.Builder builder =
            new AlertDialog.Builder(getActivity(), R.style.DialogTheme);

    builder.setMessage(R.string.sureToEliminatePet)
            .setPositiveButton(R.string.accept_button, new DialogInterface.OnClickListener() {
              public void onClick(DialogInterface dialog, int id) {
                //dialog.cancel();
                view.onDeleteButtonClicked();
              }
            })
            .setNegativeButton(R.string.cancel_button, new DialogInterface.OnClickListener() {
              @Override
              public void onClick(DialogInterface dialog, int which) {

              }
            });

    setRetainInstance(true);
    return builder.create();
  }
}

