package com.example.saveformetropicker;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by Maksym Galushka on 09.10.2016.
 */

class Storage {

    private static final String PREFS = "PREFS";
    private static final String KEY_STATION = "STATION";
    private static final String KEY_RADIO_BUTTON_INDEX = "RADIO_BUTTON";

    private Context mContext;
    private SharedPreferences mPrefs;

    Storage (Context context) {
        mContext = context;
        mPrefs = context.getSharedPreferences (PREFS, Context.MODE_PRIVATE);
    }

    void savePrefs (Intent data) {
        SharedPreferences.Editor editor = mPrefs.edit ();
        if ( data == null ) {
            // можно удалить ключ или записать новое значение. null андроид обработает быстрее
            // поскольку не будет сравнивать то что там будет, а проверит наличие ключа.
            editor.remove (KEY_STATION);
            editor.apply ();
        } else {
            editor.putString (KEY_STATION, data.getStringExtra ("ResultIntent"));
            editor.apply ();
        }
    }

    void loadStationField (TextView field) {
        String selectedStation = mPrefs.getString (KEY_STATION, null);
        if ( selectedStation != null ) {
            field.setText (selectedStation);
            Toast.makeText (mContext, selectedStation, Toast.LENGTH_SHORT).show ();
        } else {
            field.setText (R.string.no_saved_stations);
        }
    }

    void saveRadioButton (int rbIndex) {
        SharedPreferences.Editor editor = mPrefs.edit ();
        editor.putInt (KEY_RADIO_BUTTON_INDEX, rbIndex);
        editor.apply ();
        Toast.makeText (mContext, String.valueOf (rbIndex), Toast.LENGTH_SHORT).show ();
    }

    void loadRadioButton (RadioGroup radioButtonGroup) {
        int savedRadioButtonIndex = mPrefs.getInt (KEY_RADIO_BUTTON_INDEX, 0);
        RadioButton radioButton = (RadioButton) radioButtonGroup
                                                .getChildAt (savedRadioButtonIndex);
        radioButton.setChecked (true);
    }
}
