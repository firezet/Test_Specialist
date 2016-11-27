package com.example.dialogsample;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.widget.Toast;

/**
 * Created by Maksym Galushka on 14.11.2016.
 */

public class DialogFragment1 extends DialogFragment {

    @Override
    public Dialog onCreateDialog (Bundle savedInstanceState) {
        AlertDialog.Builder builder = new
                AlertDialog.Builder (getActivity ());

        builder.setTitle (getString(R.string.title_dialog1))
                .setItems (MainActivity.ENGINE_NAMES, new DialogInterface.OnClickListener () {
                    @Override
                    public void onClick (DialogInterface dialog, int which) {
                        Activity a = getActivity ();
                        if ( a instanceof BrowserCall ) {
                            ( (BrowserCall) a ).callBrowser (which);
                        } else {
                            Toast.makeText (a, "Sorry, unable to call browser",
                                    Toast.LENGTH_SHORT).show ();
                        }
                    }
                });
        return builder.create ();
    }
}
