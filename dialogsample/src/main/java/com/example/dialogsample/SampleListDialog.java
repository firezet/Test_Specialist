package com.example.dialogsample;

import android.app.AlertDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.widget.Toast;

/**
 * Created by Maksym Galushka on 13.11.2016.
 */

public class SampleListDialog extends DialogFragment {

    private Context mContext;

    public void setContext (Context c) {
        mContext = c;
    }

    final static CharSequence[] COLORS = {"Red", "Green", "Blue",};

    @Override
    public Dialog onCreateDialog (Bundle savedInstanceState) {
        AlertDialog.Builder builder = new
                AlertDialog.Builder (getActivity ());

        builder.setTitle ("Turn on traffic lights")
                .setItems (COLORS, new DialogInterface.OnClickListener () {
                    @Override
                    public void onClick (DialogInterface dialog, int which) {

                        switch ( which ) {
                            case 0:
                                Toast.makeText (mContext, "Red is on", Toast.LENGTH_SHORT).show ();
                                break;
                            case 1:
                                Toast.makeText (mContext, "Green is on", Toast.LENGTH_SHORT).show ();
                                break;
                            case 2:
                                Toast.makeText (mContext, "Blue is on", Toast.LENGTH_SHORT).show ();
                                break;
                            default:
                                Toast.makeText (mContext, "NEW COLOR", Toast.LENGTH_SHORT).show ();
                        }

                    }
                });
        return builder.create ();
    }
}
