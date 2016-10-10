package com.example.saveformetropicker;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by Maksym Galushka on 09.10.2016.
 */

class Storage {

    private static final String PREFS = "PREFS";
    private static final String KEY_STATION = "STATION";

    private Context mContext;
    private SharedPreferences mPrefs;

    Storage ( Context context ) {
        mContext = context;
        mPrefs = context.getSharedPreferences ( PREFS, Context.MODE_PRIVATE );
    }

    void savePrefs ( Intent data ) {
        SharedPreferences.Editor editor = mPrefs.edit ();
        editor.putString ( KEY_STATION, data.getStringExtra ( "ResultIntent" ) );
        Toast.makeText ( mContext, "save + " + data.getStringExtra ( "ResultIntent" ), Toast.LENGTH_SHORT ).show ();
        editor.apply ();
    }

    void loadPref (TextView field) {
        String selectedStation = mPrefs.getString ( KEY_STATION, null );
        if ( selectedStation != null ) {
            field.setText ( selectedStation );
            Toast.makeText ( mContext, selectedStation, Toast.LENGTH_SHORT ).show ();
        } else {
            field.setText ( R.string.no_saved_stations );
        }
    }

    void clearKey () {
        SharedPreferences.Editor editor = mPrefs.edit ();
        editor.remove ( KEY_STATION );
        editor.apply ();
    }
}
