package com.example.samplereceiver;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;



public class DialogFragment1 extends DialogFragment {

    @Override
    public Dialog onCreateDialog (Bundle savedInstanceState) {
        AlertDialog.Builder builder = new
                AlertDialog.Builder (getActivity ());

        builder.setTitle (getString(R.string.title_dialog1))
                .setItems (MainActivity.ENGINE_NAMES, new DialogInterface.OnClickListener () {
                    @Override
                    public void onClick (DialogInterface dialog, int idx) {
                        Intent intent = new Intent (MainActivity.ACTION_ENGINE_SELECTED);
                        intent.putExtra (MainActivity.KEY_IDX, idx);
                        getActivity ().sendBroadcast (intent);
                    }
                });
        return builder.create ();
    }
}
