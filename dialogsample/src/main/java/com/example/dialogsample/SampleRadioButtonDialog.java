package com.example.dialogsample;

import android.app.AlertDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.widget.Toast;

/**
 * Created by Maksym Galushka on 14.11.2016.
 */

public class SampleRadioButtonDialog extends DialogFragment {

    Context mContext;
    private int selected = 0;


    public void setContext (Context context) {
        mContext = context;
    }

    @Override
    public Dialog onCreateDialog (Bundle savedInstanceState) {

        final String [] SOME = {"First", "Second", "Third",};


        AlertDialog.Builder builder = new AlertDialog.Builder (getActivity ());

        builder.setTitle ("Choose")
                .setSingleChoiceItems (SOME, -1, new DialogInterface.OnClickListener () {
                    @Override
                    public void onClick (DialogInterface dialog, int which) {
                        switch ( which ) {
                            case 0:
                                selected = which;
                                Toast.makeText (mContext, "First", Toast.LENGTH_SHORT).show ();
                                break;
                            case 1:
                                selected = which;
                                Toast.makeText (mContext, "Second", Toast.LENGTH_SHORT).show ();
                                break;
                            case 2:
                                selected = which;
                                Toast.makeText (mContext, "Third", Toast.LENGTH_SHORT).show ();
                                break;
                            default:
                                Toast.makeText (mContext, "NO NAME", Toast.LENGTH_SHORT).show ();
                        }
                    }
                })
                .setPositiveButton ("Accept", new DialogInterface.OnClickListener () {
                    @Override
                    public void onClick (DialogInterface dialog, int which) {
                        Toast.makeText (mContext, "Accepted " + SOME[selected],
                                Toast.LENGTH_LONG).show ();
                    }
                })
                .setNegativeButton ("Cancel", new DialogInterface.OnClickListener () {
                    @Override
                    public void onClick (DialogInterface dialog, int which) {
                        Toast.makeText (mContext, "Canceled", Toast.LENGTH_SHORT).show ();
                    }
                });

        return builder.create ();
    }

}
