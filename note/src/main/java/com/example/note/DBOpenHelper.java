package com.example.note;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Maksym Galushka on 28.10.2016.
 */

public class DBOpenHelper extends SQLiteOpenHelper {

    private static final String DB_NAME = "notes.db";
    private static final int DB_VERSION = 1;
    private static final String DB_TABLE = "notes";
    private static final String COLUMN_NOTE = "note";
    private static final String DB_CREATE = "create table"
            + DB_TABLE
            + "(_id INTEGER PRIMARY KEY AUTOINCREMENT,"
            + COLUMN_NOTE
            + "TEXT NOT NULL);";

    private Context mContext;


    public DBOpenHelper (Context context)
        /*,String name,SQLiteDatabase.CursorFactory factory,int version)*/ {
        super (context, DB_NAME, null, DB_VERSION);
        mContext = context;
    }

    @Override
    public void onCreate (SQLiteDatabase db) {
        db.execSQL (DB_CREATE);

        // TODO DELETE AFTER DEBUGGING
        // param '1' in ContentValues is how many columns create in start.
        // if null - auto create ~ 50.
        ContentValues values = new ContentValues (1);
        for ( int i = 1; i < 6; i++ ) {
            values.put (COLUMN_NOTE, "Note #" + i);
            db.insert (DB_TABLE, null, values);
        }
    }

    // when new version != ald version
    @Override
    public void onUpgrade (SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
