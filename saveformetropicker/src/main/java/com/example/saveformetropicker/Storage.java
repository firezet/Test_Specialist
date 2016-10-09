package com.example.saveformetropicker;

import android.content.Context;
import android.content.SharedPreferences;
import android.widget.Toast;

/**
 * Created by Maksym on 09.10.2016.
 */

public class Storage {
    private static final String PREFS = "PREFS";
    private static final String KEY_STATION_SELECTED = "STATION";

    Context mContext;
    SharedPreferences mPrefs;

    public void saveContext (Context context) {
        Toast.makeText(mContext, "save Context", Toast.LENGTH_SHORT).show();
    }

    public void savePrefs (Context context) {
        Toast.makeText(mContext, "save Prefs", Toast.LENGTH_SHORT).show();
    }

    public void loadPref (Context context) {
        Toast.makeText(mContext, "load Prefs", Toast.LENGTH_SHORT).show();
    }
}
