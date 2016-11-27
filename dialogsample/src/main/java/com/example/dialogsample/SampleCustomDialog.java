package com.example.dialogsample;

import android.app.AlertDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.widget.Toast;

/**
 * Created by Maksym Galushka on 14.11.2016.
 */
public class SampleCustomDialog extends DialogFragment {


    @Override
    public Dialog onCreateDialog (Bundle savedInstanceState) {

        LayoutInflater inflater = getActivity ().getLayoutInflater ();


        AlertDialog.Builder builder = new AlertDialog.Builder (getActivity ());

        builder.setTitle ("Who's there?")
                .setView (inflater.inflate (R.layout.dialog, null))
                .setPositiveButton ("Master here", new DialogInterface.OnClickListener () {
                    @Override
                    public void onClick (DialogInterface dialog, int which) {
                        Toast.makeText (getActivity (), "Master", Toast.LENGTH_SHORT).show ();
                    }
                })
                .setNegativeButton ("Cancel", new DialogInterface.OnClickListener () {
                    @Override
                    public void onClick (DialogInterface dialog, int which) {
                        Toast.makeText (getActivity (), "Canceled", Toast.LENGTH_SHORT).show ();
                    }
                });

        return builder.create ();
    }


}
