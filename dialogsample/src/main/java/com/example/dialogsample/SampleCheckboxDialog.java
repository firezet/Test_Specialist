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

public class SampleCheckboxDialog extends DialogFragment {

    Context mContext;
    int[] mSelected;
    StringBuilder sb = new StringBuilder (23);

    public void setContext (Context context) {
        mContext = context;
    }

    @Override
    public Dialog onCreateDialog (Bundle savedInstanceState) {

        final String[] CHOICE = {"cheese", "potato", "beacon", "pizza",};
        mSelected = new int[CHOICE.length];

        AlertDialog.Builder builder = new AlertDialog.Builder (getActivity ());

        builder.setTitle ("Choose product")
                .setIcon (R.drawable.tapas)
                .setMultiChoiceItems (CHOICE, null, new DialogInterface.OnMultiChoiceClickListener () {
                    @Override
                    public void onClick (DialogInterface dialog, int which, boolean isChecked) {
                        switch ( which ) {
                            case 0:
                                mSelected[0] = ( isChecked ) ? 1 : 0;
                                break;
                            case 1:
                                mSelected[1] = ( isChecked ) ? 1 : 0;
                                break;
                            case 2:
                                mSelected[2] = ( isChecked ) ? 1 : 0;
                                break;
                            case 3:
                                mSelected[3] = ( isChecked ) ? 1 : 0;
                                break;
                        }
                    }
                })
                .setPositiveButton ("Accept", new DialogInterface.OnClickListener () {
                    @Override
                    public void onClick (DialogInterface dialog, int which) {
                        Toast.makeText (mContext, "Accepted", Toast.LENGTH_SHORT).show ();
                        for ( int i = 0; i < CHOICE.length; i++ ) {
                            if ( mSelected[i] != 0 ) {
                                sb.append (CHOICE[i]);
                                sb.append (" ");
                            }
                        }
                        if ( sb.length () > 0 ) {
                            Toast.makeText (mContext, sb.toString ().trim (), Toast.LENGTH_SHORT).show ();
                        }
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
