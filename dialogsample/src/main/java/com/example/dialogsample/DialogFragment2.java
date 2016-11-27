package com.example.dialogsample;

import android.app.Activity;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.support.v7.app.AlertDialog;
import android.widget.Toast;

/**
 * Created by Maksym Galushka on 14.11.2016.
 */
public class DialogFragment2 extends DialogFragment {

    int mIdx;

    @Override
    public Dialog onCreateDialog (Bundle savedInstanceState) {


        AlertDialog.Builder builder = new AlertDialog.Builder (getActivity ());

        builder.setTitle (getString (R.string.title_dialog1))
                .setSingleChoiceItems (MainActivity.ENGINE_NAMES, -1, new DialogInterface.OnClickListener () {
                    @Override
                    public void onClick (DialogInterface dialog, int which) {
                        mIdx = which;
                    }
                })
                .setPositiveButton ("Select", new DialogInterface.OnClickListener () {
                    @Override
                    public void onClick (DialogInterface dialog, int which) {
                        Activity a = getActivity ();
                        if ( a instanceof BrowserCall ) {
                            ( (BrowserCall) a ).callBrowser (mIdx);
                        } else {
                            Toast.makeText (a, "Sorry, unable to call browser",
                                    Toast.LENGTH_SHORT).show ();
                        }
                    }
                })
                .setNegativeButton ("Not now", new DialogInterface.OnClickListener () {
                    @Override
                    public void onClick (DialogInterface dialog, int which) {

                    }
                });

        return builder.create ();
    }

}
