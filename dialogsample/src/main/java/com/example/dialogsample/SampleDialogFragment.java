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

public class SampleDialogFragment extends DialogFragment {

    private Context mContext;

    public SampleDialogFragment () {
        super();
    }

    public void setContext (Context c) {
        mContext = c;
    }

    @Override
    public Dialog onCreateDialog (Bundle savedInstanceState) {
        AlertDialog.Builder builder = new
                AlertDialog.Builder (getActivity ());

        builder.setTitle ("Мир несовершенен!")
                .setMessage ("Уничтожить вселенную?")
                .setIcon (R.drawable.tapas)

                .setPositiveButton ("Да", new DialogInterface
                .OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int
                                        which) {
                        // Уничтожаем вообще всё
                        Toast.makeText (mContext, "Kill", Toast.LENGTH_SHORT).show ();}
                })

                .setNegativeButton ("Нет", new DialogInterface.OnClickListener () {
                    @Override
                    public void onClick(DialogInterface dialog, int
                                        which) {
                        // Тихо уходим
                        Toast.makeText (mContext, "Move out", Toast.LENGTH_SHORT).show ();}
                })

                .setNeutralButton ("Не сейчас", new DialogInterface.OnClickListener () {
                    @Override
                    public void onClick (DialogInterface dialog, int
                            which) {
                        // Подождём
                        Toast.makeText (mContext, "Not now!", Toast.LENGTH_SHORT).show ();}
                });

        return builder.create ();
    }
}
