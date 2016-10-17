package com.example.controlssample;

import android.content.Context;
import android.content.SharedPreferences;
import android.widget.CheckBox;
import android.widget.ToggleButton;

/**
 * Created by Maksym Galushka on 11.10.2016.
 */

class Save {

    private static final String PREFS = "Prefs";
    private static final String KEY_CHECKBOX = "checkbox";
    private static final String KEY_TOGGLE_BUTTON = "tooglebutton";

    private SharedPreferences mPref;

    private CheckBox mCheckBox;
    private ToggleButton mToggleButton;

    Save (Context context) {
        mPref = context.getSharedPreferences (PREFS, Context.MODE_PRIVATE);
    }

    void init (CheckBox checkBox, ToggleButton toggleButton) {
        if ( mCheckBox == null )
            mCheckBox = checkBox;

        if ( mToggleButton == null )
            mToggleButton = toggleButton;
    }

    void savePosition (CheckBox checkBox, Boolean on) {
        SharedPreferences.Editor e = mPref.edit ();

        if ( on ) {
            e.putInt (KEY_CHECKBOX, 1);
            e.apply ();

            mCheckBox = checkBox;
        } else {
            e.remove (KEY_CHECKBOX);
            e.apply ();
        }
    }

    void savePosition (ToggleButton toggleButton, Boolean on) {
        SharedPreferences.Editor e = mPref.edit ();

        if ( on ) {
            e.putInt (KEY_TOGGLE_BUTTON, 1);
            e.apply ();

            mToggleButton = toggleButton;
        } else {
            e.remove (KEY_TOGGLE_BUTTON);
            e.apply ();
        }
    }

    void loadPosition () {
        if ( mPref.getInt (KEY_CHECKBOX, 0) == 1 ) {
            mCheckBox.setChecked (true);
        }

        if ( mPref.getInt (KEY_TOGGLE_BUTTON, 0) == 1 ) {
            mToggleButton.setChecked (true);
        }
    }
}
